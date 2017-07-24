package com.entity;

import com.entity.enums.SeatType;

import java.util.Map;

public class Show {

    private Integer time;
    private Integer movieId;
    private Integer screenId;
    private Map<SeatType, Integer> rate;

    public Show(Integer time, Integer movieId, Integer screenId, Map<SeatType, Integer> rate) {
        this.time = time;
        this.movieId = movieId;
        this.screenId = screenId;
        this.rate = rate;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public Map<SeatType, Integer> getRate() {
        return rate;
    }

    public void setRate(Map<SeatType, Integer> rate) {
        this.rate = rate;
    }
}
