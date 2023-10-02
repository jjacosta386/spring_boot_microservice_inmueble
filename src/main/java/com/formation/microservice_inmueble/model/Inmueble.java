package com.formation.microservice_inmueble.model;

import javax.persistence.*;

@Entity
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int codigoInmueble;
    @Column
    private String direccion;
    @Column
    private String tipo;
    @Column
    private int tamano;

    public Inmueble(int id, int codigoInmueble, String direccion, String tipo, int tamano) {
        this.id = id;
        this.codigoInmueble = codigoInmueble;
        this.direccion = direccion;
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public Inmueble(){}

    public int getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(int codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", direccion: '" + direccion + "\'" +
                ", tipo: '" + tipo + "\'" +
                ", tamano: " + tamano +
                "}";
    }
}
