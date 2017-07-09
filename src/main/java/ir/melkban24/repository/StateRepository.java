package ir.melkban24.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.melkban24.model.City;
import ir.melkban24.model.Range;
import ir.melkban24.model.State;



/**
 * Created by pedi on 3/12/17.
 */
public interface StateRepository extends JpaRepository<State,Double> {
	

}