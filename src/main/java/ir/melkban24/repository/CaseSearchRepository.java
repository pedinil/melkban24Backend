package ir.melkban24.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import ir.melkban24.model.CaseSearch;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Created by mehdi on 7/30/17.
 */
public interface CaseSearchRepository extends JpaRepository<CaseSearch,Double>, JpaSpecificationExecutor<CaseSearch>{
    
	
	@Query("select a from CaseSearch a where pic1 like 'http%' order by RAND()")
	Page<CaseSearch> findRandamCaseSearch(Pageable pageable);
    
    Page<CaseSearch> findAll(Specification<CaseSearch> spec, Pageable pageable);
}
