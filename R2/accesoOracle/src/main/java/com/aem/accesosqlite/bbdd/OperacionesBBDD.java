/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.aem.accesosqlite.bbdd;

import com.aem.accesosqlite.modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 4 nov 2024
 */
public class OperacionesBBDD {
    private final String driver;                // Driver
    private final String urlconnection;   // Cadena de conexión
    
    private static OperacionesBBDD operacionesBBDD = null;

    private Connection conexion = null;
    private Properties propiedades = null;
    private PreparedStatement preparedStatement;
    
    /**
     * Establece la conexión a la BBDD Oracle
     */
    public void conectarOracle(){
        try {
            this.propiedades = new Properties();
            this.propiedades.setProperty("user", "dam2");
            this.propiedades.setProperty("password", "dam2");
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(urlconnection, propiedades);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConexion() {
        return conexion;
    }
    
     /**
     * Cierra la conexión a la BBDD Oracle
     */
    public void cierraConexion(){
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private OperacionesBBDD(){
        driver = "oracle.jdbc.driver.OracleDriver";
        urlconnection= "jdbc:oracle:thin:@localhost:1521";
    }
    public static OperacionesBBDD getInstance(){
        if (operacionesBBDD == null){
            operacionesBBDD = new OperacionesBBDD();
        }
        return operacionesBBDD;
    }
    
    public Optional<ResultSet> insert(String insertSQL, Object... params) throws SQLException{
        preparedStatement = conexion.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
        //"insert into Departamentos values (?,?,?)", 1, "informatica", "Ciudad Real"
        for (int i = 0;i<params.length; i++){
            preparedStatement.setObject(i+1, params[i]);
        }
        preparedStatement.executeUpdate();
        return Optional.of(preparedStatement.getGeneratedKeys());
    }
    private ResultSet executeQuery(String querySQL, Object... params) throws SQLException{
        preparedStatement = conexion.prepareStatement(querySQL);
        
        for (int i = 0;i<params.length; i++){
            preparedStatement.setObject(i+1, params[i]);
        }
        return preparedStatement.executeQuery();
    }
    public Optional<ResultSet> select(String querySQL, Object... params) throws SQLException{
        return Optional.of(executeQuery(querySQL, params));
    }
    private int updateQuery(String genericSQL, Object... params) throws SQLException{
        preparedStatement = conexion.prepareStatement(genericSQL);
        for (int i = 0;i<params.length; i++){
            preparedStatement.setObject(i+1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }
    public int update(String genericSQL, Object... params) throws SQLException{
        return updateQuery(genericSQL, params);
    }
    public int delete(String genericSQL, Object... params) throws SQLException{
        return updateQuery(genericSQL, params);
    }
}
