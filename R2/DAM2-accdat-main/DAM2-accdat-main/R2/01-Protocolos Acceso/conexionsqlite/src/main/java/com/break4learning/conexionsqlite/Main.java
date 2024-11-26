/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.break4learning.conexionsqlite;

import com.break4learning.conexionsqlite.modelo.ConexionSqlite;

/**
 * Clase que muestra el método de conexión y desconexión a Sqlite.
 *
 * Tenemos que importar la librería sqlite-jdbc desde el repositorio de Maven:
 * 
 * Vamos a la pestaña "Services" de NetBeans -> Maven Repositories -> Botón derecho y seleccionar Find...
 * Escribir sqlite-jdbc y pulsar aceptar.
 * En el árbol se ha añadido un nuevo elemento con el resultado de la búsqueda
 * Seleccionar org.xerial y luego la versión 3.47.0.0
 * Pulsar con el botón derecho sobre la versión seleccionada y seleccionar Add as Dependency...
 * Abrir el archivo pom.xml y revisar si se ha añadido
 * 
 * @author Break4Learning
 */
public class Main {
    public static void main(String[] args){
        
        ConexionSqlite modelo = new ConexionSqlite();
                
        modelo.conexion();
        
        modelo.cierreConexion();
        
    } 
}