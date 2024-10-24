package com.gamodel.galeriavirtual.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.gamodel.galeriavirtual.model.Obra;

import com.gamodel.galeriavirtual.service.ObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private final ObraService obraService;

    @Autowired
    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> getAllObras() {
        return obraService.getAllObras();
    }

}
