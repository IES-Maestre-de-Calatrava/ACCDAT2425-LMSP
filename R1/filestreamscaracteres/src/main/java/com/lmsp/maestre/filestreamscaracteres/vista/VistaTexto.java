/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmsp.maestre.filestreamscaracteres.vista;

import com.lmsp.maestre.filestreamscaracteres.controlador.Controlador;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

/**
 *
 * @author Usuario
 */
public class VistaTexto implements InterfazVista {

    private Controlador controlador;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    @Override
    public void setControlador(Controlador c) {
        this.controlador = c;
    }

    @Override
    public void arranca() {
        procesa();
    }
    
    @Override
    public String getPath(){
        System.out.println("Introduce la ruta del archivo, con su nombre: ");
        return leeString();
    }
    
    @Override
    public boolean getBoolean() {
        System.out.println("¿Sobreescribir?: [S/n]");
        Boolean sE;
        String seleccion = leeString();
        switch(seleccion){
            case "N","n","No","no"-> sE = false;
            case "S","s","Si","si"-> sE = true;
            default -> {sE = true; System.out.println("Opcion por defecto-> S");}
        }
        
        return sE;
    }
     @Override
    public char getChar() {
        System.out.println("Introduce un caracter: ");
        char c = leeString().charAt(0);
        return c;
    }
    @Override
    public char[] getArrayChar() {
        System.out.println("Introduce varios caracteres: (seran almacenados en un array) ");
        return leeString().toCharArray();
    }
    @Override
    public String getChain() {
       System.out.println("Introduce una cadena: ");
       return leeString();
    }

    
    
    private void seleccionaOperacion(){
        System.out.println("************************************************************ ");
        System.out.println("Selecciona una operacion.");
        System.out.println("1: Leer caracteres uno a uno usando StringBuffer(50)");
        System.out.println("2: Leer caracteres usando un array(5)");
        System.out.println("3: Leer lineas usando BufferedReader");
        System.out.println("4: Escribir o sobreescribir caracter a caracter");
        System.out.println("5: Escribir o sobreescribir usando array de caracteres");
        System.out.println("6: Escribir o sobreescribir usando BufferedWriter");
        System.out.println("7: Escribir o sobreescribir usando PrintWriter");
        System.out.println("0: Salir");
    }
    private int leeOpcion(){
       String s = null;
        try {
            s = in.readLine();
            return Integer.parseInt(s);
        } catch (IOException | NumberFormatException e) {
            operacionIncorrecta();
            return 0;
        }
        
    }
        private String leeString(){
        String s = null;
        try{
            s = in.readLine();
            return s;
        }catch (IOException e){
            System.out.println("Error en la cadena introducida");
            return leeString();
        }
    }

    private void operacionIncorrecta() {
        System.out.println("Se ha solicitado una operacion incorrecta, "
                + "selecciona una opcion de la lista...");
        procesa();
    }
    private void procesa(){
        int opcion;
        seleccionaOperacion();
        opcion = leeOpcion();
        switch(opcion){
            case 0 ->{
                System.out.println("Adios.");
                System.exit(0);
            }
            case 1 -> controlador.actionPerformed(new ActionEvent(this, opcion, CREAESTRUCTURACARPETAS));
            case 2 -> controlador.actionPerformed(new ActionEvent(this, opcion, LEEARRAY));
            case 3 -> controlador.actionPerformed(new ActionEvent(this, opcion, LEEBUFFEREDREADER));
            case 4 -> controlador.actionPerformed(new ActionEvent(this, opcion, ESCRIBEOSOBREESCRIBE));
            case 5 -> controlador.actionPerformed(new ActionEvent(this, opcion, ESCRIBEOSOBREESCRIBEARRAY));
            case 6 -> controlador.actionPerformed(new ActionEvent(this, opcion, ESCRIBEBUFFEREDWRITER));
            case 7 -> controlador.actionPerformed(new ActionEvent(this, opcion, ESCRIBEPRINTWRITER));
            default ->operacionIncorrecta();
        }
        procesa();
    }

    
    

   

    
    
    
}
