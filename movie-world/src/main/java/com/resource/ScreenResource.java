package com.resource;

import com.entity.enums.SeatType;
import com.resource.response.ScreenResponse;
import com.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ScreenResource {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/screen/{movieId}/{cinemaId}/{time}")
    public ScreenResponse getScreen(@PathVariable("movieId") int movieId,
                                    @PathVariable("cinemaId") int cinemaId,
                                    @PathVariable("time") int time) {
        return cinemaService.getScreen(movieId, cinemaId, time);
    }

    @PostMapping("/book/{movieId}/{cinemaId}/{time}")
    public Boolean bookSeat(@PathVariable("movieId") int movieId,
                            @PathVariable("cinemaId") int cinemaId,
                            @PathVariable("time") int time,
                            @RequestBody Map<SeatType, List<Integer>> seats) {
        return cinemaService.book(movieId, cinemaId, time, seats);
    }
}
