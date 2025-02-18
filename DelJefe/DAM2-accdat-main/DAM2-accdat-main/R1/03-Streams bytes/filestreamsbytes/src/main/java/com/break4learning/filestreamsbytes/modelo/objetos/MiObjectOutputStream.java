/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.filestreamsbytes.modelo.objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Sobreescritura de la clase ObjectOutputStream para que no de
 * errores con la cabecera.
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 4 oct 2024
 */
public class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }
    
    // La cabecera se crea cada vez que se pone new ObjectOutputStream(fichero)
    // Redefinimos el siguiente método de escribir la cabecera para que no haga nada,
    protected void writeStreamHeader() throws IOException {
        
    }
}
