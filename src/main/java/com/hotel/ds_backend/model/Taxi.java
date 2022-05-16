package com.hotel.ds_backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "pick")
    private String pick;

    @Column(name = "drop")
    private String drop;

    @Column(name = "pcount")
    private int pcount;

}
