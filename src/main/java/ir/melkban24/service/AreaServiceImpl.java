package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.melkban24.model.Area;
import ir.melkban24.model.City;
import ir.melkban24.repository.AreaRepository;
import ir.melkban24.repository.CityRepository;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	
	
	
	@Override
	public Page<Area> listAreaByPage(Pageable pageable) {

		return areaRepository.findAll(pageable);
	}
	

	/*@Override


	
	@Override
	@Cacheable("listAreaByCity")
	public List<Area> listAreaByCity(double IdCity) {
		return this.areaDAO.listAreaByCity(IdCity);
	}

	@Override
	@Cacheable("getAreaId")
	public Area getAreaId(String AreaName,double CityID) {
		return this.areaDAO.getAreaId(AreaName,CityID);
	}*/

}
