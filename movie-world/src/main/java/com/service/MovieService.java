package com.service;

import com.entity.Cinema;
import com.entity.Movie;
import com.entity.Show;
import com.resource.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieService extends Service {

    private CinemaService cinemaService;

    public MovieService() {
        cinemaService = new CinemaService();
    }

    public List<Movie> getAllMovies() {
        return MOVIE_LIST;
    }

    public MovieResponse getMovie(int id) {
        MovieResponse movieResponse = new MovieResponse();
        Movie movie = getMovieById(id);
        if (movie != null) {
            movieResponse.setMovie(movie);
            movieResponse.setCinemas(cinemaService.getCinemasForMovieId(movie.getId()));
        }
        return movieResponse;
    }

    public Movie getMovieById(int id) {
        for (Movie movie : MOVIE_LIST) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
}
