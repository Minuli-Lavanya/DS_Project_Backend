package com.hotel.ds_backend.controller;

import com.hotel.ds_backend.model.Reservation;
import com.hotel.ds_backend.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    //add reservation
    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){

        return new ResponseEntity<Reservation>(reservationService.saveReservation(reservation), HttpStatus.CREATED);
    }

    //get all reservation
    @GetMapping
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservation();
    }

    //get reservation by id
    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") long reservationId){
        return new ResponseEntity<Reservation>(reservationService.getReservationById(reservationId), HttpStatus.OK);
    }

    //update reservation
    @PutMapping("{id}")
    public ResponseEntity<Reservation> upadateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(reservationService.updateReservation(reservation, id), HttpStatus.OK);
    }

    //delete reservation
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") long id){
        reservationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation deleted successfully", HttpStatus.OK);
    }

}

