/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.filestreamscaracteres;

import com.lmsp.maestre.filestreamscaracteres.controlador.Controlador;
import com.lmsp.maestre.filestreamscaracteres.modelo.FileStreams;
import com.lmsp.maestre.filestreamscaracteres.vista.InterfazVista;
import com.lmsp.maestre.filestreamscaracteres.vista.VistaTexto;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Filestreamscaracteres {

    public static void main(String[] args) {
        
        FileStreams modelo = new FileStreams();
        InterfazVista vista = new VistaTexto();
        Controlador controlador = new Controlador(vista, modelo);
        vista.arranca();
        /*//modelo.leerStreamBufferedReader();
        char[] array= {'H','O','L','A'};
        modelo.escribirStreamArrayCaracteres(array, false);*/
    }
}
