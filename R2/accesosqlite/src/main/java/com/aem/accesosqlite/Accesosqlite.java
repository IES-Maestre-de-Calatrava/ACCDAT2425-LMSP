/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aem.accesosqlite;

import com.aem.accesosqlite.bbdd.OperacionesBBDD;
import com.aem.accesosqlite.modelo.Departamentos;
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
    public static void main(String[] args) {
        
        bbdd.abrirConexion();
        dep.insert();
        bbdd.cerrarConexion();
    }
    
}
