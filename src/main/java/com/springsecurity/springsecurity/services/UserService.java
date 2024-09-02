package com.springsecurity.springsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.models.Rol;
import com.springsecurity.springsecurity.models.User;
import com.springsecurity.springsecurity.repositories.RolRepository;
import com.springsecurity.springsecurity.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    public List<User> obtenerUsuarios() {
        return userRepository.findAll();
    }

    // public String crearUsuario(User usuario) {
    //     // long rolIdLong = Long.valueOf(1); // Para convertir int a long
    //     long rolId = 1L; // Otra forma de conversion
    //     Rol rol = rolRepository.findById(rolId).orElse(null); // la mejor forma para mejor rendimiento
    //     System.out.println(rol);
    //     if (rol != null) {
    //         usuario.setRol(rolRepository.findById(rolId).get());
    //         userRepository.save(usuario);
    //         return "Usuario agregado";
    //     } else
    //         return "Error al agregar usuario, no existe Rol";
    // }
    
    public String crearUsuario(User usuario){
        Optional<Rol> rol = rolRepository.findById(1L);
        System.out.println(rol);
        if(rol.isPresent()){
            usuario.setRol(rol.get());
            userRepository.save(usuario);
            return "Usuario creado";
        }
        else return "Error, el rol no existe";
    }

    public String actualizarProducto(User usuario) {
        if (userRepository.findById(usuario.getId()).isPresent()) {
            userRepository.save(usuario);
            return "Usuario actualizado";
        } else
            return "El id ingresado no es valido";
    }

    public String eliminarUsuario(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "Usuario eliminado";
        } else
            return "El id ingresado no es valido";
    }

    public Optional<User> obtenerPorId(long id) {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario;
        } else
            return Optional.empty();
    }
}