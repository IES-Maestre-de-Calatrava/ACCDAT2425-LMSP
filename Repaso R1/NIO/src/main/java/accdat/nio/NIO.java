/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package accdat.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class NIO {

    public static void main(String[] args) {
        //pruebaPath();
        //creaArchivo("navego\\hondo\\en\\profundidad\\megustaelqueso.txt");
        //creaDirectorios();
        //copioNoAnidado("navego");
        //muevo("navego");
        eliminoAnidado("nuevoPath");
    }
    /**
     * Método	Descripción
exists(Path)	Comprueba si un archivo o directorio existe.
createFile(Path)	Crea un archivo vacío.
createDirectories(Path)	Crea un directorio (y sus padres si no existen).
copy(Path, Path, CopyOption...)	Copia un archivo o directorio.
move(Path, Path, CopyOption...)	Mueve/renombra un archivo.
delete(Path)	Borra un archivo o directorio.
readAllLines(Path)	Lee todas las líneas de un archivo en una List<String>.
write(Path, byte[])	Escribe bytes en un archivo.
     */
    private static void pruebaPath(){
    Path ruta = Paths.get(".\\nuevoPath");
        try {
            Files.createDirectory(ruta);
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void creaArchivo(String nombre){
        Path ruta = Paths.get(".\\"+nombre);
        try {
            Files.createFile(ruta);
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void creaDirectorios(){
        Path ruta = Paths.get(".\\navego\\hondo\\en\\profundidad");
        try {
            Files.createDirectories(ruta);
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void copioNoAnidado(String nombre){
        Path ruta = Paths.get(".\\"+nombre);
        Path destino = Paths.get(".\\nuevoPath\\mejoraqui");
        try {
            Files.copy(ruta, destino);
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void muevo(String nombre){//va a renombrar el directorio padre, si funciona anidado
        Path ruta = Paths.get(".\\"+nombre);
        Path destino = Paths.get(".\\nuevoPath\\prueboaqui");
        try {
            Files.move(ruta, destino);
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void eliminoAnidado(String nombre){//algo similar con copyanidado
        try {
            Path directory = Paths.get(".\\"+nombre);
            
            
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file); // Borra cada archivo encontrado
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir); // Borra cada directorio después de vaciarlo
                    return FileVisitResult.CONTINUE;
                }
            });
            
            System.out.println("Directorio eliminado con éxito.");
        } catch (IOException ex) {
            Logger.getLogger(NIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
