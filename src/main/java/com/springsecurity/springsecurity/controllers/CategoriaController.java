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

import com.springsecurity.springsecurity.models.Categoria;
import com.springsecurity.springsecurity.services.CategoriaService;

@RestController
@RequestMapping("api/v1/categories")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.obtenerCategorias();
    }

    @PostMapping
    public String agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.agregarCategoria(categoria);
    }

    @PutMapping
    public String actualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping
    public String eliminarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.eliminarCategoria(categoria.getId());
    }

    @GetMapping("/{id}")
    public Optional<Categoria> obtenerPorId(@PathVariable long id) {
        return categoriaService.obtenerPorId(id);
    }
}
