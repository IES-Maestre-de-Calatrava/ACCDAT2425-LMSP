/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package clasefile.vista;

import clasefile.controlador.ControlArchivo;
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
    void setControlador(ControlArchivo ca);
    void arranca();
    String getRuta();
    String getNombre();
    
    static final String CREARCARPETACONRUTACOMPLETA = "Crea carpeta recibiendo la ruta completa";
    static final String CREARCARPETACONRUTAPADREYNOMBRE = "Crea carpeta recibiendo la ruta del padre";
    static final String CREARCARPETACONFILEPADREYNOMBRE = "Crea carpeta recibiendo un File y el nombre";
    static final String CREARARCHIVO = "Crea un archivo";
    static final String ELIMINARARCHIVO = "Elimina archivo de un directorio";
    static final String RENOMBRARARCHIVO = "Renombra un archivo";
    static final String COPIARARCHIVO = "Copia archivo en la ruta especificada";
    static final String MOVERARCHIVO = "Mueve archivo en la ruta especificada";
    static final String MUESTRATODO = "Muestra contenido de directorio";
    static final String BORRATODO = "Borra contenido de directorio";
    
    //static final String CREARARCHIVOCONRUTACOMPLETA = "Crea archivo recibiendo la ruta completa";
    //static final String CREARARCHIVOCONRUTAPADREYNOMBRE = "Crea archivo recibiendo la ruta del padre";
    //static final String CREARARCHIVOCONFILEPADREYNOMBRE = "Crea archivo recibiendo un File y el nombre";
}
