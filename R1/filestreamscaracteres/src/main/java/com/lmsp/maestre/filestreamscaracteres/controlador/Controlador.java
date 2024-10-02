/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmsp.maestre.filestreamscaracteres.controlador;

import com.lmsp.maestre.filestreamscaracteres.modelo.FileStreams;
import com.lmsp.maestre.filestreamscaracteres.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener{

    private final InterfazVista vista;
    private final FileStreams modelo;
    
    public Controlador(InterfazVista vista, FileStreams modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        char caracter;
        char[] caracteres;
        boolean sobreescribe;
        String cadena;
        boolean existe = modelo.existeFichero();
        
        switch(e.getActionCommand()){
            case InterfazVista.LEESTRINGBUFFER -> {
                if(existe){
                    modelo.leerStreamCaracteres();
                }else{
                    modelo.noExiste();
                }
            }
            case InterfazVista.LEEARRAY -> {
                if(existe){
                    modelo.leerStreamArrayCaracteres();
                }else{
                    modelo.noExiste();
                }
            }
            case InterfazVista.LEEBUFFEREDREADER -> {
                if(existe){
                    modelo.leerStreamBufferedReader();
                }else{
                    modelo.noExiste();
                }
            }  
            case InterfazVista.ESCRIBEOSOBREESCRIBE -> {
                if(existe){
                    sobreescribe = vista.getBoolean();
                    caracter = vista.getChar();
                    modelo.escribirStreamCaracter(caracter, sobreescribe);
                }else{
                    modelo.creaFichero();
                    sobreescribe = vista.getBoolean();
                    caracter = vista.getChar();
                    modelo.escribirStreamCaracter(caracter, sobreescribe);
                }
                
            }
            case InterfazVista.ESCRIBEOSOBREESCRIBEARRAY ->{
                if(existe){
                    sobreescribe = vista.getBoolean();
                    caracteres = vista.getArrayChar();
                    modelo.escribirStreamArrayCaracteres(caracteres, sobreescribe);
                }else{
                    modelo.creaFichero();
                    sobreescribe = vista.getBoolean();
                    caracteres = vista.getArrayChar();
                    modelo.escribirStreamArrayCaracteres(caracteres, sobreescribe);
                }
                
            }
            case InterfazVista.ESCRIBEBUFFEREDWRITER ->{
                if(existe){
                    sobreescribe = vista.getBoolean();
                    cadena = vista.getChain();
                    modelo.escribirStreamBufferedCaracteres(cadena, sobreescribe);
                }else{
                    modelo.creaFichero();
                    sobreescribe = vista.getBoolean();
                    cadena = vista.getChain();
                    modelo.escribirStreamBufferedCaracteres(cadena, sobreescribe);
                }
                
            }
            case InterfazVista.ESCRIBEPRINTWRITER ->{
                if(existe){
                    sobreescribe = vista.getBoolean();
                    cadena = vista.getChain();
                    modelo.escribirBufferedPrintCaracteres(cadena, sobreescribe);
                }else{
                    modelo.creaFichero();
                    sobreescribe = vista.getBoolean();
                    cadena = vista.getChain();
                    modelo.escribirBufferedPrintCaracteres(cadena, sobreescribe);
                }
                
            }
        }
    }
}
