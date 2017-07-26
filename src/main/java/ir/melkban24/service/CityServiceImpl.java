package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.melkban24.model.City;
import ir.melkban24.repository.AgencyRepository;
import ir.melkban24.repository.CityRepository;


@Service
public class CityServiceImpl implements CityService {

	
    @Autowired
    private CityRepository cityRepository;
	

	
	
	@Override
	@Cacheable("listCityByState")
	public Page<City> listCityByPage(Pageable pageable) {

		return cityRepository.findAll(pageable);
	}




	@Override
	@Cacheable("getCityId")
	public City getCityId(String CityName, double stateId) {
		return cityRepository.findByNameCityContaining(CityName, stateId);
	}

	


}
