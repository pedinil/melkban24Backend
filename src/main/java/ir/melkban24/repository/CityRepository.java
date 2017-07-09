package ir.melkban24.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.melkban24.model.City;



/**
 * Created by pedi on 3/12/17.
 */
public interface CityRepository extends JpaRepository<City,Double> {
	
	

}
