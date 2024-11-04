package com.gamodel.galeriavirtual.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamodel.galeriavirtual.dto.LoginRequest;
import com.gamodel.galeriavirtual.dto.RegisterRequest;
import com.gamodel.galeriavirtual.model.Usuario;
import com.gamodel.galeriavirtual.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private UsuarioService usuarioService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        boolean autenticado = usuarioService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (autenticado) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales invalidas");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterRequest registerRequest) {

        try {

            String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

            Usuario usuario = new Usuario(registerRequest.getNombre(), registerRequest.getRol(),
                    registerRequest.getEstado(), registerRequest.getCorreo(), encodedPassword);
            Usuario usuarioGuardado = usuarioService.addUsuario(usuario);
            return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
