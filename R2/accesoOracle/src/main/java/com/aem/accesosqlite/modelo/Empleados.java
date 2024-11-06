/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.accesosqlite.modelo;

import com.aem.accesosqlite.AccesosOracle;
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
public class Empleados {
    private int empNo;
    private String apellido;
    private String oficio;
    private int dir;
    private String fechaAlta;
    private double salario;
    private double comision;
    private int depNo;

    public Empleados(int empNo, String apellido, String oficio, int dir, String fechaAlta, double salario, double comision, int depNo) {
        this.empNo = empNo;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.comision = comision;
        this.depNo = depNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getDepNo() {
        return depNo;
    }

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }
    
    public void insert(){
        try {
            OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
            bbdd.insert("insert into Empleados values (?,?,?,?,?,?,?,?)", getEmpNo(), getApellido(), getOficio(), getDir(), getFechaAlta(), getSalario(), getComision(), getDepNo());
        } catch (SQLException ex) {
            Logger.getLogger(AccesosOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
