/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.Files;

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
    public void borrarArchivo (String ruta){
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
        }else{
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
        // Crear un flujo de entrada para el archivo de origen
        FileInputStream entrada = new FileInputStream(archivo);

        // Crear un flujo de salida para el archivo de destino
        FileOutputStream salida = new FileOutputStream(archivoDestino);

        // Copiar el contenido del archivo de origen al archivo de destino
        byte[] buffer = new byte[1024];
        int leidos;
        while ((leidos = entrada.read(buffer)) != -1) {
            salida.write(buffer, 0, leidos);
        }

        // Cerrar los flujos
        entrada.close();
        salida.close();
    }
    /**
     * Mueve un archivo de una ruta a otra.
     *
     * @param rutaOrigen La ruta del archivo a mover.
     * @param rutaDestino La ruta de destino donde se moverá el archivo.
     */
    public void moverArchivo(String rutaOrigen, String rutaDestino) throws IOException  {
        File origen = new File(rutaOrigen);
        copiarArchivo(rutaOrigen, rutaDestino);
   
        // Eliminar el archivo de origen
        origen.delete();
    }
        


}
