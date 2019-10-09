package com.stackroute.services;

import com.stackroute.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {


    public Movie saveMovie(Movie movie);

    public List<Movie> getAllMovies();

    public Movie updateMovie(Movie movie, int id);


    public boolean deleteMovie(int id) ;

    public Optional<Movie> getMovieById(int id);

    List<Movie> getByName(String title);
}
