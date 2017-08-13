package ir.melkban24.controller;



import ir.melkban24.model.CaseCompare;
import ir.melkban24.model.News;
import ir.melkban24.service.CompareService;
import ir.melkban24.service.NewsService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


/**
 * Created by pedi on 5/27/17.
 */
@RestController
public class CompareController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(CompareController.class);

    @Autowired
    private CompareService compareService;

 
    
    
    
    @RequestMapping(value = "/main/compare/{idF}/{idS}/{idT}", method = RequestMethod.GET)
    public ResponseEntity<List<CaseCompare>> getListCompare(@PathVariable Double idF,@PathVariable Double idS,@PathVariable Double idT) {
    	List<CaseCompare> listCaseCompare=this.compareService.getListCompare(idF,idS,idT);
        if(listCaseCompare==null)
            return new ResponseEntity<List<CaseCompare>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<CaseCompare>>(listCaseCompare,HttpStatus.OK);
    }

    @RequestMapping(value = "/main/compare/{idF}/{idS}", method = RequestMethod.GET)
    public ResponseEntity<List<CaseCompare>> getListCompare(@PathVariable Double idF,@PathVariable Double idS) {
    	List<CaseCompare> listCaseCompare=this.compareService.getListCompare(idF,idS,null);
        if(listCaseCompare==null)
            return new ResponseEntity<List<CaseCompare>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<CaseCompare>>(listCaseCompare,HttpStatus.OK);
    }

}
