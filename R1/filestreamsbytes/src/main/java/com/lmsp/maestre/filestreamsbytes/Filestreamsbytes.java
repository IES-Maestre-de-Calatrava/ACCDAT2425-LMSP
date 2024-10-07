/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.filestreamsbytes;

import com.lmsp.maestre.filestreamsbytes.modelo.Escritura;
import com.lmsp.maestre.filestreamsbytes.modelo.Lectura;
import com.lmsp.maestre.filestreamsbytes.modelo.objetos.Empleado;
import java.util.ArrayList;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Filestreamsbytes {

    public static void main(String[] args) {
        /*Escritura modeloE = new Escritura("archivo_binario.bin");
        modeloE.escribirDatosSimple();
        Lectura modeloL = new Lectura("archivo_binario.bin");
        modeloL.lecturaDatosSimple();
        System.out.println(modeloL.lecturaDatosSimple());
        Copia modeloC = new Copia("asturias.jpg", "paraiso.jpg");
        modeloC.copiarArchivo();
        System.out.println(modeloC);*/
     
            Lectura modeloL = new Lectura("archivo_con_objetos2");
            Escritura modeloE = new Escritura("archivo_con_objetos2");

            Empleado empleado = new Empleado("Fernando", "Urena", 23, 800);
            modeloE.escribirObjetos(empleado);

            empleado = new Empleado("Luisa", "Garcia", 20, 4800);
            modeloE.escribirObjetos(empleado);

            empleado = new Empleado("Angel", "Carmona", 26, 1800);
            modeloE.escribirObjetos(empleado);

           /* ArrayList<Object> empleados = modeloL.lecturaObjetos();
            empleados.forEach(System.out::println);*/
            ArrayList<Empleado> empleadosE = (ArrayList<Empleado>) (ArrayList<?>) modeloL.lecturaObjetos();
            empleadosE.forEach(System.out::println);
                
        
    }
}
