package ir.melkban24.service;



import ir.melkban24.model.Agency;
import ir.melkban24.model.News;
import ir.melkban24.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by pedi on 3/13/17.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public News findByIdNews(double IdNews) {
        return newsRepository.findOne(IdNews);
    }
    
    
    @Override
    public Page<News> listAllByPage(Pageable pageable) {
        return newsRepository.findAllByOrderByIdNewsDesc(pageable);
    }
}
