/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

    public void crearArchivo(String nombreArchivo){
        File archivo = new File(ruta + "/" + nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("Archivo creado correctamente.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
             // + archivo.getAbsolutePath());
        } else {
            System.out.println("Error al crear el archivo, ya existe uno con ese nombre");
        }
    }
    public void borrarArchivo (String nombre){
        File archivo = new File(this.ruta+ "/" + nombre);
        if(archivo.isFile() && archivo.exists()){
            archivo.delete();
        }else{
            if(archivo.isDirectory()){
                File[] lista = archivo.listFiles();
                if(lista != null){
                    for (File file : lista){
                        if(file.isFile()){
                            file.delete();
                            System.out.println("Archivo " + file.getName() + " eliminado");
                        }
                    }
                }
                System.out.println("Borrando directorio...");
                archivo.delete();
            }
        }
    }
    public void renombrarArchivo(String ruta, String nombreNuevo){
        File archivo = new File(ruta);
        File archivoNuevo = new File(archivo.getParent(),nombreNuevo);
        if(archivo.isFile()){
            boolean exito = archivo.renameTo(archivoNuevo);
            if(exito){
                System.out.println("El archivo se ha renombrado con exito");
            }
            else{
            System.out.println("No se ha podido renombrar el archivo");
             }
        }
        else{
            System.out.println("El archivo especificado no existe");
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
        File archivo = new File(ruta);
        File archivoDestino = new File(rutaDestino);
        
        if(!archivo.exists()){
            throw new IOException("El archivo no existe");
        }
        
        if(!archivoDestino.exists()){
            archivoDestino.createNewFile();
        }
        Files.copy(archivo.toPath(), archivoDestino.toPath());
    }
    /**
     * Mueve un archivo de una ruta a otra.
     *
     * @param rutaOrigen La ruta del archivo a mover.
     * @param rutaDestino La ruta de destino donde se moverá el archivo.
     */
    public void moverArchivo(String rutaOrigen, String rutaDestino) {
        File origen = new File(rutaOrigen);
        File destino = new File(rutaDestino);
        destino.getParentFile().mkdirs();   
        origen.renameTo(destino);
    }
        


}
