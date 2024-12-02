/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.proyectojpav3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class ProyectoJPAv3 {
    static EntityManagerFactory emfactory;
    static EntityManager entitymanager;
    static Departamentos departamentos;
    static DepartamentosJpaController departamentosJpaController;
    public static void main(String[] args) {
        try {
            emfactory = Persistence.createEntityManagerFactory("maestre_proyectoJPAv3_jar_1.0-SNAPSHOTPU");
            DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
            Departamentos departamentos = new Departamentos();
            departamentos.setDeptNo((short)99);
            departamentos.setDnombre("Pruebas");
            departamentos.setLoc("Madrid");
            departamentosJpaController.create(departamentos);
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
