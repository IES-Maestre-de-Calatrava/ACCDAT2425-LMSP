/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package clasefile.vista;

import clasefile.controlador.ControlCarpeta;

/**
 * Interfaz con los metodos que deben implementar las vistas que se generen
 * en la aplicacion
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public interface InterfazVista {
    void setControlador(ControlCarpeta c);
    void arranca();
    String getRuta();
    
    static final String CREARCARPETACONRUTACOMPLETA = "Crear carpeta";
}
