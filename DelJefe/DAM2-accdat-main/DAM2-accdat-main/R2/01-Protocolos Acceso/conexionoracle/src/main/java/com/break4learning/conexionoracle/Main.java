/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.break4learning.conexionoracle;

import com.break4learning.conexionoracle.modelo.ConexionOracle;

/**
 * Clase que muestra el método de conexión y desconexión a Oracle.
 * 
 * Tenemos que importar la librería ojdbc desde el repositorio de Maven:
 * 
 * ojdbc
 * =========
 * Vamos a la pestaña "Services" de NetBeans -> Maven Repositories -> Botón derecho y seleccionar Find...
 * Escribir Ojdbc y pulsar aceptar.
 * En el árbol se ha añadido un nuevo elemento con el resultado de la búsqueda
 * Seleccionar com.oracle.database.jdbc: ojdbc11 y luego la versión 23.5.0.24.07
 * Pulsar con el botón derecho sobre la versión seleccionada y seleccionar Add as Dependency...
 * Abrir el archivo pom.xml y revisar si se ha añadido
 * 
 * @author Break4Learning
 */
public class Main {
    public static void main(String[] args){
        
        ConexionOracle modelo = new ConexionOracle();
        
        modelo.conexion();       
        modelo.cierraConexion();
        
    }  
}