/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasefile.controlador;

import clasefile.modelo.Archivo;
import clasefile.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class ControlArchivo implements ActionListener{
    private final InterfazVista vista;
    private final Archivo modelo;
    
    public ControlArchivo(InterfazVista vista, Archivo modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String ruta = vista.getRuta();
        modelo.setRuta(ruta);
        
        switch(evento.getActionCommand()){
            case InterfazVista.CREARARCHIVO -> {
                String nombre = vista.getNombre();
                modelo.crearArchivo(nombre);
            }
            case InterfazVista.ELIMINARARCHIVO -> {  
                modelo.borrarArchivo(ruta);
            }
            
            case InterfazVista.RENOMBRARARCHIVO -> {
                String nombreNuevo = vista.getNombre();
                modelo.renombrarArchivo(ruta, nombreNuevo);
            }
            
            case InterfazVista.COPIARARCHIVO -> {
                String rutaNueva = vista.getRuta();
                try {
                    modelo.copiarArchivo(ruta, rutaNueva);
                } catch (IOException e){
                    e.getMessage();
                }
                
            }
          
        }
    }
    
}
