package com.hotel.ds_backend.service;

import com.hotel.ds_backend.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    Reservation getReservationById(long id);

    Reservation updateReservation(Reservation reservation, long id);

    void deleteReservation(long id);
}
