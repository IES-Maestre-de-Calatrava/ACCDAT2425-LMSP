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
import java.util.stream.Stream;

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
       File directorioNuevo = new File(ruta);
       directorioNuevo.mkdir();
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
    public void crearCarpeta(File directorioRaiz, String nombreDirectorio){
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
    
    
    
    public void muestraContenidoCarpeta(){
        Path directorio = Paths.get(ruta);
        
        if(Files.exists(directorio) && Files.isDirectory(directorio)){
            try {
                Stream<Path> archivos = Files.list(directorio);
                Files[] aArchivos = archivos.toArray(Files[]::new);
                if (aArchivos.length != 0){
                for(Files file : aArchivos){ //Recorro la lista
                    /*if(file.isDirectory(directorio)){
                        System.out.println("Directorio: " + file.getName(directorio));
                    }
                    else if(file.isFile()){
                        System.out.println("Archivo: " + file.getName() + " Tamaño: " + file.length() + " bytes");
                    }^*/
                }
            }else{
                System.out.println("El directorio esta vacio.");
            }
            } catch (IOException ex) {
                Logger.getLogger(Carpeta.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        else{
            System.out.println("Ruta invalida o no es un directorio");
        }
        
    }
    public void eliminarContenidoCarpeta(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);

        
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }else{

            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        eliminarContenidoCarpeta(archivo.getAbsolutePath()); //Lo llamo recursivamente por si hay subdirectorios
                    }
                    if (!archivo.delete()) { //Si devuelve false es que no se ha podido eliminar
                        System.out.println("No se pudo eliminar: " + archivo.getAbsolutePath());
                    }
                }
            }
            directorio.delete();
        }
    }
    

}
