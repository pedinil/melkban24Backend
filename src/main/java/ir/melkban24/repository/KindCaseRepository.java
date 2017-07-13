package ir.melkban24.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ir.melkban24.model.KindCase;




/**
 * Created by pedi on 3/12/17.
 */
public interface KindCaseRepository extends JpaRepository<KindCase,Double> {
	
	
	 @Query("Select c from KindCase c where c.NameKindCase like:inputString")
	 KindCase findByNameKindCaseContaining(@Param("inputString")String inputString);
	
	
}
