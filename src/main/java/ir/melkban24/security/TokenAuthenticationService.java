package ir.melkban24.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mehdi on 5/2/17.
 */
public class TokenAuthenticationService
{
    private static final Logger logger= LoggerFactory.getLogger(TokenAuthenticationService.class);
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET="melkban24.ir_secret_key";
    static final String TOKEN_PREFIX="Bearer";
    static final String HEADER_STRING="Authorization";

    static void addAuthentication(HttpServletResponse res, String username, Collection<? extends GrantedAuthority> authorities) {

        Claims claims=Jwts.claims().setSubject(username);
        claims.put("roles",authorities.stream().map(s->s.toString()).collect(Collectors.toList()));
        //String JWT= Jwts.builder().setSubject(username)
        String JWT= Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX+" "+JWT);
    }

    static Authentication getAuthentication(HttpServletRequest req) {
        String token=req.getHeader(HEADER_STRING);
        if(token!=null) {
            String user=Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody()
                    .getSubject();
            List<String> scopes=Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody().get("roles", List.class);
            List<GrantedAuthority> authorities=scopes.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
            logger.info("Granted Authorities : {}", authorities);
            return user!=null?new UsernamePasswordAuthenticationToken(user,null, authorities):null;
        }
        return null;
    }
}
