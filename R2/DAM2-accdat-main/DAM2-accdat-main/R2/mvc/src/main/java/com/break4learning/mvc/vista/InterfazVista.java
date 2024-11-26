/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.break4learning.mvc.vista;

import com.break4learning.mvc.controlador.ControlConversor;

/**
 * Interfaz con los métodos que deben implementar las vistas que se generen para la aplicación
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public interface InterfazVista {
        
    /**
     * Especifica el controlador que se va a encargar de procesar las acciones realizadas en la vista.
     * 
     * @param c     Controlador que procesa las acciones
     */
    void setControlador(ControlConversor c);

    /** 
     * Comienza la visualización de la vista
     */
    void arranca();

    
    /**
     * Obtiene de pantalla la cantidad a convertir
     * 
     * @return  Cantidad que ha introducido el usuario
     */
    double getCantidad();
   
    /**
     * Setea el valor convertido 
     * 
     * @param s     Valor que queremos escribir en la vista
     */
    void escribeCambio(String s);

    /** 
     * Constantes para las operaciones:
     */
    static final String AEUROS = "Pesetas a Euros";
    static final String APESETAS = "Euros a Pesetas";
}
