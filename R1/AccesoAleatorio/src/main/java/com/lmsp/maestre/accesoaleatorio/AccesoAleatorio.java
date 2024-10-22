/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.accesoaleatorio;

import com.lmsp.maestre.accesoaleatorio.model.Empleado;
import com.lmsp.maestre.accesoaleatorio.model.Escritura;
import com.lmsp.maestre.accesoaleatorio.model.Lectura;
import java.util.ArrayList;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class AccesoAleatorio {

    public static void main(String[] args) {
        Escritura modeloE = new Escritura("archivo_empleados.dat");
        Empleado empleado = new Empleado(2,"Rodriguez",52,20070);
        modeloE.escribirEmpleadoSegunId(empleado);
        
        
        empleado = new Empleado("Garcia",2,2500);
        modeloE.escribirEmpleadoFinalArchivo(empleado);
        
        empleado = new Empleado("Robledo",2,5000);
        modeloE.escribirEmpleadoFinalArchivo(empleado);
        
        modeloE.cambiaApellido(5,"Gracia");
        
        Lectura modeloL = new Lectura("archivo_empleados.dat");
        ArrayList<Empleado> empleados = modeloL.muestraRegistros();
        for (Empleado e: empleados){
            System.out.println(e.toString());
        }
    }
}
