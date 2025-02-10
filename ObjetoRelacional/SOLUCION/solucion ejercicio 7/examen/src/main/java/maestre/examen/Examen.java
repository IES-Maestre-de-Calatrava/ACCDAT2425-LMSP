/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.examen;

import java.sql.Connection;
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
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Examen {

    static String driver;
    static Connection conexion;
    
    
    public static void main(String[] args) {
        abrirConexion();
        
        insertaVuelosEjemplo();
        
        
        Piloto piloto1 = new Piloto("12345677A",543,220);
        modificarPiloto(1645,piloto1);
        
        visualizarVuelo(1645);
        
        
        cerrarConexion();
    }
    
    
    // Abrir conexion
    private static void abrirConexion() {
        try {
            driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost:1521/FREE";
            Properties propiedades = new Properties();

            propiedades.setProperty("user", "dam2");
            propiedades.setProperty("password", "dam2");

            Class.forName(driver);
            conexion = DriverManager.getConnection(urlconnection, propiedades);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Cerrar conexion
    private static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void insertaVuelosEjemplo() {
        try {
            String sql = "INSERT INTO T_VUELOS_MERCANCIAS VALUES(?,?,NEW PILOTO(?,?,?),?,?)";
            
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
           
            sentencia.setInt(1,1645);
            sentencia.setString(2,"Iberia");
            sentencia.setString(3, "12345678W");
            sentencia.setInt(4, 200);
            sentencia.setInt(5, 120);
            sentencia.setInt(6, 1450);
            sentencia.setInt(7, 12);
            
            sentencia.executeUpdate();
            sentencia.close();
            
            String sql2 = "INSERT INTO T_VUELOS_MERCANCIAS VALUES(?,?,NULL,?,?)";
            PreparedStatement sentencia2 = conexion.prepareStatement(sql2);
            
           
            sentencia2.setInt(1,123);
            sentencia2.setString(2,"Ryanair");
            sentencia2.setInt(3, 1100);
            sentencia2.setInt(4, 10);
            
            sentencia2.executeUpdate();
            sentencia2.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void modificarPiloto(int idVuelo,Piloto piloto ){
        try {
            String sql = "UPDATE T_VUELOS_MERCANCIAS T SET T.PILOTO_AVION = NEW PILOTO(?,?,?) WHERE T.IDVUELO = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
         
            sentencia.setString(1, piloto.getDni());
            sentencia.setInt(2, piloto.getHoras_de_vuelo());
            sentencia.setInt(3, piloto.getHoras_de_vuelo_anual());
            sentencia.setInt(4, idVuelo);
            
           
            sentencia.executeUpdate();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void visualizarVuelo(int idVuelo){
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rset = stmt.executeQuery("select c.idvuelo, c.piloto_avion, c.coste_transporte() from t_vuelos_mercancias c where c.idvuelo="+idVuelo+"");
            
            if(rset.next()) {
                do{
                    int id_vuelo = rset.getInt(1);

                    Struct objeto = (Struct) rset.getObject(2);
                    String dni = "";

                    int resultado = rset.getInt(3);

                    if (objeto != null) {
                        Object[] atributos = objeto.getAttributes();
                        dni = (String) atributos[0];
                    }
                    System.out.println("ID_VUELO: " + id_vuelo + " DNI del piloto: " + dni + " Solucion de funcion: " + resultado);
                }while (rset.next());
            }else{
                System.out.println("No existe ese vuelo en la base de datos");
            }
            rset.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
