/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 20 sept 2024
 */
public class Archivo{
    private String ruta;
    /**
     * Constructor de la clase
     * @param ruta 
     */
    public Archivo(String ruta){
        this.ruta = ruta;
    }
    /**
     * COnstructor vacio
     */
    public Archivo(){
  
    }

    public String getRuta() {
        return ruta;
    }
    /**
     * Devuelve un File la ruta de la carpeta
     * @return File que apunta a la carpeta
     */
    public File getFileDeRuta(){
        File directorioRaiz = new File(ruta);
        return directorioRaiz;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    /**
     * Metodo que crea un archivo en la ruta indicada
     * Utiliza el atributo de la clase
     */
    public void crearArchivo(){
       File archivoNuevo = new File(ruta);
       try{
            archivoNuevo.createNewFile();
       }catch (IOException e){
           System.out.println("Ocurrio un error.");
       }
    }
    /**
     * Crea un archivo en la ruta indicada
     * utiliza el constructor al cual le pasamos la ruta del directorio padre 
     * y el nombre del archivo
     * 
     * @param nombreDirectorio Nombre del nuevo archivo
     */
    public void crearArchivo(String nombreArchivo){
        File archivoNuevo = new File(ruta, nombreArchivo);
        try{
            if (!archivoNuevo.exists()){
                archivoNuevo.createNewFile();
            }else{
                System.out.println("Ya existe un archivo llamado igual");
            }
        }catch (IOException e){
           System.out.println("Ocurrio un error.");
        }  
    }
    /**
     * Crea un directorio en ruta indicada utilizando File y nombre
     * @param directorioRaiz File con ruta
     * @param nombreDirectorio Nombre del nuevo directorio
     */
    public void crearArchivo(File directorioRaiz, String nombreArchivo){
        File archivoNuevo = new File(directorioRaiz, nombreArchivo);
        try{
            if (!archivoNuevo.exists()){
                archivoNuevo.createNewFile();
            }else{
                System.out.println("Ya existe un archivo llamado igual");
            }
        }catch (IOException e){
           System.out.println("Ocurrio un error.");
        }  
           
    }
}
