package com.gamodel.galeriavirtual.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamodel.galeriavirtual.dto.LoginRequest;
import com.gamodel.galeriavirtual.dto.RegisterRequest;
import com.gamodel.galeriavirtual.model.Usuario;
import com.gamodel.galeriavirtual.service.UsuarioService;
import com.gamodel.galeriavirtual.utils.JWTUtil;
import com.gamodel.galeriavirtual.utils.JwtResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    private UsuarioService usuarioService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            String role = authentication.getAuthorities().stream().findFirst().map(Object::toString).orElse("");

            String token = jwtUtil.generateToken(loginRequest.getEmail(), role);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
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
