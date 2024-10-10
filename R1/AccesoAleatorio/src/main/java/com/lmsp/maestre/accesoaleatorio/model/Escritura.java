/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.accesoaleatorio.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 9 oct 2024
 */
public class Escritura extends FicheroEmpleado {
    
    public Escritura(String ruta){
        super(ruta);
    }
    public void escribirEmpleadoFinalArchivo(Empleado empleado){
        RandomAccessFile randomFile = null;
        long posicion = 0;
        StringBuffer bufferStr = null;
        
        try {
            randomFile = new RandomAccessFile(getRuta(),"rw");
            if (randomFile.length()!=0){
                posicion = randomFile.length();
            }
        
            randomFile.seek(posicion);
            
            //Escribimos la posicion
            //posicion = 120--> 40 + 40 + 40
            //tamaño de registro = 40
            randomFile.writeLong( posicion/super.getLONGITUD_TOTAL() +1);
            //Escribimos apellido
            bufferStr = new StringBuffer(empleado.getApellido());
            bufferStr.setLength(super.getCARACTERES_APELLIDO());
            randomFile.writeChars(bufferStr.toString());
            //Escribimos departamento
            randomFile.writeInt(empleado.getDepartamento());
            //Escribimos salario
            randomFile.writeDouble(empleado.getSalario());
            
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
    public void escribirEmpleadoSegunId(Empleado empleado){
        RandomAccessFile randomFile = null;
        long posicion = 0;
        StringBuffer bufferStr = null;
        
        try {
            randomFile = new RandomAccessFile(getRuta(),"rw");
            if (randomFile.length()!=0){
                posicion = (empleado.getIdentificador() - 1)*super.getLONGITUD_TOTAL();
            }
        
            randomFile.seek(posicion);
            
            //Escribimos la posicion
            //posicion = 120--> 40 + 40 + 40
            //tamaño de registro = 40
            randomFile.writeLong( posicion/super.getLONGITUD_TOTAL() +1);
            //Escribimos apellido
            bufferStr = new StringBuffer(empleado.getApellido());
            bufferStr.setLength(super.getCARACTERES_APELLIDO());
            randomFile.writeChars(bufferStr.toString());
            //Escribimos departamento
            randomFile.writeInt(empleado.getDepartamento());
            //Escribimos salario
            randomFile.writeDouble(empleado.getSalario());
            
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
    public void borradorLogico(long identificador){
        RandomAccessFile randomFile = null;
        long posicion = 0;
        try {
            randomFile = new RandomAccessFile(getRuta(),"rw");
            if (randomFile.length()!=0){
                posicion = (identificador - 1)*super.getLONGITUD_TOTAL();
            }
        
            randomFile.seek(posicion);
            
            
            randomFile.writeLong(0);
            
            
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
    public void cambiaApellido(long identificador, String apellido){
        RandomAccessFile randomFile = null;
        long posicion = 0;
        try {
            randomFile = new RandomAccessFile(getRuta(),"rw");
            if (randomFile.length()!=0){
                posicion = ((identificador - 1)*super.getLONGITUD_TOTAL())+super.getLONGITUD_IDENTIFICADOR();
            }
        
            randomFile.seek(posicion);
            //reescribimos apellido
            StringBuffer bufferStr = new StringBuffer(apellido);
            bufferStr.setLength(super.getCARACTERES_APELLIDO());
            randomFile.writeChars(bufferStr.toString());
            
            
            
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
