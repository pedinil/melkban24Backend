package ir.melkban24.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.melkban24.model.News;

/**
 * Created by pedi on 3/12/17.
 */
public interface NewsRepository extends JpaRepository<News,Double> {
	


}
