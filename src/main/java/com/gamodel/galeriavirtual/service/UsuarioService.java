package com.gamodel.galeriavirtual.service;

import org.springframework.stereotype.Service;

import com.gamodel.galeriavirtual.repository.UsuarioRepository;
import com.gamodel.galeriavirtual.model.Usuario;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean authenticateUser(String email, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(email);

        System.out.println(usuario.getCorreo());

        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
