package com.resource;

import com.entity.Movie;
import com.resource.response.MovieResponse;
import com.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieResouce {

    private MovieService movieService;

    public MovieResouce() {
        movieService = new MovieService();
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "/{id}")
    public MovieResponse getMovieById(@PathVariable("id") int id) {
        return movieService.getMovie(id);
    }
}
