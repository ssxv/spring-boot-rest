package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Cinema {

    private Integer id;
    private String name;
    private String address;
    private List<Screen> screens;
    private List<Show> shows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonIgnore
    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @JsonIgnore
    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
