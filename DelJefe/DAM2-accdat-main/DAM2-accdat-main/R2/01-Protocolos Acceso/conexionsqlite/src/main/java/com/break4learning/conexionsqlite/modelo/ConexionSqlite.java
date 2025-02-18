/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.conexionsqlite.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para establecer la conexión a una BBDD Sqlite
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 30 oct 2024
 */
public class ConexionSqlite {
    
    private final String driver = "org.sqlite.JDBC";                    // Driver
    private final String urlconnection = "jdbc:sqlite:./ejemplo.db";    // Cadena de conexión
    
    private Connection conexion = null;
    
    /**
     * Establece la conexión a la BBDD Sqlite
     */
    public void conexion(){
        try {          
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(urlconnection);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Cierra la conexión a la BBDD Sqlite
     */
    public void cierreConexion(){
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
