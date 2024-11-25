/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.break4learning.paquetenio.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de la lógica de la aplicación
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 10 sept 2024
 */
public class Carpeta {

    private String ruta;
    
     /**
     * Constructor de la clase
     * 
     * @param ruta   Ruta de la carpeta
     */
    public Carpeta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Constructor vacío de la clase
     */
    public Carpeta() {
    }

    /**
     * Setter del atributo ruta
     * 
     * @param ruta 
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Getter del atributo ruta
     * @return Devuelve el contenido del atributo ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Devuelve en un File la ruta de la carpeta
     * @return  File con la carpeta
     */
    public Path getPathDeRuta(){
        Path directorioRaiz = Paths.get(ruta);
        return directorioRaiz;
    }
      
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos la ruta completa 
     */
    public void crearCarpeta(){
       
        crearCarpetaInterna(ruta);
    }
    
    /**
     * Clase complementaria para agrupar el código que crea las carpetas
     * 
     * @param ruta 
     */
    private void crearCarpetaInterna(String ruta){
        Path p = Paths.get(ruta);
        
        if (Files.exists(p)){
            System.out.println("El directorio ya existe");
        } else{
            try {
                Path donePath=Files.createDirectories(p);
                System.out.println("Directorio creado en "+donePath.toString());
            } catch (IOException ex) {
                Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos la ruta del directorio padre y el nombre del nuevo directorio
     * 
     * @param nombreDirectorio  Nombre del nuevo directorio
     */
    public void crearCarpeta(String nombreDirectorio){
        crearCarpetaInterna(ruta+"\\"+nombreDirectorio); 
    }
    
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos el directorio padre y el nombre del nuevo directorio
     * 
     * @param directorioRaiz    Path que representa al directorio padre en el cual vamos a crear el nuevo directorio
     * @param nombreDirectorio  Nombre del nuevo directorio
     */
    public void crearCarpeta(Path directorioRaiz, String nombreDirectorio){
        crearCarpetaInterna(directorioRaiz.toString()+"\\"+nombreDirectorio);  
    }
}
