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
    private String rutaCarpeta;

    public Archivo(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
    }
    
    public Archivo(){
    }

    public void setRutaCarpeta(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
    }
    
    /*public void crearArchivo() throws IOException{
       File archivo = new File(rutaCarpeta + "/" + "prueba");
        if (archivo.exists()){
            archivo.createNewFile();
        }else{
            System.out.println("Ya existe un archivo con ese nombre");
        }
    }*/

    public void crearArchivo(String nombreArchivo) throws IOException {
        File archivo = new File(rutaCarpeta + "/" + nombreArchivo);
        if (!archivo.exists()) {
            archivo.createNewFile();
            System.out.println("Archivo creado correctamente"); // + archivo.getAbsolutePath());
        } else {
            System.out.println("Error al crear el archivo.");
        }
    }
    public void borraArchivo (String nombre){
        File archivo = new File(this.rutaCarpeta+ "/" + nombre);
        if(archivo.isFile() && archivo.exists()){
            archivo.delete();
        }
    }

}
