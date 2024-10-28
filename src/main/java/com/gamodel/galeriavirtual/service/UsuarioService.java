package com.gamodel.galeriavirtual.service;

import org.springframework.stereotype.Service;

import com.gamodel.galeriavirtual.repository.UsuarioRepository;
import com.gamodel.galeriavirtual.model.Usuario;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
