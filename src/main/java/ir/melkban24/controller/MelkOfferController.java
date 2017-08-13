package ir.melkban24.controller;



import ir.melkban24.model.Case;
import ir.melkban24.model.Contact;
import ir.melkban24.service.CaseService;

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
public class MelkOfferController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(MelkOfferController.class);

    @Autowired
    private CaseService caseService;

    /**
     * Get Contact
     * @param id
     * @return
     */
    @RequestMapping(value = "/main/melkoffer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Case> getCase(@PathVariable double id) {
    	
    	Case caseObj = this.caseService.findByIdCase(id);
        if(caseObj==null)
            return new ResponseEntity<Case>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<Case>(caseObj,HttpStatus.OK);
    }
    
    
  
    
    
/*    @RequestMapping(value = "/main/know/list",method = RequestMethod.GET)
    public Page<Know> list(Pageable pageable) {
    	
    	 
        Page<Know> know=this.knowService.listAllByPage(pageable);
        return know;
    }*/


}
