package com.zennitech.digital.service.impl;

import com.zennitech.digital.config.JwtUtil;
import com.zennitech.digital.model.UsuarioModel;
import com.zennitech.digital.pojo.AuthResponse;
import com.zennitech.digital.repository.UsuarioJdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class UsuarioServiceImplTest {
    @Mock
    private UsuarioJdbcRepository usuarioJdbcRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private UsuarioModel mockUser;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockUser = new UsuarioModel();
        mockUser.setUsername("testUser");
        mockUser.setPassword("encodedPassword");
        mockUser.setRoles(List.of("ADMIN"));
        mockUser.setAccesos(List.of("READ", "WRITE"));
    }

    @Test
    void login() {
        // Arrange

    }
}