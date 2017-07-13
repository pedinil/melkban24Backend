package ir.melkban24.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.melkban24.model.Area;



public interface AreaService {
	
	public Page<Area> listAreaByPage(Pageable pageable);
	
/*	public List<Area> listArea();
	
	public List<Area> listAreaByCity(double CityID);
	*/
	public Area getAreaId(String AreaName,double CityID);

}
