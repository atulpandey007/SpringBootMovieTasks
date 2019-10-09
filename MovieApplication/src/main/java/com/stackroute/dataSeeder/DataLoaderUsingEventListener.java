package com.stackroute.dataSeeder;

import com.stackroute.Exception.MovieAlreadyExistsException;
import com.stackroute.domain.Movie;
import com.stackroute.services.MovieService;
import com.stackroute.services.MovieService;

import com.stackroute.Exception.MovieAlreadyExistsException;
import com.stackroute.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderUsingEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger= LoggerFactory.getLogger(DataLoaderImplCmdLine.class);
    private MovieService movieService;


    private Movie movie=new Movie();

    public DataLoaderUsingEventListener(MovieService movieService){
        this.movieService=movieService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movie.setId(2);
        movie.setTitle("sholay");

        movieService.saveMovie(movie);

    }
}
