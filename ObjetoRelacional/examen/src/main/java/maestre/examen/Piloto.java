/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package maestre.examen;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 5 feb 2025
 */
public class Piloto {
    private String dni;
    private int horas_de_vuelo;
    private int horas_de_vuelo_anual;
    public Piloto(String dni, int horas_de_vuelo, int horas_de_vuelo_anual){
        this.dni = dni;
        this.horas_de_vuelo = horas_de_vuelo;
        this.horas_de_vuelo_anual = horas_de_vuelo_anual;
    }

    public String getDni() {
        return dni;
    }

    public int getHoras_de_vuelo() {
        return horas_de_vuelo;
    }

    public int getHoras_de_vuelo_anual() {
        return horas_de_vuelo_anual;
    }
}

