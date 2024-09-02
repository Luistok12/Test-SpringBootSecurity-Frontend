package com.springsecurity.springsecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.models.Rol;
import com.springsecurity.springsecurity.repositories.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerRoles() {
        List<Rol> Roles = rolRepository.findAll();
        return Roles;
    }

    public String crearRol(Rol rol) {
        rolRepository.save(rol);
        return "Rol agregado correctamente";
    }

}
