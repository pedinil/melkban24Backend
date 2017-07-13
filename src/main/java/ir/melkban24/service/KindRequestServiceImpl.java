package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ir.melkban24.model.KindRequest;
import ir.melkban24.repository.KindCaseRepository;
import ir.melkban24.repository.KindRequestRepository;


@Service
public class KindRequestServiceImpl implements KindRequestService{

	@Autowired
	private KindRequestRepository kindrequestRepository;



	@Override
	public KindRequest getKindRequestId(String KindRequestName) {
		
		return this.kindrequestRepository.findByNameKindRequestContaining(KindRequestName);
	}



	@Override
	public List<KindRequest> listKindRequest() {
		// TODO Auto-generated method stub
		return null;
	}




}
