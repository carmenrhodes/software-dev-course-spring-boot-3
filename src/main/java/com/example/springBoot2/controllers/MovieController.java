package com.example.springBoot2.controllers;

import com.example.springBoot2.repositories.MovieRepository;
import com.example.springBoot2.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private com.example.springBoot2.repositories.MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}