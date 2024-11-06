/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.accesosqlite;

import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import com.aem.accesosqlite.modelo.Departamentos;
import com.aem.accesosqlite.modelo.Empleados;




/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class AccesosOracle {
    private static OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
    private static Departamentos dep = new Departamentos(1, "Informática", "Ciudad Real");
    private static Empleados emp = new Empleados(1, "Serrano", "Joyero", 14, "14/12/1998", 28900, 1225, 1);
    
    public static void main(String[] args) {
      
        
        bbdd.conectarOracle();       
        bbdd.cierraConexion();
    }
    
}
