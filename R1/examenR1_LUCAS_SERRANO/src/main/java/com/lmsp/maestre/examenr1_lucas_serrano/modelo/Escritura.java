/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.examenr1_lucas_serrano.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 23 oct 2024
 */
public class Escritura extends FicheroUniversidad{

    public Escritura(String ruta) {
        super(ruta);
    }

    public void escribirUniversidadSegunId(Universidad universidad){
        RandomAccessFile randomFile = null;
        long posicion = 0;
        StringBuffer bufferStr = null;
        
        try {
            randomFile = new RandomAccessFile("datosUniversidades.dat","rw");
            
            posicion = (universidad.getId() - 1)* super.getLONGITUD_TOTAL();
           
        
            randomFile.seek(posicion);
            
            //Escribimos la posicion
            randomFile.writeLong( universidad.getId());
            //Escribimos apellido
            bufferStr = new StringBuffer(universidad.getCarrera());
            bufferStr.setLength(super.getCARACTERES_STRING());
            randomFile.writeChars(bufferStr.toString());
            //Escribimos departamento
            bufferStr = new StringBuffer(universidad.getCiudad());
            bufferStr.setLength(super.getCARACTERES_STRING());
            randomFile.writeChars(bufferStr.toString());
            //Escribimos salario
            randomFile.writeDouble(universidad.getNotaCorte());
            
        } catch (FileNotFoundException fnfe){
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, fnfe);
        } catch (IOException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                randomFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
