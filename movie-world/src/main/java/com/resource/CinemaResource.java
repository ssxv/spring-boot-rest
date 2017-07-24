package com.resource;

import com.entity.Cinema;
import com.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cinema")
public class CinemaResource {

    private CinemaService cinemaService;

    public CinemaResource() {
        cinemaService = new CinemaService();
    }

    @GetMapping
    public List<Cinema> getCinemas() {
        return cinemaService.getAllCinemas();
    }
}
