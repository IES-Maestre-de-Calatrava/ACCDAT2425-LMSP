/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.filedomxml;

import com.lmsp.maestre.filedomxml.model.Empleado;
import com.lmsp.maestre.filedomxml.model.GestionContenidoDOM;
import java.util.List;
import org.w3c.dom.Element;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class FileDOMxml {

    public static void main(String[] args) {
        GestionContenidoDOM modelo = new GestionContenidoDOM("Empleados");
        
//        Element elem = modelo.addNodo("Empleado");
//        modelo.addNodoYTexto("identificador","1", elem);
//        //modelo.addNodoYTexto("Cargo", "Por especificar", elem);
//        
//        elem = modelo.addNodo("Empleado");
//        modelo.addNodoYTexto("identificador","2", elem);
//        //modelo.addNodoYTexto("Cargo", "Por especificar", elem);
//        
//        elem = modelo.addNodo("Empleado");
//        modelo.addNodoYTexto("identificador","3", elem);
        
        modelo.addNodoYTextoANodos("departamento", "2", "Empleado");
        //modelo.addNodoYTexto("Cargo", "Por especificar", elem);
        modelo.generarArchivoDelDom("./resources/Empleados2.xml");
       modelo.cargarArchivoEnMemoria("./resources/Empleados2.xml");
       
       modelo.mostrarPantalla();
//        //modelo.mostrarPantalla();
//        List<Empleado> emple = modelo.getEmpleados();
//        for(Empleado e:emple){
//            System.out.println(e);
//        }
        
        //modelo.generarArchivoDelDom("./resources/Empleados.xml");
        //paras el borrado usar removeChild();
    }
}
