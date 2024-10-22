/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.fileaccesoaleatorio.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para escribir el contenido de un archivo de acceso aleatorio
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 1 oct 2024
 */
public class Escritura extends FicheroEmpleados{
  
    public Escritura(String ruta) {
         super(ruta);
    }
       
    /**
     * Añade un empleado al final del archivo
     * 
     * @param empleado Empleado con los datos a añadir
     */
    public void escribirEmpleadoFinalArchivo(Empleado empleado){
        
        // RamdomAccessFile para acceso a un fichero de forma aleatoria       
        RandomAccessFile randomFile = null;
        // Posición inicial para el caso de que el archivo esté vacío
        long posicion = 0; 
        // Buffer para escribir el apellido
        StringBuffer bufferStr = null;
        
        try {
              
            randomFile = new RandomAccessFile(getRuta(), "rw");
            
            // Si el archivo no está vacío nos posicionamos en la última posición
            if (randomFile.length()!=0) {
               posicion = (randomFile.length());
            }
            
            // Nos situamos en la posición en la que vamos a escribir 
            randomFile.seek(posicion);
            
            // Calculamos y escribimos el identificador del empleado
            // Imagina que la posicion es 120 y el tamaño del registro 40 (nos lo da getLONGITUD_TOTAL) => El id sería 120/40+1= 4 
            // El id sería el 4 porque ya hay 3 registros anteriores de 40 bytes cada uno.            
            randomFile.writeLong(posicion/super.getLONGITUD_TOTAL() + 1);   
            
            // Escribimos el apellido del empleado
            bufferStr = new StringBuffer(empleado.getApellido());
            bufferStr.setLength(super.getCARACTERES_APELLIDO()); // Fijamos el tamaño del buffer
            randomFile.writeChars(bufferStr.toString());
            
            // Escribimos el número del departamento
            randomFile.writeInt(empleado.getDepartamento());
            
            // Escribimos el salario
            randomFile.writeDouble(empleado.getSalario());        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                randomFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
