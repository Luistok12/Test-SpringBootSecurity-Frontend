package com.springsecurity.springsecurity.models;

// import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
// Ojo con los nombres de las tablas, tengo datos en la tabla "categorias"
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String descripcion;

    // Una categoria tiene muchos productos o una categoria tiene una lista de
    // productos!
    // @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    // private List<Product> productos;

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
