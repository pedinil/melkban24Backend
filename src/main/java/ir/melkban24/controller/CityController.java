package ir.melkban24.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.melkban24.model.Case;
import ir.melkban24.model.City;
import ir.melkban24.model.Know;
import ir.melkban24.service.CityService;





@RestController
@EnableCaching
public class CityController {
	
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(KnowController.class);
    
    
	@Autowired
	private CityService cityService;
	

	
	@RequestMapping(value = "/main/city/list", method = RequestMethod.GET)
	public  Page<City> getListCity(Pageable pageable) {
	
		  Page<City> cityPage=this.cityService.listCityByPage(pageable);
	        return cityPage;
	}

}
