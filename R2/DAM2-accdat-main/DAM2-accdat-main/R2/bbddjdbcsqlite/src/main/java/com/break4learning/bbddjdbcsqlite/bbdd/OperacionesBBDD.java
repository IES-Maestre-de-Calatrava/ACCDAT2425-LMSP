/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.bbddjdbcsqlite.bbdd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para realizar las operaciones con la base de datos
 *
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 30 oct 2024
 */
public class OperacionesBBDD {

    private final String driver;
    private final String urlconnection;
    
    private static OperacionesBBDD operacionesBBDD = null;
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    
    private static DatabaseMetaData dbmd;

    private OperacionesBBDD(){
        driver = "org.sqlite.JDBC";
        urlconnection="jdbc:sqlite:./bbdd/ejemplo.db";
    }
    
    /**
     * Devuelve una instancia de la clase. Sólo una. Patrón Singleton
     * 
     * @return La instancia de la clase
     */
    public static OperacionesBBDD getInstance(){
        if (operacionesBBDD == null){
            operacionesBBDD = new OperacionesBBDD();
        }
        return operacionesBBDD;
    }
    
    /**
     * Realiza la conexión a la BBDD
     */
    public void abrirConexion(){
        try {
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(urlconnection);
            // Para obtener información de la conexión
            dbmd = conexion.getMetaData();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Cierra la conexión a la bbdd
     */
    public void cerrarConexion(){
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************************************
     * EJECUCIÓN DE SENTENCIAS DE MANIPULACIÓN DE DATOS
     **************************************************************************/
    
    /**
     * Ejecuta un Insert con los parámetros indicados
     * 
     * @param insertSQL Insert a ejecutar
     * @param params    Parámetros de la instrucción Insert. No son obligatorios
     * @return  Devolverá la Key en caso de que el campo de la clave primaria sea autoincremental
     * @throws SQLException Valor ducplicado o no se ha podido realizar la operación
     */
    public Optional<ResultSet> insert(String insertSQL, Object... params) throws SQLException{
        
        preparedStatement = conexion.prepareStatement(insertSQL,PreparedStatement.RETURN_GENERATED_KEYS);
                     
        for (int i = 0; i<params.length; i++){
            preparedStatement.setObject(i+1, params[i]);
        }
             
        preparedStatement.executeUpdate();
        
        return Optional.of(preparedStatement.getGeneratedKeys());
    }
    
    /**
     * Realiza una operación de tipo update, es decir que modifca los datos o los elimina
     *
     * @param genericSQL consulta SQL de tipo update, delete, etc. que modifica los datos
     * @param params     parámetros de la consulta parametrizada
     * @return número de registros afectados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    private int updateQuery(String genericSQL, Object... params) throws SQLException {
        // Con return generated keys obtenemos las claves generadas
        preparedStatement = conexion.prepareStatement(genericSQL);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }
    
    /**
     * Realiza un update
     *
     * @param updateSQL Operación SQL de tipo update
     * @param params    Parámetros de la instrucción
     * @return Número de registros actualizados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    public int update(String updateSQL, Object... params) throws SQLException {
        return updateQuery(updateSQL, params);
    }
    
    /**
     * Realiza un delete
     *
     * @param deleteSQL Operación SQL de tipo delete
     * @param params    Parámetros de la instrucción
     * @return Número de registros eliminados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    public int delete(String deleteSQL, Object... params) throws SQLException {
        return updateQuery(deleteSQL, params);
    }
    
     /**
     * Realiza una consulta a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL Consulta SQL de tipo select
     * @param params   Parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    private ResultSet executeQuery(String querySQL, Object... params) throws SQLException {
        preparedStatement = conexion.prepareStatement(querySQL);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        
        return preparedStatement.executeQuery(); 
    }
    
    /**
     * Realiza una consulta select a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL Consulta SQL de tipo select
     * @param params   Parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    public Optional<ResultSet> select(String querySQL, Object... params) throws SQLException {
        return Optional.of(executeQuery(querySQL, params));
    }
    
    /**************************************************************************
     * SENTENCIAS DE DESCRIPCIÓN
     **************************************************************************/
    
    /**
     * Muestra información sobre la conexión a la bbdd
     */
    public void obtenerInformacionDeConexion() {
                
        try {
            //Nombre del SGBD
            String nombre = dbmd.getDatabaseProductName();
            
            //Driver utilizado:
            String driver = dbmd.getDriverName();
            
            //Dirección para acceder a la bbdd:
            String url = dbmd.getURL();
            
            //Nombre del usuario:
            String usuario = dbmd.getUserName();
            
            System.out.println("Nombre del SGBD:" + nombre);
            System.out.println("Driver:" + driver);
            System.out.println("Url:" + url);
            System.out.println("Usuario:" + usuario);
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Muestra información de las tablas del usuario conectado a la bbdd
     */
    public void obtenerInformacionDeLasTablas() {
        try {
            ResultSet rs;
            String[] tipos = {"TABLE"};
            
            rs = dbmd.getTables(null, 
                                null,
                                null, 
                                tipos);
            
            String nombre_usuario;
            String nombre_tabla;
            
            while (rs.next()){
                nombre_usuario = rs.getString("TABLE_SCHEM");
                nombre_tabla = rs.getString("TABLE_NAME");
                
                System.out.println("USUARIO:" +nombre_usuario+ " TABLA:" + nombre_tabla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Muestra información sobre las columnas de una tabla
     * 
     * @param nombreTabla Nombre de la tabla de la cual queremos obtener información de sus columnas
     */
    public void obtenerInformacionDeLasColumnas(String nombreTabla) {
        try {
            ResultSet rs;
            
            rs = dbmd.getColumns(null, 
                                 null, 
                                 nombreTabla.toUpperCase(), 
                                 null);
            
            String nombre_tabla;
            String nombre_columna;
            
            while (rs.next()){
                nombre_tabla = rs.getString("TABLE_NAME");
                nombre_columna = rs.getString("COLUMN_NAME");
                
                System.out.println("TABLA:" +nombre_tabla+ " COLUMN:" + nombre_columna);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtiene información sobre el ResultSet
     * 
     * @param rs ResultSet sobre el cual queremos obtener información
     */
    public void obtenerInformacionDelResultSet(Optional<ResultSet> rs) {
        
        try {
            
            ResultSetMetaData rsmd = rs.get().getMetaData();
            
            //Obtiene el número de columnas devueltas por la tabla
            int numColumnas = rsmd.getColumnCount();
            
            //Obtiene el nombre de la columna de la posición "i"
            String nombre_columna = rsmd.getColumnName(2);
            
            //Obtiene el tipo de datos de la columna de la posición "i"
            String tipo_columna = rsmd.getColumnTypeName(2);
            
            //Obtiene "0" si la columna de la posición "i" puede contener valores nulos
            int valores_nulos = rsmd.isNullable(2);
            
            //Obtiene el máximo número de caracteres de la columna de la posición "i"
            int tamaño_columna = rsmd.getColumnDisplaySize(2);
            
            System.out.println("Numero de columnas devueltas:" + numColumnas);
            System.out.println("Nombre de la columna 2:" + nombre_columna);
            System.out.println("Tipo de la columna 2:" + tipo_columna);
            System.out.println("Tamaño de la columna 2:" + tamaño_columna);
            System.out.println("Acepta nulos:" + ((valores_nulos==1)?"Si":"No"));
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
