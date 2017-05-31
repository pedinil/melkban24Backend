package ir.melkban24.repository;

import ir.melkban24.model.Know;
import ir.melkban24.model.Role;
import ir.melkban24.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pedi on 3/12/17.
 */
public interface KnowRepository extends JpaRepository<Know,Double> {
	
	 public Page<Know> findAllByOrderByIdKnowDesc(Pageable pageable);
	 
	 
}
