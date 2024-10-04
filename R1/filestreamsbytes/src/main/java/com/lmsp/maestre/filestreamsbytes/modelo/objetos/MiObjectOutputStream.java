/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.filestreamsbytes.modelo.objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 4 oct 2024
 */
public class MiObjectOutputStream extends ObjectOutputStream{
        
    public MiObjectOutputStream (OutputStream out) throws IOException {
        super(out);
    }
    
    protected MiObjectOutputStream() throws IOException{
        super();
    }    
    
    @Override
    protected void writeStreamHeader(){
    
    }
}