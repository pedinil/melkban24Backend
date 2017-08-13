package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ir.melkban24.model.CaseCompare;

import ir.melkban24.repository.CompareRepository;


@Service
public class CompareServiceImpl implements CompareService {

	
    @Autowired
    private CompareRepository compareRepository;
	
	@Override
	public List<CaseCompare> getListCompare(Double idF, Double idS, Double idT) {
		
		return this.compareRepository.findListCompare(idF, idS, idT);
	}




	


}
