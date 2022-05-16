package com.hotel.ds_backend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tname", nullable = false)
    private String tname;

    @Column(name = "temail")
    private String temail;

    @Column(name = "mobileNo")
    private int mobileNo;

    @Column(name = "checkIn")
    private LocalDate checkIn;

    @Column(name = "checkOut")
    private LocalDate checkOut;

    @Column(name = "noOfAdult")
    private int noOfAdult;

    @Column(name = "noOfChild")
    private int noOfChild;

    @Column(name = "noOfSroom")
    private int noOfSroom;

    @Column(name = "noOfDroom")
    private int noOfDroom;

    @Column(name = "noOfTroom")
    private int noOfTroom;

    @Column(name = "noOfFroom")
    private int noOfFroom;
}
