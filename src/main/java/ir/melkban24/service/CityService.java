package ir.melkban24.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.melkban24.model.City;





public interface CityService {
	
	public Page<City> listCityByPage(Pageable pageable);
	
/*	public List<City> listCityByState(double stateId);
*/	
	public City getCityId(String CityName,double stateId);

}
