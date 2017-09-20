package ir.melkban24.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.melkban24.model.CaseLocation;
import ir.melkban24.model.CaseSearch;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mehdi on 7/30/17.
 */
public interface CaseLocationSearchRepository extends JpaRepository<CaseLocation,Double>, JpaSpecificationExecutor<CaseLocation>{
    
	
	@Query("select a from CaseLocation a  where  SQRT(POWER(Lat - :Latinput, 2) + POWER(Lon - :Loninput, 2)) <0.01 order by SQRT(POWER(Lat - :Latinput, 2) + POWER(Lon - :Loninput, 2)) desc  ")
	//@Query("select a from CaseLocation a  where  Lat = :Latinput and Lon = :Loninput ")
	Page<CaseLocation> findCaseNearByLoc(Pageable pageable,@Param("Latinput")double Latinput,@Param("Loninput")double Loninput);
    
   
}
