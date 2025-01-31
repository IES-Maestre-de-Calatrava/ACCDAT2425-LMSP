/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.accesooracleobjrel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class AccesoOracleObjRel {
    static String driver;
    static Connection conexion;
    public static void main(String[] args) {
        abrirConexion();
    }
    public static void abrirConexion(){
        try{
            driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost:1521/FREE";
            Properties propiedades = new Properties();
            propiedades.setProperty("user","dam2");
            propiedades.setProperty("password","dam2");
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(urlconnection,propiedades);
        }catch(SQLException|ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public static void cerrarConexion(){
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    private static void insertarPrepared(){
        try {
            String sql = "INSERT INTO alumnos VALUES("
                    + "new Persona("
                    + "?,"
                    + "?,"
                    + "new Direccion(?,?,?),"
                    + "?"
                    + "))";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoOracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private static void realizaConsulta(){
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT CODIGO,NOMBRE,DIREC FROM ALUMNOS");
            while(rset.next()){
                String codigo = rset.getString(1);
                String nombre = rset.getString(2);
                java.sql.Struct objeto = (java.sql.Struct)rset.getObject(3);
                String ciudad = "";
                if(objeto != null){
                    Object[] atributos = objeto.getAttributes();
                    ciudad = (String)atributos[1];
                }
                System.out.println("Código");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoOracleObjRel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
