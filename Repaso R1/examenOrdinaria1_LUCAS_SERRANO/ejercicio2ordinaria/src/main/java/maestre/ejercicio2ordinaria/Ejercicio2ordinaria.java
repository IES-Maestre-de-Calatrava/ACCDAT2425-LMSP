/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.ejercicio2ordinaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Ejercicio2ordinaria {

    
    public static void main(String[] args) {
        Lanzamientos objeto1 = new Lanzamientos(3,"01/04/2025","Guayana Francesa",240);
        Lanzamientos objeto2 = new Lanzamientos(6,"12/04/2025","Cabo Cañaveral",360);
        insertaEjercicio2(objeto1);
        insertaEjercicio2(objeto2);
        muestraEjercicio2(3);
        objeto1.setFecha_lanzamiento("01/05/2025");
        insertaEjercicio2(objeto1);
        muestraEjercicio2(3);
    }
    private static void insertaEjercicio2(Lanzamientos lanzamiento){
        int id = lanzamiento.getId();
        String fecha_lanzamiento = lanzamiento.getFecha_lanzamiento();
        String lugar_lanzamiento = lanzamiento.getLugar_lanzamiento();
        int horas_vuelo_estimadas = lanzamiento.getHoras_vuelo_estimadas();
        
        RandomAccessFile randomFile = null;
        StringBuffer sb = null;
        long posicion = (id-1)*lanzamiento.LONGITUD_TOTAL;
        try {
            randomFile = new RandomAccessFile("./LANZAMIENTOS/datosLanzamientos.dat", "rw");
            randomFile.seek(posicion);
            if(randomFile.length()>=posicion){
                if(id == randomFile.readInt()){
                    sb = new StringBuffer(fecha_lanzamiento);
                    sb.setLength(lanzamiento.CARACTERES_FECHA);
                    randomFile.writeChars(sb.toString());
                }else{
                    randomFile.seek(posicion);
                    randomFile.writeInt(id);
                    sb = new StringBuffer(fecha_lanzamiento);
                    sb.setLength(lanzamiento.CARACTERES_FECHA);
                    randomFile.writeChars(sb.toString());
                    sb = new StringBuffer(lugar_lanzamiento);
                    sb.setLength(lanzamiento.CARACTERES_LUGAR);
                    randomFile.writeChars(sb.toString());
                    randomFile.writeInt(horas_vuelo_estimadas);
                }
                
            }else{
                randomFile.writeInt(id);
                sb = new StringBuffer(fecha_lanzamiento);
                sb.setLength(lanzamiento.CARACTERES_FECHA);
                randomFile.writeChars(sb.toString());
                sb = new StringBuffer(lugar_lanzamiento);
                sb.setLength(lanzamiento.CARACTERES_LUGAR);
                randomFile.writeChars(sb.toString());
                randomFile.writeInt(horas_vuelo_estimadas);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                randomFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio2ordinaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private static void muestraEjercicio2(int id){
        Lanzamientos l = new Lanzamientos();//SOLO SIRVE PARA SACAR LONGITUDES
        RandomAccessFile randomFile = null;
        long posicion = (id-1)*l.LONGITUD_TOTAL;
        try {
            randomFile = new RandomAccessFile("./LANZAMIENTOS/datosLanzamientos.dat","r");
            randomFile.seek(posicion);
            
            randomFile.skipBytes(l.LONGITUD_ID+l.LONGITUD_FECHA);
            byte[] lugar = new byte[l.LONGITUD_LUGAR];
            randomFile.readFully(lugar);
            String lugarS = new String(lugar);
           
            int horas = randomFile.readInt();
            
            
            System.out.println("Id: "+id+", Lugar de lanzamiento: "+lugarS+", Horas de vuelo estimadas: "+horas);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2ordinaria.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
     
}
