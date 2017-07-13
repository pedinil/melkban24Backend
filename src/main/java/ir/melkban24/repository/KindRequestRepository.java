package ir.melkban24.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ir.melkban24.model.KindRequest;



/**
 * Created by pedi on 3/12/17.
 */
public interface KindRequestRepository extends JpaRepository<KindRequest,Double> {


	 @Query("Select c from KindRequest c where c.NameKindRequest like:inputString")
     KindRequest findByNameKindRequestContaining(@Param("inputString")String inputString);
	

}
