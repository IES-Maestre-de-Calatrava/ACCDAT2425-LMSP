/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lmsp.maestre.filexmlconversor;

import com.lmsp.maestre.filexmlconversor.model.Conversor;
import javax.xml.transform.TransformerConfigurationException;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class FileXMLconversor {

    public static void main(String[] args) throws TransformerConfigurationException {
        Conversor modelo = new Conversor("./resources/alumnos.xml", "./resources/alumnosPlantilla.xsl", "./resources/alumnos.html");
        
        modelo.convertirAHTML();
    }
}
