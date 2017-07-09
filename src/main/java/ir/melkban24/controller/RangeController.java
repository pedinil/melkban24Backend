package ir.melkban24.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ir.melkban24.model.Range;
import ir.melkban24.service.RangeService;




@RestController
public class RangeController {
	
	 @Autowired
	   private static final Logger logger= LoggerFactory.getLogger(RangeController.class);

	@Autowired	
	private RangeService rangeService;
	


	@RequestMapping(value = "/main/range/list", method = RequestMethod.GET)
	public  Page<Range> getListRange(Pageable pageable) {
	
		  Page<Range> rangePage=this.rangeService.listRangeByPage(pageable);
	        return rangePage;
	}
	
	
/*	@RequestMapping(value = "/range/json", method = RequestMethod.GET)
	public  ResponseEntity<List<Range>> getListRange(Model model) {
	
		List<Range> f=this.rangeService.listRange();
		
		  return new ResponseEntity<List<Range>>(f, HttpStatus.OK);
	}
	
	
 
	@RequestMapping(value = "/range/json/{IdArea}", method = RequestMethod.GET)
	public  ResponseEntity<List<Range>> getListRangeByCity(@PathVariable double IdArea) {
	
		List<Range> f=this.rangeService.listRangeByArea(IdArea);
		
		  return new ResponseEntity<List<Range>>(f, HttpStatus.OK);
	}
	*/
}
