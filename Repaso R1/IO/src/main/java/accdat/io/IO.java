/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package accdat.io;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class IO {

    public static void main(String[] args) {
//        creaDirectorioIO();
//        creaFicheroIO("panza.txt");
//        creaFicheroIO("azulejo.txt");
//        creaFicheroIO("prueba.txt");
//        compruebaMetodoList();
//          fileList();
          //creaAnidados();
   //       mueveAnidados();
            //System.out.println(getPathPrueba("hola"));
            borraTodo("DirectorioIO");
            
    }
    private static void creaDirectorioIO(){
        //Creamosun File con el Path deseado
        File nuevoDirectorio = new File("."+File.separator+"DirectorioIO"+File.separator+"nuevo");
        //ahora lo creamos
        nuevoDirectorio.mkdir();
    }
    private static void creaFicheroIO(String nombre){
        File fichero = new File("."+File.separator+"DirectorioIO"+File.separator+"nuevo"+File.separator+nombre);
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void compruebaMetodoList(){
        File nuevoDirectorio = new File("."+File.separator+"DirectorioIO");
        String[] lista = nuevoDirectorio.list();
        for(String s : lista){
            System.out.println(s);
            
        }
    }
    private static void fileList(){
        File nuevoDirectorio = new File("."+File.separator+"DirectorioIO");
        File[] lista = nuevoDirectorio.listFiles();
        for(File s : lista){
            System.out.println(s);
            
        }
    }
    private static void creaAnidados(){
        File path = new File(".\\voy\\a\\profundizar\\hondo");
        path.mkdirs();
    }
    private static void mueveAnidados(){
        File origen = new File(".\\voy");
        File destino = new File(".\\hice");
        origen.renameTo(destino);
    }
    private static String getPathPrueba(String nombre){
        File ruta = new File("."+File.separator+nombre);
        return ruta.getPath();
    }
    
    
    private static void borraTodo(String nombre){
        File ruta = new File("."+File.separator+nombre);
        if(ruta.isFile()){
            ruta.delete();
        }else if(ruta.isDirectory()){
            File[] contenido = ruta.listFiles();
            if(contenido.length > 0){
                for(File f: contenido){
                    if(f.isFile()){
                        f.delete();
                    }else if(f.isDirectory()){
                        borraTodo(f.getPath().substring(2));//substring(2) elimina .\ que añade la ruta
                        f.delete();
                    }
                }
            }else{
                ruta.delete();
            }
            ruta.delete();
        }
        
    }
    /**
     * 
     * exists()	Devuelve true si el archivo o directorio existe.
    createNewFile()	Crea un nuevo archivo vacío. Retorna true si se creó correctamente.
    delete()	Borra el archivo o directorio (debe estar vacío si es un directorio).
    isFile()	Devuelve true si es un archivo.
    isDirectory()	Devuelve true si es un directorio.
    mkdir()	Crea un directorio (uno solo).
    mkdirs()	Crea directorios anidados si es necesario.
    list()	Devuelve un array con los nombres de archivos/directorios dentro.
    listFiles()	Devuelve un array de objetos File dentro del directorio.
    renameTo(File dest)	Renombra o mueve el archivo a otra ubicación.
    length()	Retorna el tamaño en bytes del archivo.
    getAbsolutePath()	Devuelve la ruta absoluta del archivo.
    canRead(), canWrite()	Verifica permisos de lectura y escritura.
     */
}
