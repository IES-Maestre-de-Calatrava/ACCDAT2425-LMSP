/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.break4learning.mvc;

import com.break4learning.mvc.controlador.ControlConversor;
import com.break4learning.mvc.modelo.ConversorEurosPesetas;
import com.break4learning.mvc.vista.InterfazVista;
import com.break4learning.mvc.vista.VentanaConversor;
import com.break4learning.mvc.vista.VentanaConversorTexto;

/**
 * Clase ejemplo para mostrar el patrón MVC
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public class Mvc {

    public static void main(String[] args) {
                
        /* 
            La vista
         */
        InterfazVista vista = new VentanaConversor();     //-- Interfaz modo gráfico
        //InterfazVista vista = new VentanaConversorTexto();  //-- Interfaz modo texto

        /* 
            El modelo
         */
        ConversorEurosPesetas modelo = new ConversorEurosPesetas();
        
        /*
            Creamos el controlador pasándole la vista y el modelo
         */
        ControlConversor control = new ControlConversor(vista, modelo);
    }
}
