/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.ejercicio3ordinaria;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import org.xml.sax.SAXException;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Ejercicio3ordinaria {

    public static void main(String[] args) {
        utilidadSolicitaDatos();
    }
    private static void utilidadSolicitaDatos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce id:");       
        int id = scanner.nextInt();
        System.out.println("Introduce fecha de lanzamiento");
        String fecha = scanner.next();
        System.out.println("Introduce lugar de lanzamiento:");       
        String lugar = scanner.next();
        System.out.println("Introduce las horas de vuelo estimadas");
        int horas = scanner.nextInt();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = (Document) builder.parse(new File("."+File.separator+"RESOURCES"+File.separator+"publicacionLanzamientos.xml"));
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Ejercicio3ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Ejercicio3ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio3ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
}
