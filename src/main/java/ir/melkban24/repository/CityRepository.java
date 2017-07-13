package ir.melkban24.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ir.melkban24.model.City;
import ir.melkban24.model.State;



/**
 * Created by pedi on 3/12/17.
 */
public interface CityRepository extends JpaRepository<City,Double> {
	
	@Query("Select c from City c where c.idstate = :stateId and c.NameCity like:inputString")
	City findByNameCityContaining(@Param("inputString")String inputString,@Param("stateId")Double stateId);

}
