package com.gamodel.galeriavirtual.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.gamodel.galeriavirtual.model.Obra;

import com.gamodel.galeriavirtual.service.ObraService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> getAllObras() {
        return obraService.getAllObras();
    }

    @PostMapping
    public ResponseEntity<Obra> addObra(@RequestBody Obra obra) {
        Obra obraGuardada = obraService.addObra(obra);
        return new ResponseEntity<>(obraGuardada, HttpStatus.CREATED);

    }

}
