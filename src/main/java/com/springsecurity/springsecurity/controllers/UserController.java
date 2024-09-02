package com.springsecurity.springsecurity.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.models.User;
import com.springsecurity.springsecurity.services.UserService;

// Funciona

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userServices;

    @GetMapping("/ok")
    public String estado() {
        return "Servidor OK";
    }

    @GetMapping
    public List<User> obtenerUsuarios() {
        return userServices.obtenerUsuarios();
    }

    @PostMapping
    public String crearUsuario(@RequestBody User usuario) {
        return userServices.crearUsuario(usuario);
    }

    @PutMapping
    public String actualizarUsuario(@RequestBody User usuario) {
        return userServices.actualizarProducto(usuario);
    }

    @DeleteMapping
    public String eliminarUsuario(@RequestBody User usuario) {
        return userServices.eliminarUsuario(usuario.getId());
    }

    @GetMapping("/{id}")
    public Optional<User> obtenerPorId(@PathVariable long id) {
        return userServices.obtenerPorId(id);
    }

}