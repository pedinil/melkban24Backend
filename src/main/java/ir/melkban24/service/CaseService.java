package ir.melkban24.service;

import ir.melkban24.model.Case;
import ir.melkban24.model.CaseAdSearch;
import ir.melkban24.model.CaseSearch;
import ir.melkban24.model.Know;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


/**
 * Created by pedi on 3/13/17.
 */
public interface CaseService {
    Case findByIdCase(Double IdCase);
    

    Page<CaseSearch> listRandomSpecialOffer(Pageable pageable);
    
    Page<CaseSearch> listSearchCaseByString(Pageable pageable,CaseAdSearch caseAdSearch);
    
   
    
   
}