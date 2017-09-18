package ir.melkban24.service;



import ir.melkban24.model.CaseLocation;
import ir.melkban24.repository.CaseLocationSearchRepository;
import ir.melkban24.repository.CaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;





/**
 * Created by pedi on 3/13/17.
 */

@Service
public class LocationCaseServiceImpl implements LocactionCaseService {

	@Autowired
	private static final Logger logger= LoggerFactory.getLogger(LocactionCaseService.class);

	@Autowired
	private CaseLocationSearchRepository caseLocationSearchRepository;
	

	@Override
	public Page<CaseLocation> listCasebyLocation(Pageable pageable,double lat, double lon) {
	
		return this.caseLocationSearchRepository.findCaseNearByLoc( pageable,lat, lon);
	}

    









	

	
	
}
