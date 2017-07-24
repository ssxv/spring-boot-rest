package com.entity;

import com.entity.enums.SeatType;

import java.util.Map;

public class Screen {

    private Integer id;

    /**
     * a "true" is Occupied
     * a "false" is Available
     */
    private Map<SeatType, Map<Integer, Boolean>> seatLayout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<SeatType, Map<Integer, Boolean>> getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(Map<SeatType, Map<Integer, Boolean>> seatLayout) {
        this.seatLayout = seatLayout;
    }
}
