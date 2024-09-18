/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.vista;

import clasefile.controlador.ControlCarpeta;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public class CarpetaVistaTexto implements InterfazVista{
    private ControlCarpeta controlador;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void setControlador(ControlCarpeta c) {
        this.controlador = c;
    }

    @Override
    public void arranca() {
        procesaNuevaOperacion();
    }

    @Override
    public String getRuta() {
        System.out.println("Introduce la ruta");
        return leeString();
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
  
    /**
     * Muestra el menú con las opciones
     */
    private void solicitaOperacion() {
        System.out.println("Indica la operacion que quiere realizar:");
        System.out.println("1: crear carpeta");
        System.out.println("0: salir");
    }

    /**
     * Procesa la opción elegida por el usuario
     */
    private void procesaNuevaOperacion() {
        int operacion;
        solicitaOperacion();
        operacion = leeOpcion();
        switch (operacion) {
            case 0 -> {
                System.out.println("Adios.");
                System.exit(0);
            }
            case 1 -> controlador.actionPerformed(new ActionEvent(this, operacion, CREARCARPETACONRUTACOMPLETA));
            default -> operacionIncorrecta();
        }
        procesaNuevaOperacion();
    }

    /**
     * Procesa el caso de que introduzcamos una opción que no sea una de las indicadas
     */
    private void operacionIncorrecta() {
        System.out.print("Operación incorrecta. ");
        procesaNuevaOperacion();
    }

}

