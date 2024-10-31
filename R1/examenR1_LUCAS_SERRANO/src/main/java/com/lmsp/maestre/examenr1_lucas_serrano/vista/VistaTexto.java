/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmsp.maestre.examenr1_lucas_serrano.vista;

import com.lmsp.maestre.examenr1_lucas_serrano.controlador.Controlador;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
    public String getFolder() {
       System.out.println("Introduce nombre de carpeta: ");
       return leeString();
    }
    @Override
    public long getId() {
       System.out.println("Introduce ID: ");
       return leeInt();
    }

    @Override
    public String getCarrera() {
       System.out.println("Introduce nombre de carrera: ");
       return leeString();
    }

    @Override
    public String getCiudad() {
       System.out.println("Introduce nombre de ciudad: ");
       return leeString();
    }

    @Override
    public double getNotaCorte() {
        System.out.println("Introduce nombre de carpeta: ");
       return leeDouble();
    }

    
    
    private void seleccionaOperacion(){
        System.out.println("=========================================================== ");
        System.out.println("0: Salir");
        System.out.println("1: Crear estructuras de carpetas");
        System.out.println("2: Alta datos Carreras Universitarias");
        System.out.println("3: Generar archivo XML con Carreras universitarias");
        System.out.println("4: Generación de plantilla XSL");
        System.out.println("5: Modificar Carrera Universitaria");
        System.out.println("6: Generación de página web con Carreras Universitarias");
        System.out.println("=========================================================== ");
        System.out.println("    Introduzca la opción:");
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
    private int leeInt(){
        int i = 0;
        try{
            i = Integer.parseInt(in.readLine());
            return i;
        }catch (IOException e){
            System.out.println("Error en el entero introducido");
            return leeInt();
        }
    }
    private double leeDouble(){
        double i = 0;
        try{
            i = Double.parseDouble(in.readLine());
            return i;
        }catch (IOException e){
            System.out.println("Error en el double introducido");
            return leeDouble();
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
            case 1 -> controlador.actionPerformed(new ActionEvent(this, opcion, CREAESCTRUCTURACARPETAS));
            case 2 -> controlador.actionPerformed(new ActionEvent(this, opcion, ALTADATOSCARRERAS));
            case 3 -> controlador.actionPerformed(new ActionEvent(this, opcion, GENERAXMLCARRERAS));
            case 4 -> controlador.actionPerformed(new ActionEvent(this, opcion, GENERAPLANTILLAXSL));
            case 5 -> controlador.actionPerformed(new ActionEvent(this, opcion, MODIFICACARRERA));
            case 6 -> controlador.actionPerformed(new ActionEvent(this, opcion, GENERAREPORTEHTML));
            default ->operacionIncorrecta();
        }
        procesa();
    }

    

}