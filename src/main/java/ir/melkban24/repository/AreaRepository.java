package ir.melkban24.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ir.melkban24.model.Area;




/**
 * Created by pedi on 3/12/17.
 */
public interface AreaRepository extends JpaRepository<Area,Double> {
	
	@Query("Select c from Area c where c.IdCity = :IdCity and c.NameArea like:inputString")
	Area findByNameRangeContaining(@Param("inputString")String inputString,@Param("IdCity")Double IdCity);
	
}
