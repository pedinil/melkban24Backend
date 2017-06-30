package ir.melkban24.service;

import ir.melkban24.model.Case;
import ir.melkban24.model.Know;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by pedi on 3/13/17.
 */
public interface CaseService {
    
    Case findByIdCase(Double IdCase);
    
    //Page<Know> listAllByPage(Pageable pageable);
    
    
}
