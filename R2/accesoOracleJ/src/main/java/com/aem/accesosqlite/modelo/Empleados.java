/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.accesosqlite.modelo;

import com.aem.accesosqlite.AccesosOracle;
import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
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
    private Date fechaAlta;
    private double salario;
    private double comision;
    private int depNo;

    public Empleados(int empNo, String apellido, String oficio, int dir, Date fechaAlta, double salario, double comision, int depNo) {
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
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
            ResultSet rs =bbdd.select("SELECT emp_no FROM empleados WHERE emp_no = ? ", this.dir).get();
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            
            if(rs.next()){
                if(getSalario()<=0){
                    System.out.println("El salario debe ser mayor que 0");
                }
                else if(this.apellido == null || this.apellido.isEmpty()||this.oficio == null || this.oficio.isEmpty()){
                    System.out.println("El apellido o el oficio no pueden ser nulos o vacios");
                }
//                else if(this.fechaAlta !=  ){
//                    
//                }
                else{

                    bbdd.insert("insert into Empleados values (?,?,?,?,?,?,?,?)", getEmpNo(), getApellido(), getOficio(), getDir(), getFechaAlta(), getSalario(), getComision(), getDepNo());
                    System.out.println("El empleado se inserto correctamente");
                }
            }
            else{
                System.out.println("No existe el director");
            }
           
                
        } catch (SQLException ex) {
            switch(ex.getErrorCode()){
                case 1:{
                    System.out.println("Ese numero de empleado ya existe");
                    break;
                }
                case 2291:{
                    System.out.println("Ese numero de departamento no existe");
                    break;
                }
                default:{
                    System.out.println ("Ha ocurrido un error:");
                    System.out.println ("Mensaje: " +ex.getMessage());
                    System.out.println ("SQL Estado: " +ex.getSQLState());
                    System.out.println ("Código de error: " +ex.getErrorCode());
                }
            }
//            System.out.println ("Ha ocurrido un error:");
//            System.out.println ("Mensaje: " +ex.getMessage());
//            System.out.println ("SQL Estado: " +ex.getSQLState());
//            System.out.println ("Código de error: " +ex.getErrorCode());
            //Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectByIdEmple(OperacionesBBDD bbdd, int n){
        try {
            Optional<ResultSet> rs=bbdd.select("SELECT * FROM empleados WHERE emp_no = ?",n);
            if(rs.isPresent()){
                while(rs.get().next()){

                    this.empNo = (rs.get().getInt("emp_no"));
                    this.apellido = (rs.get().getString("apellido"));
                    this.oficio = (rs.get().getString("oficio"));
                    this.dir = (rs.get().getInt("dir"));
                    this.fechaAlta = (rs.get().getDate("fecha_alt"));
                    this.salario = (rs.get().getDouble("salario"));
                    this.comision = (rs.get().getDouble("comision"));
                    this.depNo = (rs.get().getInt("dept_no"));

                }
            }
        } catch (SQLException ex) {
                    Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Optional<ResultSet> selectAll(OperacionesBBDD bbdd){
        Optional<ResultSet> rs = null;
        try {
            rs = bbdd.select("SELECT * FROM empleados");
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void mostrarResultSet(Optional<ResultSet> rs){
        try {
            if(rs.isPresent()){
                while (rs.get().next()){
                    System.out.println("Número empelado:" + rs.get().getInt("emp_no")+
                            " Apellido:"+rs.get().getString("apellido")+
                            " Oficio:"+rs.get().getString("oficio")+
                            " Dir:"+rs.get().getInt("dir")+
                            " Fecha Alta:"+rs.get().getDate("fecha_alt")+
                            " Salario:"+rs.get().getDouble("salario")+
                            " Comision:"+rs.get().getDouble("comision")+
                            " Numero departamento:"+rs.get().getInt("dept_no"));
                }
            }
        } catch (SQLException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(OperacionesBBDD bbdd){
        try {
            bbdd.update("UPDATE empleados SET apellido=?, oficio=?, dir=?, fecha_alt=?, salario=?, comision=?, dept_no=?  WHERE emp_no = ?",
                    this.apellido,
                    this.oficio,
                    this.dir,
                    this.fechaAlta,
                    this.salario,
                    this.comision,
                    this.depNo,
                    this.empNo);
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delete(OperacionesBBDD bbdd, int n_emp){
        try {
            bbdd.delete("DELETE FROM empelados  WHERE emp_no = ?", n_emp);
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
