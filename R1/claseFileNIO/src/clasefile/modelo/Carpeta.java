/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada d ela logica de la aplicacion
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public class Carpeta {
    private String ruta;
    /**
     * Constructor de la clase
     * @param ruta 
     */
    public Carpeta(String ruta){
        this.ruta = ruta;
    }
    /**
     * Constructor vacio
     */
    public Carpeta(){
  
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
     * Metodo que crea un direcctorio en la ruta indicada
     * Utiliza el atributo d ela clase
     */
    public void crearCarpeta(){
        try {
            Files.createDirectories(Paths.get(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Crea un directorio en la ruta indicada
     * utiliza el constructor al cual le pasamos la ruta del directorio padre 
     * y el nombre del nuevo directorio
     * 
     * @param nombreDirectorio Nombre del nuevo directorio
     */
    public void crearCarpeta(String nombreDirectorio){
        Path p = Paths.get(nombreDirectorio);
        if (Files.exists(p)){
            //Este sout
            //return ("El directorio ya existe");
        }else{
            try{
                Path donePath = Files.createDirectories(p);
            }catch (IOException ex){
               // Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
                //return "El directorio ha sido creado.";
            }
            
        }
         
    }
    /**
     * Crea un directorio en ruta indicada utilizando File y nombre
     * @param directorioRaiz File con ruta
     * @param nombreDirectorio Nombre del nuevo directorio
     */
    public void crearCarpeta(String directorioRaiz, String nombreDirectorio){
        File directorioNuevo = new File(directorioRaiz, nombreDirectorio);
        if (!directorioNuevo.exists()){
            directorioNuevo.mkdir();
        }else{
            System.out.println("Ya existe ese directorio");
        }
    }
    
    public void crearCarpeta(Path directorioRaiz, String nombreDirectorio){
        crearCarpeta(directorioRaiz.toString()+"\\"+nombreDirectorio);
    }
    
    
    
    public void muestraContenidoCarpeta(String ruta){
    
        Path dir = Paths.get(ruta);
        
        try {
            Files.list(dir).forEach(path -> {
                System.out.println(path.getFileName()+ " --- " + path.getFileSystem());
            });
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void eliminarContenidoCarpeta(String rutaDirectorio) {
        Path directorio = Paths.get(rutaDirectorio);
        
        if (Files.isDirectory(directorio)) {
            try{
                Files.list(directorio).forEach(archivo ->{
                    if (Files.isDirectory(archivo)) {
                        eliminarContenidoCarpeta(archivo.toString()); //Lo llamo recursivamente por si hay subdirectorios
                    }else{
                        try { 
                            Files.deleteIfExists(archivo);
                        } catch (IOException ex) {
                            Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                Files.deleteIfExists(directorio);
            }catch(IOException ex){
                Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            System.out.println("No es un directorio o no existe");
        }
    }
    

}
