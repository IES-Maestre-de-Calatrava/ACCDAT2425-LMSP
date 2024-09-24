/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clasefile.vista;

import clasefile.controlador.ControlArchivo;
import clasefile.controlador.ControlCarpeta;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author LMSP by Lucas Manuel Serrano Perez
 * @version 1.0
 * Created on 13 sept 2024
 */
public class VistaGUImal extends JFrame implements InterfazVista{
    private ControlCarpeta controlador;
    private ControlArchivo controladorA;
    private JPanel panelPrincipal;
    private JTextField ruta;
    private JButton crearCarpeta;
    private JButton mostrarCarpeta;
    
    public VistaGUImal(){
        super("Clase File");
        initComponents();
    }
    
    private void initComponents(){
        panelPrincipal = new JPanel();
        ruta = new JTextField(10);
        crearCarpeta = new JButton();
        mostrarCarpeta = new JButton();
        
        
        panelPrincipal.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        panelPrincipal.setLayout(new BorderLayout(100, 100));
       
        
        panelPrincipal.add(ruta);
        panelPrincipal.add(crearCarpeta);
        panelPrincipal.add(mostrarCarpeta);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*ruta.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //rutaActionPerformed(evt);
            }
        });*/
    }
    @Override
    public void setControlador(ControlCarpeta c) {
        this.controlador = c;
    }

    @Override
    public void setControlador(ControlArchivo ca) {
        this.controladorA = ca;
    }

    @Override
    public void arranca() {
       // procesaNuevaOperacion();
       pack();
       setLocationRelativeTo(null);
       setVisible(true);
    }

    @Override
    public String getRuta() {
        return ruta.getText();
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
