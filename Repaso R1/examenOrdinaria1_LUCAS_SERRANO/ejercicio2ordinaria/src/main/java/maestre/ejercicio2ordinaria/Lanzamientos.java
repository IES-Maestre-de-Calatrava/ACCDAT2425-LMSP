/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package maestre.ejercicio2ordinaria;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 19 feb 2025
 */
public class Lanzamientos {

    private int id;
    private String fecha_lanzamiento;
    private String lugar_lanzamiento;
    private int horas_vuelo_estimadas;
    public Lanzamientos(int id, String fecha, String lugar, int horas){
        this.id = id;
        this.fecha_lanzamiento = fecha;
        this.lugar_lanzamiento = lugar;
        this.horas_vuelo_estimadas = horas;
    }
    public Lanzamientos(){//CONSTRUCTOR VACIO PARA PODER ACCEDER A LONGITUDES
        
    }

    public int getId() {
        return id;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public String getLugar_lanzamiento() {
        return lugar_lanzamiento;
    }

    public int getHoras_vuelo_estimadas() {
        return horas_vuelo_estimadas;
    }
    
    private final int LONGITUD_INT = 4;
    private final int LONGITUD_CHAR = 2;
    
    public final int CARACTERES_LUGAR = 40;
    public final int CARACTERES_FECHA = 10;
    
    
    
    public final int LONGITUD_ID = LONGITUD_INT;
    public final int LONGITUD_FECHA = CARACTERES_FECHA * LONGITUD_CHAR;
    public final int LONGITUD_LUGAR = CARACTERES_LUGAR * LONGITUD_CHAR;
    public final int LONGITUD_HORAS = LONGITUD_INT;

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }
    
    public final int LONGITUD_TOTAL = LONGITUD_ID + LONGITUD_FECHA + LONGITUD_LUGAR + LONGITUD_HORAS;
    
}
