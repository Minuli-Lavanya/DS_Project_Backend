package com.hotel.ds_backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="traveller")
public class Traveller {

    @Id
    private String TravellerId;

}
