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

import com.springsecurity.springsecurity.models.Product;
import com.springsecurity.springsecurity.services.ProductService;

// Funciona

@RestController
@RequestMapping("/api/v1/products")
public class ProductosController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> obtenerProductos() {
        return productService.obtenerProductos();
    }

    @PostMapping
    public String agregarProducto(@RequestBody Product producto) {
        return productService.agregarProducto(producto);
    }

    @PutMapping
    public String actualizarProducto(@RequestBody Product producto) {
        return productService.actualizarProducto(producto);
    }

    @DeleteMapping
    public String eliminarProducto(@RequestBody Product producto) {
        return productService.eliminarProducto(producto.getId());
    }

    @GetMapping("/{id}")
    public Optional<Product> obtenerPorId(@PathVariable long id) {
        return productService.obtenerPorId(id);
    }

}
