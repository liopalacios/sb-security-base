package com.zennitech.digital.controller;

import com.zennitech.digital.pojo.AuthRequest;
import com.zennitech.digital.pojo.AuthResponse;
import com.zennitech.digital.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UsuarioController {
    private final PasswordEncoder encoder;
    @Autowired
    private UsuarioService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        System.out.printf("este es un controller");
        System.out.printf("test 03");
        System.out.println("Login request: " + request.getUsername() + " - " + encoder.encode(request.getPassword()) + "..."  );
        return authService.login(request.getUsername(), request.getPassword());
    }
}
