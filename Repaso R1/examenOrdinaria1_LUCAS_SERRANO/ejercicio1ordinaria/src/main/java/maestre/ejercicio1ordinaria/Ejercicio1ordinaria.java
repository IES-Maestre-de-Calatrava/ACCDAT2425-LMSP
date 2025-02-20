/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.ejercicio1ordinaria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Ejercicio1ordinaria {

    public static void main(String[] args) {
        //utilidadCreaDirectorios("destino\\final");
        //utilidadCreaArchivo("anestesia.txt","azul");
        utilidadBuscaYMueveArchivo("anestesia.txt","azul","destino\\final");
    }
    public static void utilidadCreaDirectorios(String ruta){
        File directorio = new File("."+File.separator+ruta);
        if(directorio.mkdirs()){
            System.out.println("Directorio/s creado/s con exito");         
        }
    }
    public static void utilidadCreaArchivo(String nombreArchivo, String rutaPartida){
        File archivo = new File("."+File.separator+rutaPartida,nombreArchivo);
        try {
            if(archivo.createNewFile()){
                System.out.println("Archivo creado con exito");
            }
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void utilidadBuscaYMueveArchivo(String nombreArchivo, String rutaPartida, String rutaCopia){
        File ruta = new File("."+File.separator+rutaPartida);
        File rutaDestino = new File("."+File.separator+rutaCopia+File.separator+nombreArchivo);
        File[] contenido = ruta.listFiles();
        for(File f: contenido){
            if(f.isFile() && f.getName().equals(nombreArchivo)){
                if(f.renameTo(rutaDestino)){
                    System.out.println("Movido con exito");
                }else{
                    System.out.println("No ha movido");
                }
            }
        }
    }
   
     public static void ocupaEjercicio1(String nombreArchivo, String rutaPartida, String rutaCopia){
        File ruta = new File("."+File.separator+rutaPartida);
        File rutaDestino = new File("."+File.separator+rutaCopia+File.separator+nombreArchivo);
        File[] contenido = ruta.listFiles();
        List<File> archivosEncontrados = new ArrayList<>();
        for(File f: contenido){
            if(f.isFile() && f.getName().equals(nombreArchivo)){
                archivosEncontrados.add(f);
            }
        }
    }
//    private static void ocupaEjercicio1(String nombreArchivo, String rutaPartida, String rutaCopia){
//        File archivo = new File("."+File.separator+rutaPartida,nombreArchivo);
//        if(ruta.isFile()){
//            ruta.delete();
//        }else if(ruta.isDirectory()){
//            File[] contenido = ruta.listFiles();
//            if(contenido.length > 0){
//                for(File f: contenido){
//                    if(f.isFile()){
//                        f.delete();
//                    }else if(f.isDirectory()){
//                        borraTodo(f.getPath().substring(2));//substring(2) elimina .\ que añade la ruta
//                        f.delete();
//                    }
//                }
//            }else{
//                ruta.delete();
//            }
//            ruta.delete();
//        }
//        
//    }
}
