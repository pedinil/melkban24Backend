package ir.melkban24.repository;

import ir.melkban24.model.Know;
import ir.melkban24.model.Role;
import ir.melkban24.model.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by pedi on 3/12/17.
 */
public interface KnowRepository extends JpaRepository<Know,Double> {
	

	
	 @Query("SELECT idKnow,SubjectKnow FROM Know")
	 public Page<Know> findCByOrderByIdKnowDesc(Pageable pageable);
	
	
	 public Page<Know> findAllByOrderByIdKnowDesc(Pageable pageable);
	 
	 
	 
	
	 
	
	/* @Query(value="SELECT idKnow,SubjectKnow,ImgKnow,CountView FROM TblKnow order by rand() \n#pageable\n",
			 countQuery = "SELECT count(*) FROM TblKnow" ,
			 nativeQuery=true) 
	 public Page<Know> findCByOrderByIdKnowDesc(Pageable pageable);*/
	 
}
