
package com.lmsp.maestre.examenr1_lucas_serrano.vista;

import com.lmsp.maestre.examenr1_lucas_serrano.controlador.Controlador;


public interface InterfazVista {
    void setControlador(Controlador c);
    void arranca();
    
    public String getFolder();
    public long getId();
    public String getCarrera();
    public String getCiudad();
    public double getNotaCorte();
    public boolean getBoolean();
    public char getChar();
    
    
    static final String CREAESCTRUCTURACARPETAS = "Crea estructura de carpetas";
    static final String ALTADATOSCARRERAS = "Da de alta datos de carreras universitarias";
    static final String GENERAXMLCARRERAS = "Genera XML con datos de carreras universitarias";
    static final String GENERAPLANTILLAXSL = "Genera plantilla XSL";
    static final String MODIFICACARRERA = "Modifica la ciudad de la carrera";
    static final String GENERAREPORTEHTML = "Genera Reporte HTML";
    
}
