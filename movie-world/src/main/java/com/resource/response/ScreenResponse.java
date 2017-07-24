package com.resource.response;

import com.entity.Cinema;
import com.entity.Movie;
import com.entity.Screen;
import com.entity.Show;
import com.entity.enums.SeatType;

import java.util.Map;

public class ScreenResponse {

    private Integer time;
    private Cinema cinema;
    private Movie movie;
    private Map<SeatType, Map<Integer, Boolean>> seatLayout;
    private Map<SeatType, Integer> rate;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Map<SeatType, Map<Integer, Boolean>> getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(Map<SeatType, Map<Integer, Boolean>> seatLayout) {
        this.seatLayout = seatLayout;
    }

    public Map<SeatType, Integer> getRate() {
        return rate;
    }

    public void setRate(Map<SeatType, Integer> rate) {
        this.rate = rate;
    }
}
