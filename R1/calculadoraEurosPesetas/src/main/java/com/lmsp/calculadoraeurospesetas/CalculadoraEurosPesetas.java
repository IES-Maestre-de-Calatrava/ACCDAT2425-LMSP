/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.calculadoraeurospesetas;

import java.util.Scanner;
/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class CalculadoraEurosPesetas {

    public static void main(String[] args) {
        System.out.println("Indica la operacion que quieres realizar:");
        System.out.println("1: convertir euros a pesetas");
        System.out.println("2: convertir pesetas a euros");
        System.out.println("0: salir");
        
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        
        switch(opcion){
            case 1 -> {
                System.out.println("Introduce cantidad de euros: ");
                int euros = sc.nextInt();
                System.out.println(calculadoraEuroPeseta(euros)+" pesetas.");
            }
            case 2 -> {
                System.out.println("Introduce cantidad de pesetas: ");
                int pesetas = sc.nextInt();
                System.out.println(calculadoraPesetaEuro(pesetas)+" euros.");
            }
            case 0 -> {
                System.out.println("Ha seleccionado la opción de salir... hasta la proxima");
                break;
            }
            default -> {
                System.out.println("Debes introducir un valor valido");
            }
                
        }
    }
    
    public static double calculadoraEuroPeseta(double euros){
        return euros*166.386;
    }
    public static double calculadoraPesetaEuro(double pesetas){
        return pesetas/166.386;
    }
}
