/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.mvc.controlador;

import com.break4learning.mvc.modelo.ConversorEurosPesetas;
import com.break4learning.mvc.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Encargada de comunicar la vista con el modelo
 * Como esta clase está interesada en procesar un evento de acción entonces debe
 * implementar la interfaz ActionListener
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public class ControlConversor implements ActionListener{
    private final InterfazVista vista;
    private final ConversorEurosPesetas modelo;

    
    /**
     * Inicia desde el controlador el proceso
     * 
     * @param vista     Vista de la aplicación
     * @param modelo    Modelo de la aplicación 
     */
    public ControlConversor(InterfazVista vista, ConversorEurosPesetas modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        // Configuramos los listener de la vista indicándole que los métodos a ejecutar están en el controlador 
        this.vista.setControlador(this);
       
        // Arrancamos la interfaz gráfica (vista):
        this.vista.arranca();
    }

 
    /**
     * Este método se ejecuta automáticamente cuando se produce el evento que provoca la acción.
     * 
     * @param evento    Evento que ha provocado que el 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        double cantidad = vista.getCantidad();
        switch (evento.getActionCommand()) { // Identificamos el objeto que ha provocado la acción
            case InterfazVista.AEUROS -> vista.escribeCambio(cantidad + " pesetas son: "
                        + modelo.pesetasAeuros(cantidad) + " euros");
            case InterfazVista.APESETAS -> vista.escribeCambio(cantidad + " euros son: "
                        + modelo.eurosApesetas(cantidad) + " pesetas");
            default -> vista.escribeCambio("ERROR");
        }
    }
}
