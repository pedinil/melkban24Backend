package ir.melkban24.controller;




import ir.melkban24.model.CaseLocation;

import ir.melkban24.service.LocactionCaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;


/**
 * Created by pedi on 5/27/17.
 */
@RestController
public class NearByLocController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(NearByLocController.class);

    @Autowired
    private LocactionCaseService locactionCaseService;

    /**
     * Get locactionCaseService
     * @param id
     * @return
     */
    @RequestMapping(value = "/main/nearmelk/{lat}/{lon}", method = RequestMethod.GET)
    public Page<CaseLocation> getListNearByLocation(Pageable pageable,@PathVariable double lat,@PathVariable double lon) {
    	
    	  Page<CaseLocation> caseLocationPage=this.locactionCaseService.listCasebyLocation(pageable,lat,lon);
	        return caseLocationPage;
    }
    
    
  
    
    



}
