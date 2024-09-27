/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 20 sept 2024
 */
public class Archivo{
    private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }
    
    public Archivo(){
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    /*public void crearArchivo() throws IOException{
       File archivo = new File(rutaCarpeta + "/" + "prueba");
        if (archivo.exists()){
            archivo.createNewFile();
        }else{
            System.out.println("Ya existe un archivo con ese nombre");
        }
    }*/

    public void crearArchivo(String ruta, String nombreArchivo){
        try {
            // Ruta del archivo a crear
            Path archivo = Paths.get(ruta, nombreArchivo);

            // Crear el archivo si no existe
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
                System.out.println("Archivo creado: " + archivo.toString());
            } else {
                System.out.println("El archivo ya existe.");
            }
            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
    /*public void borrarArchivo (String ruta){
        File archivo = new File(ruta);
        if ( archivo.exists()){
            if(archivo.isDirectory()){
                File[] lista = archivo.listFiles();
                for (File file : lista){
                    if(file.isFile()){
                        file.delete();
                        System.out.println("Archivo " + file.getName() + " eliminado");
                     }
                }
            }
            archivo.delete();
     
        }
    }*/
    /*public void borrarArchivo(String ruta){
        try {
            // Ruta del archivo a crear
            Path archivo = Paths.get(ruta);

            // Crear el archivo si no existe
            if (!Files.exists(archivo)) {
                System.out.println("El archivo o directorio no existe.");
            } else {
                if(Files.isDirectory(archivo)){
                    Files.list(archivo).forEach((Path element) -> {
                        if(!Files.isDirectory(element)){
                            try {
                                Files.delete(element);
                            } catch (IOException ex) {
                                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }else{
                    Files.delete(archivo);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al borrar el archivo: " + e.getMessage());
        }
    }
    */
    public void borrarArchivo(String ruta, String nombre){
        Path p = Paths.get(ruta, nombre);
        
        if(Files.exists(p)){
            try {
                Files.list(p).forEach(element -> {
                    if(!Files.isDirectory(element)){
                        try{
                            Files.delete(element);
                            
                        }catch(IOException ex){
                            ex.getMessage();
                        }
                        
                    }
                });
                Files.delete(p);
            } catch (DirectoryNotEmptyException dnee) {
                System.out.println("No esta vacia");
            } catch (IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void renombrarArchivo(String ruta, String nombreNuevo){
        Path origen = Paths.get(ruta);
        Path destino = origen.resolveSibling(nombreNuevo);
        try{
            Files.move(origen, destino);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE,null,ex);
        }
    }    
    /**
     * Copia un archivo de una ruta a otra.
     *
     * @param ruta La ruta del archivo a copiar.
     * @param rutaDestino La ruta de destino donde se copiará el archivo.
     * @throws IOException Si ocurre un error durante la copia del archivo.
     */
    public void copiarArchivo(String ruta, String rutaDestino) throws IOException{
        Path origen = Paths.get(ruta);
        Path destino = Paths.get(rutaDestino);
        try{
            Files.copy(origen, destino);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE,null,ex);
        }
   
    }
    /**
     * Mueve un archivo de una ruta a otra.
     *
     * @param rutaOrigen La ruta del archivo a mover.
     * @param rutaDestino La ruta de destino donde se moverá el archivo.
     * @throws java.io.IOException
     */
    public void moverArchivo(String rutaOrigen, String rutaDestino) throws IOException  {
        Path origen = Paths.get(ruta);
        Path destino = Paths.get(rutaDestino);
        try{
            Files.move(origen, destino);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        


}
