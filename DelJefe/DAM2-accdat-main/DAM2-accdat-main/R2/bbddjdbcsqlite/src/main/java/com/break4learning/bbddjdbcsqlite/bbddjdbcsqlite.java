/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.break4learning.bbddjdbcsqlite;

import com.break4learning.bbddjdbcsqlite.bbdd.OperacionesBBDD;
import com.break4learning.bbddjdbcsqlite.modelo.Departamento;
import com.break4learning.bbddjdbcsqlite.modelo.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para probar el funcionamiento de JDBC con SQLite
 *
 * @author Break4Learning by Javier García-Retamero Redondo
 * @version 1.0
 * Created on 30 oct 2024
 */
public class bbddjdbcsqlite {
    
    private static OperacionesBBDD bbdd = OperacionesBBDD.getInstance();

    public static void main(String[] args) {
        
        
        bbdd.abrirConexion();
        
        /******************************
         * PRUEBAS CON DEPARTAMENTO
         ******************************/
              
        /**
         * CONSULTA DE TODOS LOS REGISTROS
         */
        //Departamento.mostrarResultSet(Departamento.selectAll(bbdd));
              
        /**
         * CONSULTA POR CLAVE PRIMARIA
         */
        //Departamento departamento = new Departamento();        
        //departamento.selectById(bbdd,60);
        //System.out.println(departamento);
        
        /**
         * INSERCIÓN
         */
        //Departamento departamento = new Departamento(60,"TRANSPORTE","MADRID");
        //departamento.insertar(bbdd);
        
        /**
         * MODIFICACIÓN
         */
        //Departamento departamento = new Departamento(60,"TRANSPORTE","ZARAGOZA");
        //departamento.update(bbdd);
        
        /**
         * BORRADO
         */
        //Departamento.delete(bbdd, 60);
         
        
        /******************************
         * PRUEBAS CON EMPLEADO
         ******************************/
                     
        /**
         * INSERCIÓN
         */
        //Empleado empleado = new Empleado(7888, "GARCIA", "ANALISTA", 7566, "08/11/2024", 2000, 200.50, 10);
        //empleado.insertar(bbdd);
        
        /**
         * CONSULTA DE TODOS LOS REGISTROS
         */
        //Empleado.mostrarResultSet(Empleado.selectAll(bbdd));
              
        /**
         * CONSULTA POR CLAVE PRIMARIA
         */
        //Empleado empleado = new Empleado();        
        //empleado.selectById(bbdd,7888);
        //System.out.println(empleado);
        
        /**
         * MODIFICACIÓN
         */
        //Empleado empleado = new Empleado(7888, "GARCIA", "VENDEDOR", 7566, "08/11/2024", 2000, 200.50, 10);
        //empleado.update(bbdd);
        
        /**
         * BORRADO
         */
        //Empleado.delete(bbdd, 7888);
                 
                        
        /************************************************
         * PRUEBAS SENTENCIAS DE DESCRIPCIÓN
         ************************************************/
        //bbdd.obtenerInformacionDeConexion();
        //bbdd.obtenerInformacionDeLasTablas();
        //bbdd.obtenerInformacionDeLasColumnas("DEPARTAMENTOS");
        //bbdd.obtenerInformacionDelResultSet(Departamento.selectAll(bbdd));
        
        bbdd.cerrarConexion();
        
    }
    
   
}
