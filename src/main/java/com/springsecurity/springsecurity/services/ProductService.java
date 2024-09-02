package com.springsecurity.springsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.models.Categoria;
import com.springsecurity.springsecurity.models.Product;
import com.springsecurity.springsecurity.repositories.CategoriaRepository;
import com.springsecurity.springsecurity.repositories.ProductsRepository;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Product> obtenerProductos() {
        return productsRepository.findAll();
    }

    public String agregarProducto(Product producto) {
        Optional<Categoria> categoria = categoriaRepository.findById(producto.getCategoria().getId());
        System.out.println("Se cargo la categoria, ya sea al menos nulo");

        if (categoria.isPresent()) {
            producto.setCategoria(categoria.get());
            System.out.println(categoria);
            productsRepository.save(producto);
        } else {
            System.out.println("No se encuentra la categoria");
        }

        return "Producto agregado";
    }

    public String actualizarProducto(Product producto) {
        if (productsRepository.findById(producto.getId()).isPresent()) {
            productsRepository.save(producto);
            return "Producto actualizado";
        } else
            return "El id ingresado no se encuentra";
    }

    public String eliminarProducto(long id) {
        if (productsRepository.findById(id).isPresent()) {
            productsRepository.deleteById(id);
            return "Producto eliminado";
        } else
            return "El id ingresado no se encuentra";
    }

    public Optional<Product> obtenerPorId(long id) {
        Optional<Product> producto = productsRepository.findById(id);
        if (producto.isPresent())
            return producto;
        else
            return producto.empty();
    }
}
