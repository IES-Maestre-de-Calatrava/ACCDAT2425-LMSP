/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.break4learning.filedomxml.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * Clase para trabajar con documentos XML de empleados utilizando DOM
 * 
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 16 oct 2024
 */
public class GestionContenidoDOM {
    
    Document documento;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    
    /**
     * Crea el Document para trabajar con el XML
     * 
     * @param nombre Nombre del nodo principal
     */
    public GestionContenidoDOM (String nombre){
        try {
            
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            
            DOMImplementation implementation = builder.getDOMImplementation();
            this.documento = (Document) implementation.createDocument(null, nombre, null);
            this.documento.setXmlVersion("1.0");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestionContenidoDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Añade un nodo al elemento raíz del documento
     * 
     * @param nombreNodo    Nombre del nodo 
     * @return              Nodo que acabamos de añadir
     */
    public Element addNodo(String nombreNodo){
        Element nodoPrincipal = this.documento.createElement(nombreNodo);
        this.documento.getDocumentElement().appendChild(nodoPrincipal);
        return nodoPrincipal;
    }
    
    /**
     * Añade un nodo Element sin valor
     * 
     * @param nombreNodo     Nombre del nodo
     * @param elementoPadre Elemento padre al cual se va a añadir el nodo 
     * @return 
     */
    public Element addNodo (String nombreNodo, Element elementoPadre){
        Element dato = this.documento.createElement(nombreNodo);
        elementoPadre.appendChild(dato);
        return dato;
    }
    
    /**
     * Añade un nodo que contenga un valor a un elemento del árbol
     * 
     * @param nombreNodo    Nombre del nodo
     * @param texto         Valor del nodo
     * @param elementoPadre Elemento padre al cual se va a añadir el nodo con valor
     */
    public void addNodoYTexto (String nombreNodo, String texto, Element elementoPadre){
        Element dato = this.documento.createElement(nombreNodo);
        Text textoDato = this.documento.createTextNode(texto);
        dato.appendChild(textoDato);
        elementoPadre.appendChild(dato);
    }
    
    /**
     * Elimina las líneas vacías de los XML formateados
     * 
     * @param node Nodo a partir del cual eliminar las líneas vacías
     */
    private void eliminarNodosVacios(Node node) {
    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node childNode = nodeList.item(i);
        if (childNode.getNodeType() == Node.TEXT_NODE && childNode.getNodeValue().trim().isEmpty()) {
            node.removeChild(childNode);
            i--; // Ajustar el índice después de eliminar un nodo
        } else if (childNode.hasChildNodes()) {
            eliminarNodosVacios(childNode);
        }
    }
}
    
    /**
     * Crea un Transformer para pasar un XML a salida (fichero o pantalla)
     * 
     * @param preProcess Indicamos si queremos la identación (que esté formateado en lugar de que aparezca todo en una línea. 
     *                   Valores "yes" o "no".
     * @return  Devuelve el Transformer preparado para utilizarlo
     */
    private Transformer preProcess(String indent){
        Transformer transformer = null;
        
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GestionContenidoDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //transformer.setOutputProperty(OutputKeys.INDENT,String.valueOf (indent).toLowerCase());
        transformer.setOutputProperty(OutputKeys.INDENT,indent);
        return transformer;
    }
    
    /**
     * Pasa el XML cargado en memoria a un archivo
     * 
     * @param nombreArchivo Nombre del archivo que se va a generar
     * @param indent    Indicamos si queremos la identación (que esté formateado en lugar de que aparezca todo en una línea. 
     *                   Valores "yes" o "no".
     */
    public void generarArchivodelDOM(String nombreArchivo, String indent){
        try {
            Source source = new DOMSource(this.documento);
            Result salida = new StreamResult(new File(nombreArchivo));
            
            preProcess(indent).transform(source, salida);
            
        } catch (TransformerException ex) {
            Logger.getLogger(GestionContenidoDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Muestra por pantalla el XML cargado en memoria
     * 
     * @param indent     Indicamos si queremos la identación (que esté formateado en lugar de que aparezca todo en una línea. 
     *                   Valores "yes" o "no".
     */
    public void mostrarPantalla(String indent){
        try {
            Source source = new DOMSource(this.documento);
            Result salida = new StreamResult(System.out);
                       
            preProcess(indent).transform(source, salida);
            
        } catch (TransformerException ex) {
            Logger.getLogger(GestionContenidoDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Carga un archivo XML en un objeto Document
     * 
     * @param nombreArchivo Archivo que contiene el XML
     */  
    public void cargarArchivoEnMemoria(String nombreArchivo){
        try {
            
            this.documento = this.builder.parse(new File(nombreArchivo));
            this.documento.getDocumentElement().normalize();
            
        } catch (SAXException | IOException ex) {
            Logger.getLogger(GestionContenidoDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Obtiene el elemento raíz del documento
     * @return 
     */
    public String getElementPrincipal(){
        return this.documento.getDocumentElement().getNodeName();
    }
    
    /**
     * Obtiene el valor de un nodo dentro de un determinado elemento. Este nodo no puede repetirse dentro del elemento
     * 
     * @param tag       Nodo del cual obtener el texto
     * @param element   Elemento padre que contiene al nodo del cual obtener el valor
     * @return          Valor obtenido
     */
    private String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        
        if (node != null){
            return node.getNodeValue();
        } else {
            return null;
        }  
    }
    
    /**
     * Obtiene un objeto Empleado a partir de un nodo Empleado del XML
     * 
     * @param node  Nodo Empleado del XML
     * @return      Objeto Empleado
     */
    private Empleado getEmpleado(Node node){
        Empleado emple = new Empleado();
        
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            emple.setIdentificador(Long.parseLong(getTagValue("identificador", element)));
        }
        return emple;
    }
    
    /**
     * Convierte la lista de empleados del XML en una lista de objetos Empleados
     * 
     * @return Lista de objetos Empleados
     */
    public List<Empleado> getEmpleados(){
        List<Empleado> empleList = new ArrayList<Empleado>();
        NodeList nodeList = this.documento.getElementsByTagName("Empleado");
        
        for (int i=0; i<nodeList.getLength(); i++){
            empleList.add(getEmpleado(nodeList.item(i)));
        }
        
        return empleList;
    }
}
