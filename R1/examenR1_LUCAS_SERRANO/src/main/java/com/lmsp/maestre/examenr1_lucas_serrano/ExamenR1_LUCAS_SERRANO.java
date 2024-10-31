
package com.lmsp.maestre.examenr1_lucas_serrano;

import com.lmsp.maestre.examenr1_lucas_serrano.controlador.Controlador;
import com.lmsp.maestre.examenr1_lucas_serrano.modelo.Modelo;
import com.lmsp.maestre.examenr1_lucas_serrano.vista.InterfazVista;
import com.lmsp.maestre.examenr1_lucas_serrano.vista.VistaTexto;


public class ExamenR1_LUCAS_SERRANO {

    public static void main(String[] args) {
        InterfazVista vista = new VistaTexto();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        vista.arranca();
    }
}
