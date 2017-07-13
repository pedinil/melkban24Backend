package ir.melkban24.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.melkban24.model.Case;
import ir.melkban24.model.CaseSearch;
import ir.melkban24.service.CaseService;





@RestController
public class MelkSearchController {
	
	 @Autowired
	 private static final Logger logger= LoggerFactory.getLogger(MelkSearchController.class);

	@Autowired	
	private CaseService caseService;
	


	@RequestMapping(value = "/main/case/list/{inputString}", method = RequestMethod.GET)
	public  Page<CaseSearch> getListSearchCase(Pageable pageable,@PathVariable String inputString) {
	
		  Page<CaseSearch> casePage=this.caseService.listSearchCaseByString(pageable,inputString);
	        return casePage;
	}
	
	

}
