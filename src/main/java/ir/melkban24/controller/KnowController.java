package ir.melkban24.controller;

import ir.melkban24.model.Contact;
import ir.melkban24.model.Know;
import ir.melkban24.model.News;
import ir.melkban24.repository.ContactRepository;
import ir.melkban24.service.AgentService;
import ir.melkban24.service.KnowService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by pedi on 5/27/17.
 */
@RestController
public class KnowController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(KnowController.class);

    @Autowired
    private KnowService knowService;

    /**
     * Get Contact
     * @param id
     * @return
     */
    @RequestMapping(value = "/main/know/{id}", method = RequestMethod.GET)
    public ResponseEntity<Know> getKnow(@PathVariable Long id) {
        Know know=this.knowService.findByIdKnow(id);
        if(know==null)
            return new ResponseEntity<Know>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Know>(know,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/main/know/list",method = RequestMethod.GET)
    public Page<Know> list(Pageable pageable) {
    	
    	 
        Page<Know> know=this.knowService.listAllByPage(pageable);
        return know;
    }


}
