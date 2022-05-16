package com.hotel.ds_backend.controller;

import com.hotel.ds_backend.model.Taxi;
import com.hotel.ds_backend.service.TaxiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi")
public class TaxiController {

    private TaxiService taxiService;

    public TaxiController(TaxiService taxiService){
        this.taxiService = taxiService;
    }

    //add
    @PostMapping
    public ResponseEntity<Taxi> saveTaxi(@RequestBody Taxi taxi){
        return new ResponseEntity<Taxi>(taxiService.saveTaxi(taxi), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Taxi> getAllTaxi(){
        return taxiService.getAllTaxi();
    }

    @GetMapping("{id}")
    public ResponseEntity<Taxi> getTaxiById(@PathVariable("id") long taxiId){
        return new ResponseEntity<Taxi>(taxiService.getTaxiById(taxiId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Taxi> updateTaxi(@PathVariable("id") long id, @RequestBody Taxi taxi){
        return new ResponseEntity<Taxi>(taxiService.updateTaxi(taxi, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaxi(@PathVariable("id") long id){
        taxiService.deleteTaxi(id);
        return new ResponseEntity<String>("Taxi deleted successfully", HttpStatus.OK);
    }

}
