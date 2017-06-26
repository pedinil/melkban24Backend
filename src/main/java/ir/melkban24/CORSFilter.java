package ir.melkban24;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Component
public class CORSFilter implements Filter{

	
	 static Logger logger = LoggerFactory.getLogger(CORSFilter.class);

	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	        HttpServletResponse response = (HttpServletResponse) res;
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        //response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	        response.setHeader("Access-Control-Expose-Headers", "Content-Type, Access-Control-Expose-Headers, Authorization, X-Requested-With");
	        chain.doFilter(request, response);
	        logger.info(request.getRemoteAddr());
	    }

	    public void destroy() {}

	
	
}
