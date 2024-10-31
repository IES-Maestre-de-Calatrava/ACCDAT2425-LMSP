/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.examenr1_lucas_serrano.modelo;

import java.io.File;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 23 oct 2024
 */
public class FicheroUniversidad{
    private final int LONGITUD_LONG = 8;
    private final int LONGITUD_DOUBLE = 8;
    private final int LONGITUD_CHAR = 2;
    
    
    private final int CARACTERES_STRING = 10;
    
    
    private final int LONGITUD_ID = LONGITUD_LONG;
    private final int LONGITUD_CARRERA = CARACTERES_STRING * LONGITUD_CHAR;
    private final int LONGITUD_CIUDAD = CARACTERES_STRING * LONGITUD_CHAR;
    private final int LONGITUD_NOTACORTE = LONGITUD_DOUBLE;
    
    
    private final int LONGITUD_TOTAL = LONGITUD_ID + LONGITUD_CARRERA + LONGITUD_CIUDAD + LONGITUD_NOTACORTE;
    
    
    private File ruta;
    
    public FicheroUniversidad(String ruta){
        this.ruta = new File(ruta);
    }
    public int getCARACTERES_STRING(){
        return CARACTERES_STRING;
    }
    public int getLONGITUD_CARRERA() {
        return LONGITUD_CARRERA;
    }

    public int getLONGITUD_ID() {
        return LONGITUD_ID;
    }

    public int getLONGITUD_CIUDAD() {
        return LONGITUD_CIUDAD;
    }


    public int getLONGITUD_NOTACORTE() {
        return LONGITUD_NOTACORTE;
    }

    public int getLONGITUD_TOTAL() {
        return LONGITUD_TOTAL;
    }

    
    
    public File getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = new File(ruta);
    }

}
