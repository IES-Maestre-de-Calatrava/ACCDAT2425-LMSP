/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ad.accesoaoracleobjrel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class AccesoaoracleObjRel {
    
    static String driver;
    static Connection conexion;
    
    
    public static void main(String[] args) {
        abrirConexion();
        
        updatePrepared();
        
        cerrarConexion();
    }
    
    
    // Abrir conexion
    private static void abrirConexion() {
        try {
            driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost:1521/FREE";
            Properties propiedades = new Properties();

            propiedades.setProperty("user", "dam2jpa");
            propiedades.setProperty("password", "dam2jpa");

            Class.forName(driver);
            conexion = DriverManager.getConnection(urlconnection, propiedades);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesoaoracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Cerrar conexion
    private static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoaoracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void insertarPrepared() {
        try {
            String sql = "INSERT INTO ALUMNOS VALUES(NEW PERSONA(?,?, NEW DIRECCION(?,?,?), ?))";
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            java.sql.Date fecha = Date.valueOf("2023-12-21");
            
            sentencia.setInt(1, 67);
            sentencia.setString(2, "Ana Gomez");
            sentencia.setString(3, "Calatrava");
            sentencia.setString(4, "Ciudad Real");
            sentencia.setInt(5, 13003);
            sentencia.setDate(6, fecha);
            
            sentencia.executeUpdate();
            sentencia.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoaoracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void updatePrepared() {
        try {
            String sql = "update ALUMNOS set nombre=? where codigo=3";
            
            PreparedStatement sentencias = conexion.prepareStatement(sql);
            
            
            sentencias.setString(1, "Jose Luis");
            
            sentencias.executeUpdate();
            sentencias.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoaoracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void realizaConsulta() {
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rset = stmt.executeQuery("select codigo, nombre, direc from alumnos order by codigo");
            
            while (rset.next()) {
                String codigo = rset.getString(1);
                String nombre = rset.getString(2);
                
                Struct objeto = (Struct) rset.getObject(3);
                
                String ciudad = "";
                
                if (objeto != null) {
                    Object[] atrributos = objeto.getAttributes();
                    ciudad = (String) atrributos[1];
                }
                System.out.println("Código: " + codigo + " Nombre: " + nombre + " Direccion: " + ciudad);
            }
            rset.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoaoracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
