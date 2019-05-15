/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniel
 */
public class M_Animal {
    
    private int id;
    private String nombre;
    private String especie;
    private String DNICuidador;

    public M_Animal() {
    }

    public M_Animal(String nombre, String especie, String DNICuidador) {
        this.nombre = nombre;
        this.especie = especie;
        this.DNICuidador = DNICuidador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDNICuidador() {
        return DNICuidador;
    }

    public void setDNICuidador(String DNICuidador) {
        this.DNICuidador = DNICuidador;
    }

    @Override
    public String toString() {
        return "M_Animal{" + "id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", DNICuidador=" + DNICuidador + '}';
    }
    
    
}
