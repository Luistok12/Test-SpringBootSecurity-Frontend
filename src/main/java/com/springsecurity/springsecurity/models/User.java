package com.springsecurity.springsecurity.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@EntityListeners(AuditingEntityListener.class) // Usando Auditorio para generar las fechas
// Hay otra opcion que es "mejor practica con eventos de ciclo de vida de JPA"
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private double saldo;

    @CreatedDate
    @Temporal(TemporalType.DATE) // Para que genere la fecha
    // @Column(name = "created_date", nullable = false, updatable = false)
    private Date fechaCreacion;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP) // Para que genere la fecha y hora
    // @Column(name = "last_modified_date", nullable = false, updatable = false)
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Rol rol;

    public User() {
    }

    // No es necesario este constructor, cualquier cosa descomentar si es que no funciona algun delete o put
    // public User(String nombre, String email, double saldo) {
    //     this.nombre = nombre;
    //     this.email = email;
    //     this.saldo = saldo;
    // }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public String toString() {
        return "[Usuario: " + this.id + ", Nombre: " + this.nombre + ", Email: " + this.email + ", Saldo: " + this.saldo
                + "]";
    }

}