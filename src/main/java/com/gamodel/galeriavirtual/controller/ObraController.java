package com.gamodel.galeriavirtual.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.Base64;

import com.gamodel.galeriavirtual.dto.ComentarioRequest;
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
        try {
            byte[] imageData = Base64.getDecoder().decode(obra.getImageBase64());
            obra.setImageData(imageData);
            Obra obraGuardada = obraService.addObra(obra);
            return new ResponseEntity<>(obraGuardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/comentarios")
    public ResponseEntity<ComentarioRequest> addComentarios(@RequestBody ComentarioRequest comentario) {
        try {

            Optional<Obra> obra = obraService.getObraById(comentario.getIdOriginalObra());
            Obra obraElegida = obra.get();

            if (obraElegida.getComentarios() == null) {

                List<ComentarioRequest> comentarios = List.of(comentario);
                obraElegida.setComentarios(comentarios);

            } else {

                List<ComentarioRequest> comentarios = obraElegida.getComentarios();
                comentarios.add(comentario);
                obraElegida.setComentarios(comentarios);

            }

            obraService.addObra(obraElegida);

            return new ResponseEntity<>(comentario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
