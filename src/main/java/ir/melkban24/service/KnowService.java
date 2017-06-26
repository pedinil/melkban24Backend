package ir.melkban24.service;

import ir.melkban24.model.Know;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by pedi on 3/13/17.
 */
public interface KnowService {
    
    Know findByIdKnow(double IdKnow);
    
    Page<Know> listAllByPage(Pageable pageable);
    
    
}
