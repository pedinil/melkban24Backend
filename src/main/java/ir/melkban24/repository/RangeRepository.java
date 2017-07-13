package ir.melkban24.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ir.melkban24.model.Area;
import ir.melkban24.model.City;
import ir.melkban24.model.Range;



/**
 * Created by pedi on 3/12/17.
 */
public interface RangeRepository extends JpaRepository<Range,Double> {
	

	@Query("Select c from Range c where c.IdArea = :IdArea and c.NameRange like:inputString")
	Range findByNameRangeContaining(@Param("inputString")String inputString,@Param("IdArea")Double IdArea);

}
