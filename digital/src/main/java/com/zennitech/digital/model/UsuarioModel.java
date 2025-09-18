package com.zennitech.digital.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class UsuarioModel {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
    private List<String> accesos;
}
