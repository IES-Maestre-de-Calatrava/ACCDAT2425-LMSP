/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.break4learning.bbddjdbcsqlite.modelo;

import com.break4learning.bbddjdbcsqlite.bbdd.OperacionesBBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author break4learning
 */
public class Departamento {
    private int dept_no;
    private String dnombre;
    private String loc;

    public Departamento() {
    }

    public Departamento(int dept_no, String dnombre, String loc) {
        this.dept_no = dept_no;
        this.dnombre = dnombre;
        this.loc = loc;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Departamento{" + "dept_no=" + dept_no + ", dnombre=" + dnombre + ", loc=" + loc + '}';
    }
    
    /**************************************************************************
     * EJECUCIÓN DE SENTENCIAS DE MANIPULACIÓN DE DATOS
     **************************************************************************/
    
    /**
     * Inserción de un departamento
     * 
     * @param bbdd Clase para las operaciones con la bbdd
     */
    public void insertar(OperacionesBBDD bbdd){
        try {
            bbdd.insert("insert into Departamentos values (?,?,?)", this.dept_no, this.dnombre, this.loc);
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Selecciona todos los registros de la tabla
     * 
     * @param bbdd Clase para las operaciones con la bbdd
     * @return Registros devueltos
     */
    public static Optional<ResultSet> selectAll(OperacionesBBDD bbdd){
        Optional<ResultSet> rs = null;
        try {
            rs = bbdd.select("SELECT * FROM departamentos");   // Optional permite que la variable tenga valor o nulo
            
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    /**
     * Muestra los datos del ResultSet
     * 
     * @param rs ResultSet del cual queremos mostrar los datos
     */
    public static void mostrarResultSet(Optional<ResultSet> rs){
        try {
            if (rs.isPresent()) {
                while (rs.get().next()) {
                    System.out.println("Número departamento:"+ rs.get().getInt("dept_no") + " Nombre:" + rs.get().getString("dnombre") + " Localidad:" + rs.get().getString("loc"));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Selecciona un registro filtrando por la clave primaria
     * 
     * @param bbdd Clase para las operaciones con la bbdd
     * @param dept_no Número del departamento del cual queremos seleccionar la información 
     */
    public void selectById(OperacionesBBDD bbdd, int n){
        try {
            Optional<ResultSet> rs = bbdd.select("SELECT * FROM departamentos WHERE dept_no = ?",n);
            
            if (rs.isPresent()) {
                while (rs.get().next()) {
                    this.setDept_no(rs.get().getInt("dept_no"));
                    this.setDnombre(rs.get().getString("dnombre")); 
                    this.setLoc(rs.get().getString("loc"));
                }
            }         
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    /**
     * Modifica un departamento
     * 
     * @param bbdd Clase para las operaciones con la bbdd
     */
    public void update(OperacionesBBDD bbdd){
        try {
            bbdd.update("update Departamentos set dnombre = ?, loc = ? where dept_no =?", this.dnombre, this.loc, this.dept_no );
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Elimina un departamento
     * 
     * @param bbdd Clase para las operaciones con la bbdd
     * @param dept_no Número del departamento que queremos eliminar
     */
    public static void delete(OperacionesBBDD bbdd, int n){
        try {
            bbdd.delete("delete from Departamentos where dept_no =(?)", n);
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
