/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.accesosqlite;

import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import com.aem.accesosqlite.modelo.Departamentos;
import com.aem.accesosqlite.modelo.Empleados;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author AEM by Alejandro Esteban Martinez de la Casa
 */
public class Accesosqlite {
    private static OperacionesBBDD bbdd = OperacionesBBDD.getInstance();
    private static Departamentos dep = new Departamentos(1, "Informática", "Ciudad Real");
    private static Empleados emp = new Empleados(1, "Serrano", "Joyero", 14, "14/12/1998", 28900, 1225, 1);
    
    public static void main(String[] args) {
        
        bbdd.abrirConexion();
        //dep.insert();
        //dep.selectById(bbdd, 1);
        //System.out.println(dep);
        //emp.insert();
//        Departamentos dep2 = new Departamentos();
//        dep2.selectById(bbdd, 2);
//        System.out.println(dep2);
//        
//        dep2.setPoblacionDep("Albacete");
//        dep2.update(bbdd);
//        dep2.selectById(bbdd,2);
//        System.out.println(dep2);
//        Departamentos dep3 = new Departamentos(3,"Logistica","Cuenca");
//        dep3.insert();
//        Departamentos.mostrarResultSet(Departamentos.selectAll(bbdd));
        //Departamentos.delete(bbdd, 1);
        Empleados emp1 = new Empleados(2, "Serrano", "Joyero", 14, "14/12/1998", 28900, 1225, 1);
        emp1.insert();
        emp1.selectByIdEmple(bbdd, 2);
        System.out.println(emp1);
        
        emp1.setApellido("Garcia");
        emp1.update(bbdd);
        emp1.selectByIdEmple(bbdd, 2);
        System.out.println(emp1);
        bbdd.cerrarConexion();
    }
    
}
