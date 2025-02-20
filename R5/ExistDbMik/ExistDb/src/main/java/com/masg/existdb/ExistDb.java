package com.masg.existdb;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
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
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.io.OutputStream;
import javax.xml.xpath.*;
import org.w3c.dom.Node;

/**
 *
 * @author MASG by Miguel Ángel Sánchez García
 */
public class ExistDb {

    //VARIABLES PARA LA CONEXION A LA BBDD
    private static XQDataSource server;
    private static XQConnection con;
    
    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private static Transformer transformer;
           

    public static void main(String[] args) {

        conecta();
        
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //consulta("/EMPLEADOS");
        //modificacion("update rename /EMPLEADOS/fila_emple as 'EMP_ROW'");
        
        /*modificacion("update insert \n" +
        " <empleado salario='2340'>\n" +
            " <puesto>Técnico</puesto>\n" +
            " <nombre>Pedro Fraile</nombre>\n" +
        " </empleado>\n" +
        "into /universidad/departamento[2]");*/

        
        /*modificacion("for $em in /universidad/departamento[codigo='MAT1']/empleado\n" +
        "let $sal := data($em/@salario)\n" +
        "return update value $em/@salario\n" +
        "with data($sal)+100");*/
        
        //verEmpleadosDeDepartamento("MAT2");
        
        InsertarDep(10, "INFORMATICA", "CIUDAD REAL");
        
        desconecta();

    }

    public static void consulta(String textoConsulta) {
        try {
            XQPreparedExpression consulta;
            XQResultSequence resultado;

            consulta = con.prepareExpression(textoConsulta);
            resultado = consulta.executeQuery();

            XQResultItem r_item;

            while (resultado.next()) {
                r_item = (XQResultItem) resultado.getItem();
                
                System.out.println(eliminarNamespace(r_item));
            }

        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void modificacion(String textoDML) {
        try {
            XQExpression expresion;

            expresion = con.createExpression();

            expresion.executeCommand(textoDML);
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void verEmpleadosDeDepartamento(String codDepartamento){
        try {
            XQPreparedExpression consulta;
            XQResultSequence resultado;

            consulta = con.prepareExpression("/universidad/departamento[codigo = '"+ codDepartamento+"']/empleado");
            resultado = consulta.executeQuery();

            XQResultItem r_item;

            while (resultado.next()) {
                r_item = (XQResultItem) resultado.getItem();
                
                System.out.println(eliminarNamespace(r_item));
            }
            
            
            
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void InsertarDep(int deptNo, String nombre, String loc){
       
        if(depIdExist(deptNo)){
           System.out.println("Ya existe ese departamento"); 
       } else {
           modificacion("update insert <DEP_ROW> <DEPT_NO> "+deptNo+" </DEPT_NO> <DNOMBRE> "+nombre+" </DNOMBRE> <LOC> "+loc+" </LOC> </DEP_ROW> into /departamentos");
       }
        
    }
    
    public static void borrarDep(int deptNo){
        
        if(depIdExist(deptNo)){
            modificacion("update delete /departamentos/DEP_ROW[DEPT_NO = "+deptNo+"]");
       } else {
           System.out.println("No existe");
       }
    }
    
    public static void modificarDep(int deptNo, String nombre, String loc){
        
        if(depIdExist(deptNo)){
            modificacion("update replace /departamentos/DEP_ROW[DEPT_NO = "+deptNo+"] with <DEP_ROW> <DEPT_NO> "+deptNo+" </DEPT_NO> <DNOMBRE> "+nombre+" </DNOMBRE> <LOC> "+loc+" </LOC> </DEP_ROW>");
       } else {
           System.out.println("No existe");
       }
        
    }
            //update value /EMPLEADOS/EMP_ROW[EMP_NO=7369]/APELLIDO 
                //with ‘Alberto Montes Ramos’
    
    
    
         //update value /sucursales/sucursal[@codigo=‘SUC3’]/cuenta[1]/@tipo 
            //with ‘NUEVOTIPO’
    
    
                //update rename /EMPLEADOS/EMP_ROW
                    //as  ‘fila_emple’
    
    
    
    public static boolean depIdExist(int idDep){
        
        
            boolean existe = false;
            
            XQPreparedExpression consulta;
            XQResultSequence resultado;
            
            String query = "/departamentos/DEP_ROW[DEPT_NO = "+idDep+"]";
            
            try {
                consulta = con.prepareExpression(query);
                resultado = consulta.executeQuery();
                
                if (resultado.next()){
                    existe = true;
                }
                
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    
    public static void crearUsuario(String usuario, String password){
        XQPreparedExpression consulta;
        XQResultSequence resultado;
        
        String query = "import module namespace sm = 'http://exist-db.org/xquery/security' sm:create-account(\\'"+usuario+"\\', '\\'"+password+"\\', (), ())";
        
        try {
            consulta = con.prepareExpression(query);
            consulta.executeQuery();
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public static String eliminarNamespace(XQResultItem item) {
      StringWriter writer = new StringWriter();
        try {
            Node node = (Node) item.getNode();

            transformer.transform(new DOMSource(node), new StreamResult(writer));

        } catch (Exception e) {
            e.printStackTrace();
        }
            return writer.toString();
    }

    private static void conecta() {
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

    private static void desconecta() {
        try {
            con.close();
        } catch (XQException ex) {
            Logger.getLogger(ExistDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
