package com.stackroute.controller;

import com.stackroute.domain.Movie;

import com.stackroute.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getMovie")
    public ResponseEntity<?> getAllMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie,@PathVariable int id) {

        try {
            movieService.updateMovie(movie,id);
            return new ResponseEntity<Movie>(movieService.updateMovie(movie,id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId) {
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovie(movieId);
            responseEntity = new ResponseEntity<String>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
}