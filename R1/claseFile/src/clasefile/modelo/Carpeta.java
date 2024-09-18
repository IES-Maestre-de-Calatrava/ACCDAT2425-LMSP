/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.modelo;

import java.io.File;

/**
 * Clase encargada d ela logica de la aplicacion
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 18 sept 2024
 */
public class Carpeta {
    private String ruta;
    /**
     * Constructor de la clase
     * @param ruta 
     */
    public Carpeta(String ruta){
        this.ruta = ruta;
    }
    /**
     * COnstructor vacio
     */
    public Carpeta(){
  
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    /**
     * Metodo que crea un direcctorio en la ruta indicada
     * Utiliza el atributo d ela clase
     */
    public void crearCarpeta(){
       File directorioNuevo = new File(ruta);
       directorioNuevo.mkdir();
    }
}
