package com.stackroute.services;

import com.stackroute.MovieRepository.MovieRepository;
import com.stackroute.domain.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie, int id) {
        Optional<Movie> useropt =movieRepository.findById(id);
        movie.setId(id);
        movieRepository.save(movie);

        return movie;
    }



    @Override
    public boolean deleteMovie(int id) {
        if (getMovieById(id) != null) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> getByName(String title) {
        return null;
    }
}