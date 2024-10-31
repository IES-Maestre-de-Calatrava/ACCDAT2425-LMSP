/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.lmsp.maestre.examenr1_lucas_serrano.modelo;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 23 oct 2024
 */
public class Universidad {
    private long id;
    private String carrera;
    private String ciudad;
    private double notaCorte;
    
    
    
    public Universidad(long id, String carrera, String ciudad, double notaCorte){
       this.id = id;
       this.carrera = carrera;
       this.ciudad = ciudad;
       this.notaCorte = notaCorte;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(double notaCorte) {
        this.notaCorte = notaCorte;
    }

    
    
    @Override
    public String toString(){
        return ("Id: "+this.getId()+", Carrera: "+this.getCarrera()+", Ciudad: "+this.getCiudad()+", Nota de corte: "+this.getNotaCorte());
    }

}
