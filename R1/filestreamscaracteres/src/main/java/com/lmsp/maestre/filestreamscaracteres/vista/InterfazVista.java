/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lmsp.maestre.filestreamscaracteres.vista;

import com.lmsp.maestre.filestreamscaracteres.controlador.Controlador;

/**
 *
 * @author Usuario
 */
public interface InterfazVista {
    void setControlador(Controlador c);
    void arranca();
    public String getPath();
    public String getChain();
    public boolean getBoolean();
    public char getChar();
    public char[] getArrayChar();
    
    static final String LEESTRINGBUFFER = "Lee usando StringBuffer de 50";
    static final String LEEARRAY = "Lee usando un array de 5";
    static final String LEEBUFFEREDREADER = "Lee usando BufferedReader";
    static final String ESCRIBEOSOBREESCRIBE = "Escribe o sobreescribe";
    static final String ESCRIBEOSOBREESCRIBEARRAY = "Escribe o sobreescribe usando array";
    static final String ESCRIBEBUFFEREDWRITER = "Escribe o sobreescribe usando BufferedWriter";
    static final String ESCRIBEPRINTWRITER = "Escribe o sobreescribe usando PrintWriter";

    
    
}
