/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.mvc;

import com.lmsp.mvc.controlador.ControlConversor;
import com.lmsp.mvc.modelo.ConversorEurosPesetas;
import com.lmsp.mvc.vista.InterfazVista;
import com.lmsp.mvc.vista.VentanaConversorTexto;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Mvc {

    public static void main(String[] args) {
        InterfazVista vista = new VentanaConversorTexto();
        ConversorEurosPesetas modelo = new ConversorEurosPesetas();
        ControlConversor control = new ControlConversor(vista, modelo);
    }
}
