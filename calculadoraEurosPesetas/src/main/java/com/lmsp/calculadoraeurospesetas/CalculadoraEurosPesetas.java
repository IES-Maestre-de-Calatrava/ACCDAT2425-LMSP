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
        System.out.println("Indica la operación que quieres realizar:");
        System.out.println("1: convertir euros a pesetas");
        System.out.println("2: convertir pesetas a euros");
        System.out.println("0: salir");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt;
        if (opcion == 1){
            return calculadoraEuroPeseta(1.0);
        }
    }
    
    public static double calculadoraEuroPeseta(double euros){
        return euros*166.386;
    }
    public static double calculadoraPesetaEuro(double pesetas){
        return pesetas/166.386;
    }
}
