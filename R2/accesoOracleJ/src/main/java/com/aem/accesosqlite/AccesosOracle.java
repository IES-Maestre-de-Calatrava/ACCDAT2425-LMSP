/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.accesosqlite;

import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import com.aem.accesosqlite.modelo.Departamentos;
import com.aem.accesosqlite.modelo.Empleados;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class AccesosOracle {
    private static OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
    private static Departamentos dep = new Departamentos(1, "Informática", "Ciudad Real");
    
    public static void main(String[] args) {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fecha = null;
        try {
            fecha = s.parse("26/04/2001");
        } catch (ParseException ex) {
            Logger.getLogger(AccesosOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
       Date fechaSQL = new Date(fecha.getTime());
        
        bbdd.conectarOracle();  
        Empleados emp = new Empleados(282, "Serrano", "Dev", 7902, fechaSQL , 200, 1225, 10);
        emp.insert();
        //System.out.println(bbdd.obtenerNumeroFilasDevueltas(bbdd.select("SELECT d.* from departamentos d")));
        bbdd.cierraConexion();
    }
    
}
