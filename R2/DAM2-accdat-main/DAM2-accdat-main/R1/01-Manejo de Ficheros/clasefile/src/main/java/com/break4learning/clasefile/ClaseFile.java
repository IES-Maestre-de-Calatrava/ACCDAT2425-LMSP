/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.break4learning.clasefile;

import com.break4learning.clasefile.controlador.ControlCarpeta;
import com.break4learning.clasefile.modelo.Carpeta;
import com.break4learning.clasefile.vista.CarpetaVistaTexto;
import com.break4learning.clasefile.vista.InterfazVista;

/**
 * Clase ejemplo para mostrar el patrón MVC
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public class ClaseFile {

    public static void main(String[] args) {

        /* 
            La vista
         */
        //Interfaz vista = new CarpetaVista();          //-- Modo gráfico
        InterfazVista vista = new CarpetaVistaTexto();  //-- Modo texto

        /* 
            El modelo
         */
        Carpeta modelo = new Carpeta();
        
        /*
            Creamos el controlador pasándole la vista y el modelo
         */
        ControlCarpeta control = new ControlCarpeta(vista, modelo);
    }
}
