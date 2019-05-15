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
public class M_Visita {
    
    private int id;
    private String tipoVisita;
    private String resultado;
    private double precio;

    public M_Visita() {
    }

    public M_Visita(int id, String tipoVisita, String resultado, double precio) {
        this.id = id;
        this.tipoVisita = tipoVisita;
        this.resultado = resultado;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "M_Visita{" + "id=" + id + ", tipoVisita=" + tipoVisita + ", resultado=" + resultado + ", precio=" + precio + '}';
    }
    
    
    
}
