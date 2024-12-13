/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.proyectojpav3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 */
public class ProyectoJPAv3 {
    static EntityManagerFactory emfactory;
    static EntityManager emanager;
    static Departamentos departamentos;
    static DepartamentosJpaController departamentosJpaController;
    public static void main(String[] args) {
        try {
            inicializaFactory();
            DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
            Departamentos departamentos = new Departamentos();
            departamentos.setDeptNo((short)77);
            departamentos.setDnombre("BIG DATA");
            departamentos.setLoc("TALAVERA");
            departamentos.setEmpleadosCollection(null);
            Empleados emp = new Empleados();
            Collection<Empleados> empleadosCollection = new ArrayList<Empleados>();
            emp.setEmpNo((short)7777);
            emp.setApellido("ROBLES");
            emp.setSalario(BigDecimal.valueOf(2000));
            emp.setOficio("ANALISTA");
            emp.setDir((short)7839);
            
            //empleadosCollection.add(emp);
            departamentos.setEmpleadosCollection(empleadosCollection);
            
            
            departamentosJpaController.create(departamentos);


//            leerUnRegistroBloqueando();
//            esperar();
//            leerUnRegistro();



//            leerUnRegistro();
//            esperar();
//            leerUnRegistro();
//            
//            refrescarDesdeBbdd();
//            leerUnRegistro();

            //leerUnRegistroRelacionado();
            
            //insertarDatos(22,"ASTROLOGIA","Valencia");
            
            //modificarDatos(22,"DAIMIEL");
      
            cierraFactory();
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Bloque Entity Manager Factory
     */
    public static void inicializaFactory(){
        emfactory = Persistence.createEntityManagerFactory("maestre_proyectoJPAv3_jar_1.0-SNAPSHOTPU");
        emanager = emfactory.createEntityManager();
    }
    public static void cierraFactory(){
        emanager.close();
        emfactory.close();
    }
    /**
     * Fin bloque Entity Manager Factory
     */
    
    
    /**
     * metodo para esperar (usado para hacer modificaciones en bbdd y comprobar que no se actualizan si no llamammos a refresh
     */
    public static void esperar(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Pulsa enter para continuar...");
            String sTexto = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Bloque lectura
     */
    public static void leerUnRegistro(){
        departamentos = emanager.find(Departamentos.class, (short)10);
        if(departamentos != null){
            System.out.println("Dept_name: "+departamentos.getDnombre());
        }else{
            System.out.println("No existe el registro");
        }
    }
    //Bloqueando para que no se pueda modificar esa fila en Bbdd
    public static void leerUnRegistroBloqueando(){
        emanager.getTransaction().begin();
        departamentos = emanager.find(Departamentos.class, (short)10, LockModeType.PESSIMISTIC_READ);
        if(departamentos != null){
            System.out.println("Dept_name: "+departamentos.getDnombre());
        }else{
            System.out.println("No existe el registro");
        }
        emanager.getTransaction().commit();
    }
    
    //lectura de registros relacionados
    public static void leerUnRegistroRelacionado(short nDept){
        Empleados emple;
        departamentos = emanager.find(Departamentos.class, nDept);
        if(departamentos != null){
            System.out.println("Dept NAME: "+departamentos.getDnombre());
            Collection<Empleados> list = departamentos.getEmpleadosCollection();
            Iterator<Empleados> it = list.iterator();
            while(it.hasNext()){
                emple = it.next();
                System.out.println("Emple SURNAME: "+ emple.getApellido());
            }
//            for(Empleados emp:list){
//                System.out.println("Emple SURNAME: "+ emp.getApellido());
//            }
        }else{
            System.out.println("No existe el registro");
        }
    }
    /**
     * fin bloque lectura
     */
    
    
   
    
    /**
     * metodo refrescar para recargar los datos de la bbdd a memoria
     */
    public static void refrescarDesdeBbdd(){
        emanager.getTransaction().begin();
        emanager.refresh(departamentos);
        emanager.getTransaction().commit();
    }
    
    
    
    public static void insertarDatos(int id, String nombre, String loc){
        Departamentos departamento;
        departamento = new Departamentos();
        departamento.setDeptNo((short)id);
        departamento.setDnombre(nombre);
        departamento.setLoc(loc);
        
        emanager.getTransaction().begin();
        emanager.persist(departamento);
        emanager.getTransaction().commit();
        
    }
    
    public static void modificarDatos(int id, String loc){
        Departamentos departamento;
        emanager.getTransaction().begin();
        
        departamento = emanager.find(Departamentos.class, (short)id, LockModeType.PESSIMISTIC_READ);
        
        
        departamento.setLoc(loc);
        
        emanager.getTransaction().commit();
    }
    
    public static void subirSalario(){//TERMINAR
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce nº de departamento: ");
            int nDept = br.read();
            System.out.println("Introduce subida: ");
            int subida = br.read();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
