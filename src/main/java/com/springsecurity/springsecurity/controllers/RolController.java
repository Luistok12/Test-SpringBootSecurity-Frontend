package com.springsecurity.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.models.Rol;
import com.springsecurity.springsecurity.services.RolService;

@RestController
@RequestMapping("/api/v1/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> obtenerRoles() {
        return rolService.obtenerRoles();
    }

    @PostMapping
    public String crearRol(@RequestBody Rol rol) {
        rolService.crearRol(rol);
        return "Rol creado";
    }

    // @DeleteMapping
    // public String eliminarRol() {
    // return "Rol eliminado";
    // }

    // @PutMapping
    // public String actualizarRol() {
    // return "Rol actualizado";
    // }
}
