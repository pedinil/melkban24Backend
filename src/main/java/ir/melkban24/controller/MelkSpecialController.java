package ir.melkban24.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.melkban24.model.Case;
import ir.melkban24.model.CaseAdSearch;
import ir.melkban24.model.CaseCompare;
import ir.melkban24.model.CaseSearch;
import ir.melkban24.model.Contact;
import ir.melkban24.service.CaseService;





@RestController
public class MelkSpecialController {
	
	 @Autowired
	 private static final Logger logger= LoggerFactory.getLogger(MelkSpecialController.class);

	@Autowired	
	private CaseService caseService;
	



	
	
	  @RequestMapping(value = "/main/melkspecial/list", method = RequestMethod.GET)
	    public Page<CaseSearch> getListMelkSpecial(Pageable pageable)
	    {

		  Page<CaseSearch> casePage=this.caseService.listRandomSpecialOffer(pageable);
	        return casePage;
 
	    }
	
	  
	  
	

}
