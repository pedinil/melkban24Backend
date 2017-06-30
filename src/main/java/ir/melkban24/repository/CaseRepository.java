package ir.melkban24.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ir.melkban24.model.Case;

/**
 * Created by pedi on 3/12/17.
 */
public interface CaseRepository extends JpaRepository<Case,Double> {
	

	 public Case findByidcase(Double idCase);
	 
	 
	
	
	 
}
