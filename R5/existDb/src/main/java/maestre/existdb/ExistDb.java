/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.existdb;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;
import org.w3c.dom.Node;
/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class ExistDb {
    //variables de conexion
    private static XQDataSource server;
    private static XQConnection con;
    //Transformer
    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private static Transformer transformer;
    
    
    public static void main(String[] args) {
        conecta();
        
        //PARA PODER QUITAR NAMESPACE
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //consulta("/EMPLEADOS");
        //consultaSinNamespace("/EMPLEADOS");
        
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
    //para quitar namespace
    private static String eliminarNamespace(XQResultItem item){
        StringWriter writer = new StringWriter();
        Node node;
        try {
            node = (Node)item.getNode();
            transformer.transform(new DOMSource(node), new StreamResult(writer));
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return writer.toString();
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
    private static void consultaSinNamespace(String textoConsulta){
        try {
            XQPreparedExpression consulta;
            XQResultSequence resultado;
            consulta = con.prepareExpression(textoConsulta);
            resultado = consulta.executeQuery();
            
            XQResultItem rItem;
            while(resultado.next()){
                rItem = (XQResultItem) resultado.getItem();
                System.out.println(eliminarNamespace(rItem));
            }
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean existeNodo (String inputConsulta) {
        boolean nodoExiste = false;
    
        try {
            XQExpression xqConsulta = con.createExpression();
            String cadenaConsulta = "exists(" + inputConsulta + ")";
            XQResultSequence xqResultado = xqConsulta.executeQuery(cadenaConsulta);
      
            if (xqResultado.next() && xqResultado.getBoolean()) {
                nodoExiste = true;
            } 
      
        } catch (XQException ex) {
            ex.printStackTrace();
        }
    
        return nodoExiste;
  }
    
}
