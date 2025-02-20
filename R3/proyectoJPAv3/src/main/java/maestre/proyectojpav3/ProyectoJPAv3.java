/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package maestre.proyectojpav3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
            //modificarDepartamento(30);
//            contarNumeroDepartamentos();
//            listarUnDepartamento();
//            insertaDepartamentoConEmpleado();
//            cierraFactoryController();
            
//            DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
//            Departamentos departamentos = new Departamentos();
//            departamentos.setDeptNo((short)77);
//            departamentos.setDnombre("BIG DATA");
//            departamentos.setLoc("TALAVERA");
//            departamentos.setEmpleadosCollection(null);
//            Empleados emp = new Empleados();
//            Collection<Empleados> empleadosCollection = new ArrayList<Empleados>();
//            emp.setEmpNo((short)7777);
//            emp.setApellido("ROBLES");
//            emp.setSalario(BigDecimal.valueOf(2000));
//            emp.setOficio("ANALISTA");
//            emp.setDir((short)7839);
//            
//            //empleadosCollection.add(emp);
//            departamentos.setEmpleadosCollection(empleadosCollection);
//            
//            
//            departamentosJpaController.create(departamentos);


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
      
            consultaSimple();
            //consultaVariosCampos();
            
            //consultaConCriteriaQueryVariosCampos();
            //borrarDatosConJPQL();
            cierraFactory();
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * B) Ejemplos utilizando JPACONTROLER
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
    public static void cierraFactoryController(){
        emfactory.close();
    }
    public static void insertaDepartamento(short deptN, String nombre, String loc){
        try {
            DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
            Departamentos departamentos = new Departamentos();
            departamentos.setDeptNo(deptN);
            departamentos.setDnombre(nombre);
            departamentos.setLoc(loc);
            departamentosJpaController.create(departamentos);
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void insertaDepartamentoConEmpleado(){
        try {
            DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
            Departamentos departamentos = new Departamentos();
            departamentos.setDeptNo((short)71);
            departamentos.setDnombre("BIG DATA");
            departamentos.setLoc("TALAVERA");
           
            Empleados emp = new Empleados((short)7521);
            Collection<Empleados> empleadosCollection = new ArrayList<Empleados>();
            empleadosCollection.add(emp);
            
            departamentos.setEmpleadosCollection(empleadosCollection);
            
            
            //empleadosCollection.add(emp);
            departamentos.setEmpleadosCollection(empleadosCollection);
            
            
            departamentosJpaController.create(departamentos);
            
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void contarNumeroDepartamentos(){
        DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
        int nElementos = departamentosJpaController.getDepartamentosCount();
        System.out.println("Nº de departamentos: "+nElementos);
    }
    public static void listarUnDepartamento(){
        DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
        Departamentos dep = departamentosJpaController.findDepartamentos((short)10);
        System.out.println(dep.getDnombre());
    }
    public static void modificarDepartamento(int id){
        DepartamentosJpaController departamentosJpaController = new DepartamentosJpaController(emfactory);
        Departamentos dep = departamentosJpaController.findDepartamentos((short)id);
        dep.setLoc("Valencia");
        try {
            departamentosJpaController.edit(dep);
        } catch (Exception ex) {
            Logger.getLogger(ProyectoJPAv3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * C) EJEMPLOS UTILIZANDO JPQL
     */
           /*------------------------------------------------------------------
                Pruebas de lectura
            ---------------------------------------------------------*/
    public static void consultaSimple(){
        Query query = emanager.createQuery("select UPPER(d.dnombre) from Departamentos d");
        List<String> list = query.getResultList();
        for(String e:list){
            System.out.println("Nombre departamento: "+e);
        }
    }
    public static void consultaVariosCampos(){
        TypedQuery<Object[]> query = emanager.createQuery("select d.dnombre, d.loc from Departamentos d", Object[].class);
        List<Object[]> list = query.getResultList();
        for(Object[] e:list){
            System.out.println("Nombre departamento: "+e[0]);
            System.out.println("Localidad: "+e[1]);
        }
    }
    //Consultas con Criteriaquery
    public static void consultaConCriteriaQuery(){
        CriteriaBuilder cb = emanager.getCriteriaBuilder();
        CriteriaQuery<Departamentos> query = cb.createQuery(Departamentos.class);
        Root<Departamentos> c = query.from(Departamentos.class);//Especificamos el from
                                query.select(c);//Indicamos los cmapos a seleccionar
        List<Departamentos> list = emanager.createQuery(query).getResultList();
        for(Departamentos e:list){
            System.out.println("Nombre del departamento: "+e.getDnombre());
        }
    }
    public static void consultaConCriteriaQueryVariosCampos(){
        CriteriaBuilder cb = emanager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Departamentos> c = query.from(Departamentos.class);//Especificamos el from
                                query.select(cb.array(c.get("dnombre"), c.get("loc")));//Indicamos los cmapos a seleccionar
        List<Object[]> list = emanager.createQuery(query).getResultList();
        for(Object[] e:list){
            System.out.println("Nombre del departamento: "+e[0]);
            System.out.println("Nombre de localidad: "+e[1]);
        }
    }
            /*------------------------------------------------------------------
                Pruebas de modificacion y borrado con JPQL
            ---------------------------------------------------------*/
    public static void modificarConJPQL(){
        Query query = emanager.createQuery("UPDATE Departamentos d SET d.dnombre= :valorNuevo WHERE d.deptNo = :deptNoV");
        query.setParameter("valorNuevo", "PRUEBAS");
        query.setParameter("deptNoV", (short)77);
        
        emanager.getTransaction().begin();
        int updateCount = query.executeUpdate();
        emanager.getTransaction().commit();
    }
    public static void borrarDatosConJPQL(){
        Query query = emanager.createQuery("DELETE from Departamentos d  WHERE d.deptNo = :deptNoV");
       
        query.setParameter("deptNoV", (short)77);
        
        emanager.getTransaction().begin();
        int deleteCount = query.executeUpdate();
        emanager.getTransaction().commit();
    }
}
