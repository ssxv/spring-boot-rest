package com.resource.response;

import com.entity.Cinema;
import com.entity.Movie;
import com.entity.enums.Certificate;
import com.entity.enums.Language;

import java.util.List;

public class MovieResponse {

    private Movie movie;
    private List<Cinema> cinemas;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
