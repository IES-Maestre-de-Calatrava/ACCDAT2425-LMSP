/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmsp.maestre.filestreamscaracteres.controlador;

import com.lmsp.maestre.filestreamscaracteres.modelo.FileStreams;
import com.lmsp.maestre.filestreamscaracteres.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        String path = vista.getPath();
        Path p = Paths.get(path);
        if(Files.exists(p)){
            modelo.setPath(path);
            modelo.setFile();
        }else{
            modelo.setPath("");
            modelo.setFile();
        }
        
        char caracter = 'J';
        char[] caracteres = {'H','o','l','a'};
        switch(e.getActionCommand()){
            case InterfazVista.LEESTRINGBUFFER -> modelo.leerStreamCaracteres();
            case InterfazVista.LEEARRAY -> modelo.leerStreamArrayCaracteres();
            case InterfazVista.LEEBUFFEREDREADER -> modelo.leerStreamBufferedReader();
            case InterfazVista.ESCRIBEOSOBREESCRIBE -> modelo.escribirStreamCaracter(caracter, true);
            case InterfazVista.ESCRIBEOSOBREESCRIBEARRAY -> modelo.escribirStreamArrayCaracteres(caracteres, true);
            
        }
    }
}
