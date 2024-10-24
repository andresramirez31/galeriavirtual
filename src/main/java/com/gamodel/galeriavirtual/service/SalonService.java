package com.gamodel.galeriavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.gamodel.galeriavirtual.model.Salon;
import com.gamodel.galeriavirtual.repository.SalonRepository;

@Service
public class SalonService {

    private final SalonRepository salonRepository;

    @Autowired
    public SalonService(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    public List<Salon> getAllSalones() {
        return salonRepository.findAll();
    }

    public Salon addSalon(Salon salon) {
        return salonRepository.save(salon);
    }

}
