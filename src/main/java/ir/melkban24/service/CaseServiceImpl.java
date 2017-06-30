package ir.melkban24.service;

import ir.melkban24.model.Case;
import ir.melkban24.model.Know;
import ir.melkban24.model.News;
import ir.melkban24.repository.CaseRepository;
import ir.melkban24.repository.KnowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by pedi on 3/13/17.
 */
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;



  

    @Override
    public Case findByIdCase(Double IdCase) {
        return caseRepository.findByidcase(IdCase);
    }
    
    
   /* @Override
    public Page<Know> listAllByPage(Pageable pageable) {
    	


    	
    	return caseRepository.findAllByOrderByIdKnowDesc(pageable);
    }*/
}
