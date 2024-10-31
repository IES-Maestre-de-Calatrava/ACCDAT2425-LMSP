/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.examenr1_lucas_serrano.modelo;

import com.lmsp.maestre.examenr1_lucas_serrano.modelo.Universidad;
import java.io.File;
import com.lmsp.maestre.examenr1_lucas_serrano.modelo.Escritura;
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
public class Modelo {
    public void crearEstructuraDeCarpetas(String nombreCarpeta1, String nombreCarpeta2){
        File file1 = new File(nombreCarpeta1);
        File file2 = new File(nombreCarpeta2);
        if(file1.exists() || file2.exists()){
            eliminaContenidoCarpeta(nombreCarpeta1);
            eliminaContenidoCarpeta(nombreCarpeta2);
        }
        if(file2.exists()){
            eliminaContenidoCarpeta(nombreCarpeta2);
        }
        if (!file1.exists() && !file2.exists()){
            file1.mkdir();
            file2.mkdir();
        }
    }
    private void eliminaContenidoCarpeta(String nombreCarpeta){
        File directorio = new File(nombreCarpeta);
        if(directorio.isDirectory()){
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        eliminaContenidoCarpeta(archivo.getAbsolutePath()); //Lo llamo recursivamente por si hay subdirectorios
                    }
                    if (!archivo.delete()) { //Si devuelve false es que no se ha podido eliminar
                        System.out.println("No se pudo eliminar: " + archivo.getAbsolutePath());
                    }
                }
            }
            directorio.delete();
        }
    }
    public boolean altaDatosCarrerasUniversitarias(Universidad universidad){
        boolean correcto = false;
        
        return correcto;
    }
             
       
      
    public void generaXMLCarrerasUniversitarias(){
        
    }
    public void generaPlantillaXSL(){
        
    }
    public void modificaCarreraUniversitaria(){
        
    }
    public void generaReporteHtml(){
        
    }
}
