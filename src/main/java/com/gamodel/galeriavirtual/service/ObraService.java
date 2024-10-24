package com.gamodel.galeriavirtual.service;

import com.gamodel.galeriavirtual.repository.ObraRepository;

import com.gamodel.galeriavirtual.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    @Autowired
    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> getAllObras() {
        return obraRepository.findAll();
    }

    public Obra addObra(Obra obra) {
        return obraRepository.save(obra);
    }
}
