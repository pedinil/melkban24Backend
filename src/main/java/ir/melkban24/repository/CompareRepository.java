package ir.melkban24.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ir.melkban24.model.CaseCompare;




/**
 * Created by pedi on 3/12/17.
 */
public interface CompareRepository extends JpaRepository<CaseCompare,Double> {
	
	 @Query("Select c from CaseCompare c where c.IdCase in (:idF,:idS,:idT) ")
	 List<CaseCompare> findListCompare(@Param("idF")Double idF, @Param("idS")Double idS,@Param("idT")Double idT);
}
