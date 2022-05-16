package com.hotel.ds_backend.service;

import com.hotel.ds_backend.model.Reservation;
import com.hotel.ds_backend.model.Taxi;

import java.util.List;

public interface TaxiService {

    Taxi saveTaxi(Taxi taxi);

    List<Taxi> getAllTaxi();

    Taxi getTaxiById(long id);

    Taxi updateTaxi(Taxi taxi, long id);

    void deleteTaxi(long id);
}
