/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.mvc.modelo;

/**
 * Clase encargada de la lógica de negocio de la aplicación.
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 13 sept 2024
 */
public class Conversor {
    /*
        Cantidad de la moneda destino a la cual equivale 1€
    */
    private final double cambio;
    private double comision;

    public Conversor(double cambio) {
        this.cambio = cambio;
    }
    /**
     * Convierte los euros a una moneda cualquiera utilizando el cambio
     * @param cantidad Cantidad de euros que queremos pasar a la nueva moneda
     * @return Cantidad equivalente en la moneda destino
     */
    public double eurosAmoneda(double cantidad, double comision){
        return (cantidad*cambio-((cantidad*cambio)*(comision/100)));
    }
    /**
     * Convierte la moneda destino a euros
     * @param cantidad Cantidad de moneda destino que queremos pasar a euros
     * @return Cantidad equivalente en euros
     */
     public double monedaAeuros(double cantidad, double comision){
        return (cantidad/cambio-((cantidad/cambio)*(comision/100)));
        
    }
}
