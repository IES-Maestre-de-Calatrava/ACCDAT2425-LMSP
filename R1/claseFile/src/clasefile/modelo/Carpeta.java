/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;

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
     * COnstructor vacio
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
        File directorioNuevo = new File(ruta, nombreDirectorio);
        if (!directorioNuevo.exists()){
            directorioNuevo.mkdir();
        }else{
            System.out.println("Ya existe ese directorio");
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
    public void muestraContenidoCarpeta(String nombreRuta){
        File directorio = new File(nombreRuta);
        
        if(directorio.exists() && directorio.isDirectory()){
          File[] listaFiles = directorio.listFiles(); //Me guardo en una lista todos los objetos files del directorio
            if(listaFiles != null){
                for(File file : listaFiles){ //Recorro la lista
                    if(file.isDirectory()){
                        System.out.println("Directorio: " + file.getName());
                    }
                    else if(file.isFile()){
                        System.out.println("Archivo: " + file.getName() + " Tamaño: " + file.length() + " bytes");
                    }
                }
            }
            else {
                System.out.println("El directorio esta vacio");
            }
        }
        else{
            System.out.println("Ruta invalida");
        }
        
    }
    public void eliminarContenidoCarpeta(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }

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
    }
}
