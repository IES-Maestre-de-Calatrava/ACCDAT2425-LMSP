/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.filestreamsbytes.modelo;

import java.io.File;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 4 oct 2024
 */
public class Fichero {
    private File ruta;
    public Fichero(String ruta){
        this.ruta = new File(ruta);
    }
    public File getRuta(){
        return ruta;
    }
    public void setRuta(String ruta){
        this.ruta = new File(ruta);
    }
     public boolean existeFile(File path){
        File file = path;
        if(file.exists() && file.isFile()){
            return true;
        }
        else{
            return false;
        }
     }
    
}