/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.accesosqlite.modelo;

import com.aem.accesosqlite.Accesosqlite;
import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 4 nov 2024
 */
public class Departamentos {
    private int numDep;
    private String nombreDep;
    private String poblacionDep;
    
    public Departamentos(int numDep, String nombreDep, String poblacionDep){
        this.numDep = numDep;
        this.nombreDep = nombreDep;
        this.poblacionDep = poblacionDep;
    }
    public int getNumDep() {
        return numDep;
    }

    public void setNumDep(int numDep) {
        this.numDep = numDep;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getPoblacionDep() {
        return poblacionDep;
    }

    public void setPoblacionDep(String poblacionDep) {
        this.poblacionDep = poblacionDep;
    }
    public void insert(){
        try {
            OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
            bbdd.insert("insert into Departamentos values (?,?,?)", getNumDep(), getNombreDep(), getPoblacionDep());
        } catch (SQLException ex) {
            Logger.getLogger(Accesosqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
