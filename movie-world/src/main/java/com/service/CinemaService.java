package com.service;

import com.entity.Cinema;
import com.entity.Screen;
import com.entity.Show;
import com.entity.enums.SeatType;
import com.resource.response.ScreenResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class CinemaService extends Service {

    public List<Cinema> getAllCinemas() {
        return CINEMA_LIST;
    }

    /**
     * method to get List of Cinemas for a movie based on movie Id.
     *
     * @param movieId
     * @return
     */
    public List<Cinema> getCinemasForMovieId(Integer movieId) {
        List<Cinema> cinemaList = new ArrayList<>();

        for (Cinema c : CINEMA_LIST) {
            Cinema cinema = filterCinemaForMovieId(c, movieId);
            if (cinema != null) {
                cinemaList.add(cinema);
            }
        }
        return cinemaList;
    }

    /**
     * Get a cinema for a movieId, from Shows
     *
     * @param c
     * @param movieId
     * @return
     */
    private Cinema filterCinemaForMovieId(Cinema c, Integer movieId) {
        List<Show> showList = getShowsInCinemaByMovieId(c, movieId);
        if (!showList.isEmpty()) {
            Cinema cinema = new Cinema();
            cinema.setId(c.getId());
            cinema.setName(c.getName());
            cinema.setAddress(c.getAddress());
            cinema.setScreens(c.getScreens());
            cinema.setShows(showList);
            return cinema;
        }
        return null;
    }

    /**
     * method to get Shows in a Cinema, by movie Id.
     *
     * @param c
     * @param movieId
     * @return
     */
    private List<Show> getShowsInCinemaByMovieId(Cinema c, int movieId) {
        List<Show> showList = new ArrayList<>();
        for (Show show : c.getShows()) {
            if (show.getMovieId() == movieId) {
                showList.add(show);
            }
        }
        return showList;
    }

    /**
     * method to get Screen with seat layout, for a show.
     *
     * @param movieId
     * @param cinemaId
     * @param time
     * @return
     */
    public ScreenResponse getScreen(int movieId, int cinemaId, int time) {
        ScreenResponse screenResponse = new ScreenResponse();
        Cinema cinema = getCinemaById(cinemaId);
        if (cinema != null) {
            List<Show> showList = getShowsInCinemaByMovieId(cinema, movieId);
            if (!showList.isEmpty()) {
                for (Show show : showList) {
                    if (show.getTime() == time) {
                        Screen screen = getScreenInCinemaById(cinema, show.getScreenId());
                        if (screen != null) {
                            screenResponse.setTime(time);
                            screenResponse.setCinema(cinema);
                            screenResponse.setMovie(new MovieService().getMovieById(movieId));
                            screenResponse.setSeatLayout(screen.getSeatLayout());
                            screenResponse.setRate(show.getRate());
                        }
                    }
                }
            }
        }
        return screenResponse;
    }

    /**
     * method to get Screen in a cinema, by screen Id.
     *
     * @param cinema
     * @param screenId
     * @return
     */
    private Screen getScreenInCinemaById(Cinema cinema, int screenId) {
        for (Screen screen : cinema.getScreens()) {
            if (screen.getId() == screenId) {
                return screen;
            }
        }
        return null;
    }

    /**
     * Get Cinema by Id.
     *
     * @param cinemaId
     * @return
     */
    private Cinema getCinemaById(int cinemaId) {
        for (Cinema cinema : CINEMA_LIST) {
            if (cinema.getId() == cinemaId) {
                return cinema;
            }
        }
        return null;
    }

    /**
     * Book a seat in a screen for a show.
     *
     * @param movieId
     * @param cinemaId
     * @param time
     * @param seats
     * @return
     */
    public Boolean book(int movieId, int cinemaId, int time, Map<SeatType, List<Integer>> seats) {
        Cinema cinema = getCinemaById(cinemaId);
        if (cinema != null) {
            List<Show> showList = getShowsInCinemaByMovieId(cinema, movieId);
            if (!showList.isEmpty()) {
                for (Show show : showList) {
                    if (show.getTime() == time) {
                        Screen screen = getScreenInCinemaById(cinema, show.getScreenId());
                        if (screen != null) {
                            try {
                                return bookSeatInScreen(screen, seats);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Sets the seat boolean to true for a screen based on seatRequest.
     *
     * @param screen
     * @param seats
     * @return
     * @throws Exception
     */
    private Boolean bookSeatInScreen(Screen screen, Map<SeatType, List<Integer>> seats) throws Exception {
        Map<SeatType, Map<Integer, Boolean>> seatLayout = screen.getSeatLayout();
        for (SeatType seatType : seats.keySet()) {
            for (Integer seatNumber : seats.get(seatType)) {
                seatLayout.get(seatType).put(seatNumber, true);
            }
        }
        return true;
    }
}
