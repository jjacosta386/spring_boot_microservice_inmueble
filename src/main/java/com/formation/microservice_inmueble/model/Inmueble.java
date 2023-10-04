package com.formation.microservice_inmueble.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private int codigoInmueble;
    @Column
    private String direccion;
    @Column
    private String foto;
    @Column
    private Double precio;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private String tipo;
    @Column
    private int tamano;

    public Inmueble(String nombre, int codigoInmueble, String direccion, String foto, Double precio, LocalDate fechaCreacion, String tipo, int tamano) {
        this.nombre = nombre;
        this.codigoInmueble = codigoInmueble;
        this.direccion = direccion;
        this.foto = foto;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public Inmueble(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(int codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    @Override
    public String toString(){
        return "Inmueble{" +
                "id: " + id +
                ", nombre: " + nombre +
                ", direccion: '" + direccion + "\'" +
                ", tipo: '" + tipo + "\'" +
                ", tamano: " + tamano +
                "}";
    }
}
