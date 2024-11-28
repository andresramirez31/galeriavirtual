package com.gamodel.galeriavirtual.service;

import com.gamodel.galeriavirtual.repository.ObraRepository;

import com.gamodel.galeriavirtual.model.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> getAllObras() {
        return obraRepository.findAll();
    }

    public Optional<Obra> getObraById(String id) {
        return obraRepository.findById(id);
    }

    public Obra addObra(Obra obra) {
        return obraRepository.save(obra);
    }

}
