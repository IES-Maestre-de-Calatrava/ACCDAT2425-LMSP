/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.accesoaleatorio.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 14 oct 2024
 */


//Es una alternativa
public class LecturaOther extends FicheroEmpleado {
    public LecturaOther(String ruta){
        super(ruta);
    }
    public Empleado lecturaEmpleado(int identificador){
        RandomAccessFile randomFile = null;
        int posicion = 0;
        Empleado empleado = new Empleado();
        byte[] cadena = new byte[super.getLONGITUD_APELLIDO()];
        
        try {
            randomFile = new RandomAccessFile(getRuta(),"r");
            
            posicion = (identificador - 1)*super.getLONGITUD_TOTAL();
            
                if (posicion < randomFile.length()){
                    randomFile.seek(posicion);
                    //leemos identificador
                    empleado.setIdentificador(randomFile.readLong());
                    //leemos apellido
                    randomFile.read(cadena);
                    empleado.setApellido(new String(cadena));
                    //leeemos departamento
                    empleado.setDepartamento(randomFile.readInt());
                    //leemos salario
                    empleado.setSalario(randomFile.readDouble());
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                randomFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
        
        
    }
    public ArrayList<Empleado> muestraRegistros(){
        RandomAccessFile randomFile = null;
        int posicion = 0;
        
        byte[] cadena = new byte[super.getLONGITUD_APELLIDO()];
        ArrayList<Empleado> empleados = new ArrayList<>();
         try {
            randomFile = new RandomAccessFile(getRuta(),"r");
            
            while(posicion<randomFile.length()){
                    Empleado empleado = new Empleado();
                    randomFile.seek(posicion);
                    long id = randomFile.readLong();
                    if (id!=0){
                        //leemos identificador
                        empleado.setIdentificador(id);
                        //leemos apellido
                        randomFile.read(cadena);
                        empleado.setApellido(new String(cadena));
                        //leeemos departamento
                        empleado.setDepartamento(randomFile.readInt());
                        //leemos salario
                        empleado.setSalario(randomFile.readDouble());
                        posicion = posicion + super.getLONGITUD_TOTAL();

                        empleados.add(empleado);
                    }else{
                        posicion += super.getLONGITUD_TOTAL()-super.getLONGITUD_IDENTIFICADOR();
                    }
            }
             
              
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                randomFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleados;
    }
}