/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.filestreamscaracteres;

import com.lmsp.maestre.filestreamscaracteres.modelo.FileStreams;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Filestreamscaracteres {

    public static void main(String[] args) {
        FileStreams modelo = new FileStreams("texto");
        //modelo.leerStreamBufferedReader();
        char[] array= {'H','O','L','A'};
        modelo.escribirStreamArrayCaracteres(array, true);
    }
}
