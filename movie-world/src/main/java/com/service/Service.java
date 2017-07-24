package com.service;

import com.entity.*;
import com.entity.enums.Certificate;
import com.entity.enums.Genre;
import com.entity.enums.Language;
import com.entity.enums.SeatType;

import java.util.*;

public class Service {

    public static List<Movie> MOVIE_LIST = new ArrayList<>();
    public static List<Cinema> CINEMA_LIST = new ArrayList<>();

    static {
        prepareDummyMovies();
        prepareDummyCinemas();
    }

    /**
     * prepare list of dummy cinemas.
     * ideally this should pop from database.
     */
    private static void prepareDummyCinemas() {

        // cinema 1
        Cinema cinema = new Cinema();
        cinema.setId(1);
        cinema.setName("Cineplex - Kothrud");
        cinema.setAddress("Kothrud, Pune");

        // preparing this for use in Screen.
        Map<SeatType, Map<Integer, Boolean>> seatLayout = new HashMap<>();
        seatLayout.put(SeatType.SILVER, initializeSeatMap(10));
        seatLayout.put(SeatType.GOLD, initializeSeatMap(10));
        seatLayout.put(SeatType.PLATINUM, initializeSeatMap(10));
        seatLayout.put(SeatType.ROYAL, initializeSeatMap(10));

        List<Screen> screenList = new ArrayList<>();
        Screen screen = new Screen();
        screen.setId(1);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        screen = new Screen();
        screen.setId(2);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        cinema.setScreens(screenList);

        Map<SeatType, Integer> rate = new HashMap<>();
        rate.put(SeatType.SILVER, 150);
        rate.put(SeatType.GOLD, 180);
        rate.put(SeatType.PLATINUM, 220);
        rate.put(SeatType.ROYAL, 250);

        List<Show> showList = new ArrayList<>();
        Show show = new Show(9, 1, 1, rate);
        showList.add(show);
        show = new Show(9, 5, 2, rate);
        showList.add(show);
        show = new Show(12, 1, 1, rate);
        showList.add(show);
        show = new Show(12, 5, 2, rate);
        showList.add(show);
        show = new Show(15, 1, 1, rate);
        showList.add(show);
        show = new Show(15, 5, 2, rate);
        showList.add(show);
        show = new Show(18, 1, 1, rate);
        showList.add(show);
        show = new Show(18, 5, 2, rate);
        showList.add(show);
        show = new Show(21, 1, 1, rate);
        showList.add(show);
        show = new Show(21, 5, 2, rate);
        showList.add(show);

        cinema.setShows(showList);
        CINEMA_LIST.add(cinema);

        // cinema 2
        cinema = new Cinema();
        cinema.setId(2);
        cinema.setName("E Square - Shivaji Nagar");
        cinema.setAddress("Shivaji Nagar, Pune");

        // preparing this for use in Screen.
        seatLayout = new HashMap<>();
        seatLayout.put(SeatType.SILVER, initializeSeatMap(10));
        seatLayout.put(SeatType.GOLD, initializeSeatMap(10));
        seatLayout.put(SeatType.PLATINUM, initializeSeatMap(10));

        screenList = new ArrayList<>();
        screen = new Screen();
        screen.setId(1);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        screen = new Screen();
        screen.setId(2);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        screen = new Screen();
        screen.setId(3);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        cinema.setScreens(screenList);

        rate = new HashMap<>();
        rate.put(SeatType.SILVER, 150);
        rate.put(SeatType.GOLD, 180);
        rate.put(SeatType.PLATINUM, 220);

        showList = new ArrayList<>();
        show = new Show(9, 2, 1, rate);
        showList.add(show);
        show = new Show(9, 5, 2, rate);
        showList.add(show);
        show = new Show(9, 6, 3, rate);
        showList.add(show);

        show = new Show(14, 2, 1, rate);
        showList.add(show);
        show = new Show(14, 5, 2, rate);
        showList.add(show);
        show = new Show(14, 6, 3, rate);
        showList.add(show);

        show = new Show(18, 3, 1, rate);
        showList.add(show);
        show = new Show(18, 3, 2, rate);
        showList.add(show);
        show = new Show(18, 7, 3, rate);
        showList.add(show);

        cinema.setShows(showList);
        CINEMA_LIST.add(cinema);

        // cinema 3
        cinema = new Cinema();
        cinema.setId(3);
        cinema.setName("E Square - Hinjewadi");
        cinema.setAddress("Hinjewadi, Pune");

        // preparing this for use in Screen.
        seatLayout = new HashMap<>();
        seatLayout.put(SeatType.SILVER, initializeSeatMap(10));
        seatLayout.put(SeatType.GOLD, initializeSeatMap(10));
        seatLayout.put(SeatType.PLATINUM, initializeSeatMap(10));

        screenList = new ArrayList<>();
        screen = new Screen();
        screen.setId(1);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        screen = new Screen();
        screen.setId(2);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        screen = new Screen();
        screen.setId(3);
        screen.setSeatLayout(seatLayout);
        screenList.add(screen);

        cinema.setScreens(screenList);

        rate = new HashMap<>();
        rate.put(SeatType.SILVER, 150);
        rate.put(SeatType.GOLD, 180);
        rate.put(SeatType.PLATINUM, 220);

        showList = new ArrayList<>();
        show = new Show(9, 4, 1, rate);
        showList.add(show);
        show = new Show(9, 5, 2, rate);
        showList.add(show);
        show = new Show(9, 1, 3, rate);
        showList.add(show);

        show = new Show(14, 4, 1, rate);
        showList.add(show);
        show = new Show(14, 5, 2, rate);
        showList.add(show);
        show = new Show(14, 1, 3, rate);
        showList.add(show);

        show = new Show(18, 4, 1, rate);
        showList.add(show);
        show = new Show(18, 2, 2, rate);
        showList.add(show);
        show = new Show(18, 7, 3, rate);
        showList.add(show);

        cinema.setShows(showList);
        CINEMA_LIST.add(cinema);
    }

