package com.zennitech.digital.controller;

import com.zennitech.digital.model.UsuarioModel;
import com.zennitech.digital.pojo.AuthRequest;
import com.zennitech.digital.pojo.AuthResponse;
import com.zennitech.digital.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UsuarioController {
    private final PasswordEncoder encoder;
    @Autowired
    private UsuarioService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        System.out.println("Login request: " + request.getUsername() + " - " + encoder.encode(request.getPassword()) + "..."  );
        return authService.login(request.getUsername(), request.getPassword());
    }
    @GetMapping("/obtenerfechahora")
    public String ping() {
        return "fecha hora - " + System.currentTimeMillis();
    }

    @GetMapping("/obtenermes")
    public String getFechahoymames() {
        return "fecha de hoy mana mes - " + System.currentTimeMillis();
    }

    @GetMapping("/usuarios")
    public List<UsuarioModel> listarUsuarios() {
        return List.of(
                new UsuarioModel(1L, "Ana", "ana@example.com",null,null),
                new UsuarioModel(2L, "Pedro", "pedro@example.com",null, null),
                new UsuarioModel(2L, "Juan", "juan@example.com",null, null),
                new UsuarioModel(3L, "Pablo", "pablo@example.com",null, null)
        );
    }
}
