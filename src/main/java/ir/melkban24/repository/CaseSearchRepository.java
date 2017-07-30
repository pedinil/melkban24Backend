package ir.melkban24.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import ir.melkban24.model.CaseSearch;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by mehdi on 7/30/17.
 */
public interface CaseSearchRepository extends JpaRepository<CaseSearch,Double>, JpaSpecificationExecutor<CaseSearch>{
    Page<CaseSearch> findAll(Specification<CaseSearch> spec, Pageable pageable);
}
