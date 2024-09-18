/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.mvc.modelo;

/**
 *  Clase para utilizar el conversor de euros a pesetas
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 13 sept 2024
 */
public class ConversorEurosPesetas extends Conversor{
    public ConversorEurosPesetas(){
        super(166.386D);
    }
    /**
     * Método para convertir de euros a pesetas
     * @param cantidad Cantidad de euros a convertir
     * @return Cantidad de pesetas
     */
    public double eurosApesetas(double cantidad, double comision){
        return eurosAmoneda(cantidad, comision);
    }
     /**
     * Método para convertir de pesetas a euros
     * @param cantidad Cantidad de pesetas a convertir
     * @return Cantidad de euros
     */
    public double pesetaAeuros(double cantidad,double comision){
        return monedaAeuros(cantidad, comision);
    }
}
