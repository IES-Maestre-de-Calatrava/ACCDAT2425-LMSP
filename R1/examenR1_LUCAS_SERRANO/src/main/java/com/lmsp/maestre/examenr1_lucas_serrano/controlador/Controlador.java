
package com.lmsp.maestre.examenr1_lucas_serrano.controlador;

import com.lmsp.maestre.examenr1_lucas_serrano.modelo.Modelo;
import com.lmsp.maestre.examenr1_lucas_serrano.modelo.Universidad;
import com.lmsp.maestre.examenr1_lucas_serrano.vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener{

    private final InterfazVista vista;
    private final Modelo modelo;
    
    public Controlador(InterfazVista vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case InterfazVista.CREAESCTRUCTURACARPETAS -> {
                String c1 = vista.getFolder();
                String c2 = vista.getFolder();
                modelo.crearEstructuraDeCarpetas(c1, c2);
                
            }
            case InterfazVista.ALTADATOSCARRERAS -> {
                for (int i = 0; i<4;i++){
                    Universidad u = new Universidad(vista.getId(),vista.getCarrera(),vista.getCiudad(),vista.getNotaCorte());
                    if (modelo.altaDatosCarrerasUniversitarias(u)){
                        System.out.println("Insertados los datos");
                    }else{
                        System.out.println("No insertados los datos");
                    }
                }
                
            }
            case InterfazVista.GENERAXMLCARRERAS -> {
                
                    modelo.generaXMLCarrerasUniversitarias();
                
            }  
            case InterfazVista.GENERAPLANTILLAXSL -> {
                  
                    modelo.generaPlantillaXSL();
               
            }
            case InterfazVista.MODIFICACARRERA ->{
               
                    modelo.modificaCarreraUniversitaria();
                
            }
            case InterfazVista.GENERAREPORTEHTML ->{
                modelo.generaReporteHtml();
                
            }
           
        }
    }
}
