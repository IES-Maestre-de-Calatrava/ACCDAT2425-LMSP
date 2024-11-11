/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.accesosqlite.modelo;

import com.aem.accesosqlite.AccesosOracle;
import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;
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
    public Departamentos(){
        
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

    @Override
    public String toString() {
        return "Departamentos{" + "numDep=" + numDep + ", nombreDep=" + nombreDep + ", poblacionDep=" + poblacionDep + '}';
    }
    
    
    public void insert(){
        try {
            OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
            bbdd.insert("insert into Departamentos values (?,?,?)", getNumDep(), getNombreDep(), getPoblacionDep());
        } catch (SQLException ex) {
            Logger.getLogger(AccesosOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectById(OperacionesBBDD bbdd, int n){
        try {
            Optional<ResultSet> rs=bbdd.select("SELECT * FROM departamentos WHERE dept_no = ?",n);
            if(rs.isPresent()){
                while(rs.get().next()){

                    this.numDep = (rs.get().getInt("dept_no"));
                    this.nombreDep = (rs.get().getString("dnombre"));
                    this.poblacionDep = (rs.get().getString("loc"));

                }
            }
        } catch (SQLException ex) {
                    Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Optional<ResultSet> selectAll(OperacionesBBDD bbdd){
        Optional<ResultSet> rs = null;
        try {
            rs = bbdd.select("SELECT * FROM departamentos");
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void mostrarResultSet(Optional<ResultSet> rs){
        try {
            if(rs.isPresent()){
                while (rs.get().next()){
                    System.out.println("Número departamento:" + rs.get().getInt("dept_no")+
                            " Nombre:"+rs.get().getString("dnombre")+
                            " Localidad:"+rs.get().getString("loc"));
                }
            }
        } catch (SQLException ex) {
                Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(OperacionesBBDD bbdd){
        try {
            bbdd.update("UPDATE departamentos SET dnombre = ?, loc=? WHERE dept_no = ?",
                    this.nombreDep,
                    this.poblacionDep,
                    this.numDep);
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delete(OperacionesBBDD bbdd, int n_dept){
        try {
            bbdd.delete("DELETE FROM departamentos  WHERE dept_no = ?", n_dept);
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String pNombreDepart(OperacionesBBDD bbdd, int dept_no) {
        CallableStatement llamada;
        String dnombre = null;
        try {     
            //Vamos a llamar a un procedimiento con la siguiente cabecera
            //PROCEDURE P_NOMBRE_DEPART(NDEPART NUMBER, NOMBRE_DEPART OUT VARCHAR2)
            //Preparamos el string para la llamada:
            String sql = "{call p_nombre_depart (?,?)}"; 
            
            //Creamos un objeto llamando al método prepareCall:
            llamada=bbdd.getConexion().prepareCall(sql);
            
            //Indicamos cuáles son los parámetros de entrada y cuales los de salida
            //Le damos valor al parámetro de entrada:
            llamada.setInt(1, dept_no);
            //Registramos el parámetro de salida de la función:
            llamada.registerOutParameter(2, Types.VARCHAR);
            
            //Realizamos la llamada al procedimiento:
            llamada.executeUpdate();
            
            //Obtenemos el valor del primer parámetro de salida
            dnombre = llamada.getString(2);
                     
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  dnombre;
    }
    public static String fNombreDepart(OperacionesBBDD bbdd, int dept_no) {
        CallableStatement llamada;
        String dnombre = null;
        try {     
            String sql = "{?=call f_nombre_depart (?)}";
            llamada=bbdd.getConexion().prepareCall(sql);
            llamada.setInt(2, dept_no);
            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.executeUpdate();
            dnombre = llamada.getString(1);
                     
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  dnombre;
    }
}
