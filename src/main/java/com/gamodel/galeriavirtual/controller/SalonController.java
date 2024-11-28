package com.gamodel.galeriavirtual.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamodel.galeriavirtual.model.Obra;
import com.gamodel.galeriavirtual.model.Salon;
import com.gamodel.galeriavirtual.service.ObraService;
import com.gamodel.galeriavirtual.service.SalonService;

@RestController
@RequestMapping("/api/salon")
public class SalonController {

    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping
    public List<Salon> getAllSalones() {
        return salonService.getAllSalones();
    }

    @PostMapping
    public ResponseEntity<Salon> addSalon(@RequestBody Salon salon) {
        try {

            Salon salonGuardado = salonService.addSalon(salon);
            return new ResponseEntity<>(salonGuardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
