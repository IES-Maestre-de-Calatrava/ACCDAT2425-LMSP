/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.break4learning.clasefile.modelo;

import java.io.File;

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
    public File getFileDeRuta(){
        File directorioRaiz = new File(ruta);
        return directorioRaiz;
    }
      
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos la ruta completa 
     */
    public void crearCarpeta(){
        File directorioNuevo = new File(ruta);
        directorioNuevo.mkdir(); 
    }
    
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos la ruta del directorio padre y el nombre del nuevo directorio
     * 
     * @param nombreDirectorio  Nombre del nuevo directorio
     */
    public void crearCarpeta(String nombreDirectorio){
        File directorioNuevo = new File(ruta,nombreDirectorio);
        directorioNuevo.mkdir(); 
    }
    
    /**
     * Crea un directorio en la ruta indicada
     * Utiliza el constructor al cual le pasamos el directorio padre y el nombre del nuevo directorio
     * 
     * @param directorioRaiz    File que representa al directorio padre en el cual vamos a crear el nuevo directorio
     * @param nombreDirectorio  Nombre del nuevo directorio
     */
    public void crearCarpeta(File directorioRaiz, String nombreDirectorio){
        File directorioNuevo = new File(directorioRaiz,nombreDirectorio);
        directorioNuevo.mkdir(); //Crea el directorio
    }
}
