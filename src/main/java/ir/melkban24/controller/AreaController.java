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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ir.melkban24.model.Area;
import ir.melkban24.model.City;
import ir.melkban24.service.AreaService;
import ir.melkban24.service.CityService;






@RestController
public class AreaController {

	
	
	
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(AreaController.class);
    
    

	@Autowired
	private AreaService areaService;
	
	
	
	
	@RequestMapping(value = "/main/area/list", method = RequestMethod.GET)
	public  Page<Area> getListArea(Pageable pageable) {
	
		  Page<Area> areaPage=this.areaService.listAreaByPage(pageable);
	        return areaPage;
	}
	
	
/*	@RequestMapping(value = "/area/json", method = RequestMethod.GET)
	public  ResponseEntity<List<Area>> getListArea(Model model) {
	
		List<Area> f=this.areaService.listArea();
		
		  return new ResponseEntity<List<Area>>(f, HttpStatus.OK);
	}
	
	
 
	@RequestMapping(value = "/area/json/{CityID}", method = RequestMethod.GET)
	public  ResponseEntity<List<Area>> getListAreaByCity(@PathVariable double CityID) {
	
		List<Area> f=this.areaService.listAreaByCity(CityID);
		
		  return new ResponseEntity<List<Area>>(f, HttpStatus.OK);
	}*/
	
}
