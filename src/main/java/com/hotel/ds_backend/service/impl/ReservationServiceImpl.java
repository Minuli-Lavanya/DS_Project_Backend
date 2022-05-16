package com.hotel.ds_backend.service.impl;

import com.hotel.ds_backend.exception.ResourceNotFoundException;
import com.hotel.ds_backend.model.Reservation;
import com.hotel.ds_backend.repository.ReservationRepository;
import com.hotel.ds_backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;

    //add reservation
    @Override
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    //add all reservation
    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    //get by id
    @Override
    public Reservation getReservationById(long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", id));
    }

    @Override
    public Reservation updateReservation(Reservation reservation, long id) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation","Id", id));

        existingReservation.setTname(reservation.getTname());
        existingReservation.setTemail(reservation.getTemail());
        existingReservation.setMobileNo(reservation.getMobileNo());
        existingReservation.setCheckIn(reservation.getCheckIn());
        existingReservation.setCheckOut(reservation.getCheckOut());
        existingReservation.setNoOfAdult(reservation.getNoOfAdult());
        existingReservation.setNoOfChild(reservation.getNoOfChild());
        existingReservation.setNoOfSroom(reservation.getNoOfSroom());
        existingReservation.setNoOfDroom(reservation.getNoOfDroom());
        existingReservation.setNoOfTroom(reservation.getNoOfTroom());
        existingReservation.setNoOfFroom(reservation.getNoOfFroom());

        reservationRepository.save(existingReservation);

        return existingReservation;
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation","Id", id));
        reservationRepository.deleteById(id);
    }
}
