package ir.melkban24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.melkban24.model.Range;
import ir.melkban24.model.State;
import ir.melkban24.service.StateService;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	

	
	@RequestMapping(value = "/main/state/list", method = RequestMethod.GET)
	public  Page<State> getListState(Pageable pageable) {
	
		 Page<State> rangePage=this.stateService.listStateByPage(pageable);
	        return rangePage;
	}
	
	


	
/*	
	@RequestMapping(value = "/state/json", method = RequestMethod.GET)
	public  ResponseEntity<List<State>> getListState(Model model) {
	
		List<State> f=this.stateService.listState();
		
		  return new ResponseEntity<List<State>>(f, HttpStatus.OK);
	}*/
	
	
}
