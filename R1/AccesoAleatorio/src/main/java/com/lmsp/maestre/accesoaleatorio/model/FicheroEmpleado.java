/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.accesoaleatorio.model;

import java.io.File;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 7 oct 2024
 */
public class FicheroEmpleado {
    private final int LONGITUD_LONG = 8;
    private final int LONGITUD_DOUBLE = 8;
    private final int LONGITUD_INT = 4;
    private final int LONGITUD_CHAR = 2;
    
    
    private final int CARACTERES_APELLIDO = 10;
    
    
    private final int LONGITUD_IDENTIFICADOR = LONGITUD_LONG;
    private final int LONGITUD_APELLIDO = CARACTERES_APELLIDO * LONGITUD_CHAR;
    private final int LONGITUD_DEPARTAMENTO = LONGITUD_INT;
    private final int LONGITUD_SALARIO = LONGITUD_DOUBLE;
    
    
    private final int LONGITUD_TOTAL = LONGITUD_IDENTIFICADOR + LONGITUD_APELLIDO + LONGITUD_DEPARTAMENTO + LONGITUD_SALARIO;
    
    
    private File ruta;
    
    public FicheroEmpleado(String ruta){
        this.ruta = new File(ruta);
    }

    public int getLONGITUD_LONG() {
        return LONGITUD_LONG;
    }

    public int getLONGITUD_DOUBLE() {
        return LONGITUD_DOUBLE;
    }

    public int getLONGITUD_INT() {
        return LONGITUD_INT;
    }

    public int getLONGITUD_CHAR() {
        return LONGITUD_CHAR;
    }

    public int getCARACTERES_APELLIDO() {
        return CARACTERES_APELLIDO;
    }

    public int getLONGITUD_IDENTIFICADOR() {
        return LONGITUD_IDENTIFICADOR;
    }

    public int getLONGITUD_APELLIDO() {
        return LONGITUD_APELLIDO;
    }

    public int getLONGITUD_DEPARTAMENTO() {
        return LONGITUD_DEPARTAMENTO;
    }

    public int getLONGITUD_SALARIO() {
        return LONGITUD_SALARIO;
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
