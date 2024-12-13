/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.ejercicio1jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class Ejercicio1JPA {
    static EntityManagerFactory emfactory;
    static EntityManager emanager;
    public static void main(String[] args) {
        inicializaFactory();
        
        cierraFactory();
        
    }
    /**
     * Bloque Factory
     */
    public static void inicializaFactory(){
        emfactory = Persistence.createEntityManagerFactory("maestre_ejercicio1JPA_jar_1.0-SNAPSHOTPU");
        emanager = emfactory.createEntityManager();
    }
    public static void cierraFactory(){
        emanager.close();
        emfactory.close();
    }
    /**
     * Fin bloque Factory
     */
    
    
    
    
    
}
