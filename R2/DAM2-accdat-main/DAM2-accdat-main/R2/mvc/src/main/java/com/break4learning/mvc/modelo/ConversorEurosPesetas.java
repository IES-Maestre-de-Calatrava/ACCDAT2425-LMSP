/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.mvc.modelo;

/**
 * Clase para utilizar el conversor entre euros y pesetas
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public class ConversorEurosPesetas extends Conversor {

    /**
     * Establecemos la equivalencia entre 1 euro y las pesetas
     */
    public ConversorEurosPesetas() {
        super(166.386D);
    }

    /**
     * Llama al método para hacer el cambio de euros a pesetas
     * 
     * @param cantidad  Cantidad de euros que queremos pasar a pesetas
     * @return          Pesetas tras convertir los euros
     */
    public double eurosApesetas(double cantidad) {
        return eurosAmoneda(cantidad);
    }

    /**
     * Llama al método para hacer el cambio de pesetas a euros
     * 
     * @param cantidad  Cantidad de pesetas que queremos pasar a euros
     * @return          Euros tras convertir las pesetas
     */
    public double pesetasAeuros(double cantidad) {
        return monedaAeuros(cantidad);
    }
}
