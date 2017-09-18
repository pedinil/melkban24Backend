package ir.melkban24.service;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ir.melkban24.model.CaseLocation;


/**
 * Created by pedi on 3/13/17.
 */
public interface LocactionCaseService {
   
    

    Page<CaseLocation> listCasebyLocation(Pageable pageable,double lat, double lon);
    
   
    
   
    
   
}