    /**
     * a "false" is available
     *
     * @param noOfSeats - initial count of seats
     * @return - map of seat id and availability boolean.
     */
    private static Map<Integer, Boolean> initializeSeatMap(int noOfSeats) {
        Map<Integer, Boolean> map = new HashMap<>(noOfSeats);
        for (int i = 1; i <= noOfSeats; ++i) {
            map.put(i, false);
        }
        return map;
    }

    /**
     * prepare a list of dummy movies.
     * ideally this should pop from database.
     */
    private static void prepareDummyMovies() {

        Movie m = new Movie();
        m.setId(1);
        m.setTitle("Avenger");
        m.setCertificate(Certificate.UNIVERSAL);
        m.setLanguages(Language.ENGLISH);
        m.setGenres(EnumSet.of(Genre.ACTION, Genre.SCI_FI));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(2);
        m.setTitle("Civil War");
        m.setCertificate(Certificate.UNIVERSAL);
        m.setLanguages(Language.ENGLISH);
        m.setGenres(EnumSet.of(Genre.ACTION, Genre.SCI_FI));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(3);
        m.setTitle("Unfaithful");
        m.setCertificate(Certificate.ADULT);
        m.setLanguages(Language.ENGLISH);
        m.setGenres(EnumSet.of(Genre.DRAMA, Genre.FANTASY));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(4);
        m.setTitle("Frozen");
        m.setCertificate(Certificate.UNIVERSAL);
        m.setLanguages(Language.ENGLISH);
        m.setGenres(EnumSet.of(Genre.MUSICAL, Genre.FANTASY, Genre.ADV));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(5);
        m.setTitle("Kaabil");
        m.setCertificate(Certificate.ADULT);
        m.setLanguages(Language.HINDI);
        m.setGenres(EnumSet.of(Genre.DRAMA, Genre.THRILLER));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(6);
        m.setTitle("Raees");
        m.setCertificate(Certificate.UNIVERSAL);
        m.setLanguages(Language.HINDI);
        m.setGenres(EnumSet.of(Genre.DRAMA, Genre.ACTION));
        MOVIE_LIST.add(m);

        m = new Movie();
        m.setId(7);
        m.setTitle("Jolly LLB");
        m.setCertificate(Certificate.UNIVERSAL);
        m.setLanguages(Language.HINDI);
        m.setGenres(EnumSet.of(Genre.DRAMA, Genre.COMEDY));
        MOVIE_LIST.add(m);
    }
}
