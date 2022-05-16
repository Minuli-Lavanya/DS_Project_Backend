package com.hotel.ds_backend.service.impl;

import com.hotel.ds_backend.exception.ResourceNotFoundException;
import com.hotel.ds_backend.model.Taxi;
import com.hotel.ds_backend.repository.TaxiRepository;
import com.hotel.ds_backend.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public Taxi saveTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    @Override
    public List<Taxi> getAllTaxi() {
        return taxiRepository.findAll();
    }

    @Override
    public Taxi getTaxiById(long id) {
        return taxiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Taxi", "Id", id));
    }

    @Override
    public Taxi updateTaxi(Taxi taxi, long id) {
        Taxi existingtaxi = taxiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Taxi", "Id", id));

        existingtaxi.setName(taxi.getName());
        existingtaxi.setEmail(taxi.getEmail());
        existingtaxi.setVehicleType(taxi.getVehicleType());
        existingtaxi.setDrop(taxi.getDrop());
        existingtaxi.setPick(taxi.getPick());
        existingtaxi.setPcount(taxi.getPcount());

        taxiRepository.save(existingtaxi);

        return existingtaxi;
    }

    @Override
    public void deleteTaxi(long id) {
        taxiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Taxi", "Id", id));
        taxiRepository.deleteById(id);
    }
}
