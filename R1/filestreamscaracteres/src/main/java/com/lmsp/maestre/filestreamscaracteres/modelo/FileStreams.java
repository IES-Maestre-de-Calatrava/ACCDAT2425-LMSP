/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.filestreamscaracteres.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 30 sept 2024
 */
public class FileStreams {
    private String path;
    private File archivo;

    public FileStreams(String ruta) {
        this.path = ruta;
        archivo = new File(path);
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public void setFile(){
        this.archivo = new File(path);
    }
    public void creaFichero(){
        Path p = Paths.get(path);
        if(!Files.exists(p)){
            try {
                Files.createFile(p);
            } catch (IOException ex) {
                Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean existeFichero(){
        boolean existe = false;
        Path p = Paths.get(path);
        if(Files.exists(p)){
            existe = true;
        }
        return existe;
    }
    public void noExiste(){
        String noExiste = "El fichero introducido no existe, solo puedes seleccionar opciones de escritura para crearlo";
        System.out.println(noExiste);
    }
    
    public void leerStreamCaracteres(){
        //path = "texto";
        StringBuffer sbOut = new StringBuffer(50);
        int i=0;
        try {
            FileReader archivoInTexto = new FileReader(archivo);
            i = archivoInTexto.read(); 
            while(i!=-1){
                sbOut.append((char)i);
                i = archivoInTexto.read(); 
                
            }
            archivoInTexto.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        String salida = sbOut.toString();
        System.out.println(salida);
    }
    public void leerStreamArrayCaracteres(){
        int i=0;
        char cadena[] = new char[5];
        try {
            FileReader archivoInTexto = new FileReader(archivo);
            i = archivoInTexto.read(cadena); 
            while(i!=-1){
                System.out.print(cadena);
                Arrays.fill(cadena, '\0');
                i = archivoInTexto.read(cadena); 
                
            }
            System.out.println(" ");
            archivoInTexto.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void leerStreamBufferedReader(){
        String linea;
        
        try {
            FileReader archivoInTexto = new FileReader(archivo);
            BufferedReader bufferInTexto = new BufferedReader(archivoInTexto);
            
            linea = bufferInTexto.readLine(); 
            while(linea!=null){
                System.out.println(linea);
                linea = bufferInTexto.readLine();                
            }
            bufferInTexto.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void escribirStreamCaracter(char caracter, boolean sobreescribe){
       FileWriter ficheroOut = null;
       try{
           ficheroOut = new FileWriter(archivo,sobreescribe);
           ficheroOut.write(caracter);
           
           ficheroOut.close();
       } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void escribirStreamArrayCaracteres(char[] caracteres, boolean sobreescribe){
       FileWriter ficheroOut = null;
       try{
           ficheroOut = new FileWriter(archivo, sobreescribe);
           ficheroOut.write(caracteres);
           
           ficheroOut.close();
       } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void escribirStreamBufferedCaracteres(String cadena, boolean sobreescribe){
        FileWriter ficheroOut = null;
        try {
            ficheroOut = new FileWriter(path, sobreescribe);
            BufferedWriter bufferedficheroOut = new BufferedWriter(ficheroOut);
            bufferedficheroOut.write(cadena);
            bufferedficheroOut.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ficheroOut.close();
            } catch (IOException ex) {
                Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void escribirBufferedPrintCaracteres(String cadena, boolean sobreescribe){
        FileWriter ficheroOut = null;
        try {
            ficheroOut = new FileWriter(path, sobreescribe);
            //BufferedWriter bufferedficheroOut = new BufferedWriter(ficheroOut);
            PrintWriter printFicheroOut = new PrintWriter(ficheroOut);
            printFicheroOut.print(cadena);
            printFicheroOut.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ficheroOut.close();
            } catch (IOException ex) {
                Logger.getLogger(FileStreams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
