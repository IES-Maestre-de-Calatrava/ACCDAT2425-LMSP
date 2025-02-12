/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.existdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;
/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class ExistDb {
    //variables de conexion
    private static XQDataSource server;
    private static XQConnection con;
    
    
    
    public static void main(String[] args) {
        conecta();
        consulta("/EMPLEADOS");
        desconecta();
    }
    private static void conecta(){
        try {
            server = new ExistXQDataSource();
            
            server.setProperty("serverName", "localhost");
            server.setProperty("port", "8080");
            server.setProperty("user", "dam2");
            server.setProperty("password", "dam2");
            con = server.getConnection();
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void desconecta(){
        try {
            con.close();
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void consulta(String textoConsulta){
        try {
            XQPreparedExpression consulta;
            XQResultSequence resultado;
            consulta = con.prepareExpression(textoConsulta);
            resultado = consulta.executeQuery();
            
            XQResultItem rItem;
            while(resultado.next()){
                rItem = (XQResultItem) resultado.getItem();
                System.out.println(rItem.getItemAsString(null));
            }
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void modificacion(String textoDML){
        try {
            XQExpression expresion;
            expresion = con.createExpression();
            expresion.executeCommand(textoDML);
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
