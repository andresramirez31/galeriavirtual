package com.gamodel.galeriavirtual.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gamodel.galeriavirtual.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByCorreo(String correo);
}
