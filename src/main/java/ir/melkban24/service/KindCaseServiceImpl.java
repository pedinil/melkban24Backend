package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ir.melkban24.model.KindCase;
import ir.melkban24.repository.CityRepository;
import ir.melkban24.repository.KindCaseRepository;

@Service
public class KindCaseServiceImpl implements KindCaseService{

	@Autowired
	private KindCaseRepository kindcaseRepository;

	@Override
	public List<KindCase> listKindCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KindCase getKindCaseId(String CaseKindName) {
		return this.kindcaseRepository.findByNameKindCaseContaining(CaseKindName);

	}

	

	


	
	
	
}
