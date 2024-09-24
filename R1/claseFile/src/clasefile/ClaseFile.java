/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package clasefile;

import clasefile.controlador.ControlArchivo;
import clasefile.controlador.ControlCarpeta;
import clasefile.modelo.Archivo;
import clasefile.modelo.Carpeta;
import clasefile.vista.VistaGUI;
import clasefile.vista.InterfazVista;

import clasefile.vista.VistaGUI;
//import clasefile.vista.VistaGrafica;
/**
 * Clase de ejemplo para usa la clase File
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public class ClaseFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazVista vista = new VistaGUI();
        Carpeta modelo = new Carpeta();
        Archivo modeloA = new Archivo();
        ControlCarpeta control = new ControlCarpeta(vista, modelo);
        ControlArchivo controlA = new ControlArchivo(vista, modeloA);
        vista.arranca();
    }
}
