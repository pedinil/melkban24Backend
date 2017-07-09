package ir.melkban24.controller;



import ir.melkban24.model.News;
import ir.melkban24.service.NewsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


/**
 * Created by pedi on 5/27/17.
 */
@RestController
public class NewsController {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

 
    @RequestMapping(value = "/main/news/list",method = RequestMethod.GET)
    public Page<News> list(Pageable pageable) {
    	
    
        Page<News> news=newsService.listAllByPage(pageable);
        return news;
    }
    
    
    @RequestMapping(value = "/main/news/{id}", method = RequestMethod.GET)
    public ResponseEntity<News> getNews(@PathVariable Long id) {
        News news=this.newsService.findByIdNews(id);
        if(news==null)
            return new ResponseEntity<News>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<News>(news,HttpStatus.OK);
    }


}
