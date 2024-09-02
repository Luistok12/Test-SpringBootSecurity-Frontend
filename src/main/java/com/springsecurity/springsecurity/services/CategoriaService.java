package com.springsecurity.springsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.models.Categoria;
import com.springsecurity.springsecurity.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    public String agregarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "Se agrego una categoria correctamente";
    }

    public String actualizarCategoria(Categoria categoria) {
        if (categoriaRepository.findById(categoria.getId()).isPresent()) {
            categoriaRepository.save(categoria);
            return "Se actualizo la categoria correctamente";
        } else
            return "No se encuentra esa categoria";
    }

    public String eliminarCategoria(long id) {
        if (categoriaRepository.findById(id).isPresent()) {
            categoriaRepository.deleteById(id);
            return "Categoria eliminada";
        } else
            return "No se encuentra esa categoria";
    }

    public Optional<Categoria> obtenerPorId(long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent())
            return categoria;
        else
            return categoria.empty();
    }
}
