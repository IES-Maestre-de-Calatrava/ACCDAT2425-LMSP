/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.break4learning.paquetenio.controlador;

import com.break4learning.paquetenio.modelo.Carpeta;
import com.break4learning.paquetenio.vista.InterfazVista;

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
public class ControlCarpeta implements ActionListener {
    private final InterfazVista vista;
    private final Carpeta modelo;

    /**
     * Inicia desde el controlador el proceso
     * 
     * @param vista     Vista de la aplicación
     * @param modelo    Modelo de la aplicación 
     */
    public ControlCarpeta(InterfazVista vista, Carpeta modelo) {
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
        String ruta = vista.getRuta(); 
        modelo.setRuta(ruta);
        
        switch (evento.getActionCommand()) {
            case InterfazVista.CREARCARPETACONRUTACOMPLETA -> {
                modelo.crearCarpeta();
            }
            case InterfazVista.CREARCARPETACONRUTAPADREYNOMBRE -> {
                String nombre = vista.getNombre();
                modelo.crearCarpeta(nombre);
            }
            case InterfazVista.CREARCARPETACONFILERUTAPADREYNOMBRE -> {
                String nombre = vista.getNombre();
                modelo.crearCarpeta(modelo.getPathDeRuta(), nombre);
            }
            default -> {
            }
        }
        vista. arranca();
    }
}
