/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.controlador;

import clasefile.modelo.Carpeta;
import clasefile.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Encargada de comunicar la Vista con el Modelo
 * Como esta clase esta interesada en procesar un evento de accion entonces debe
 * implementar la interfaz ActionListener
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public class ControlCarpeta implements ActionListener {
    private final InterfazVista vista;
    private final Carpeta modelo;
    public ControlCarpeta(InterfazVista vista, Carpeta modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.setControlador(this);
        this.vista.arranca();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String ruta = vista.getRuta();
        modelo.setRuta(ruta);
        
        switch(evento.getActionCommand()){
            case InterfazVista.CREARCARPETACONRUTACOMPLETA ->{
                modelo.crearCarpeta();
            }
            case InterfazVista.CREARCARPETACONRUTAPADREYNOMBRE ->{
                String nombre = vista.getNombre();
                modelo.crearCarpeta(nombre);
            }
            case InterfazVista.CREARCARPETACONFILEPADREYNOMBRE ->{
                String nombre = vista.getNombre();
                modelo.crearCarpeta(modelo.getFileDeRuta(), nombre);
            }
        }
    }
    
}
