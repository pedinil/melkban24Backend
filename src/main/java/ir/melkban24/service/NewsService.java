package ir.melkban24.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.melkban24.model.News;

/**
 * Created by pedi on 3/13/17.
 */
public interface NewsService {
    
    News findByIdNews(double IdKnow);
    
    Page<News> listAllByPage(Pageable pageable);
}
