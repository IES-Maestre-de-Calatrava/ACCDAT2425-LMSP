/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasefile.vista;

import clasefile.controlador.ControlArchivo;
import clasefile.controlador.ControlCarpeta;
import clasefile.vista.InterfazVista;
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
 * @author Usuario
 */
public class VistaGrafica extends JFrame implements InterfazVista{

    /**
     * Creates new form VistaGrafica
     */
    public VistaGrafica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ruta = new JTextField();
        creaCarpeta = new JButton();
        muestraDir = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ruta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rutaActionPerformed(evt);
            }
        });

        creaCarpeta.setText("Crear carpeta");
        creaCarpeta.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaCarpetaActionPerformed(evt);
            }
        });

        muestraDir.setText("Muestra directorio");
        muestraDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muestraDirMouseClicked(evt);
            }
        });
        muestraDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                muestraDirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(creaCarpeta)
                        .addGap(27, 27, 27)
                        .addComponent(muestraDir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creaCarpeta)
                    .addComponent(muestraDir))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaActionPerformed

    private void creaCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaCarpetaActionPerformed
        //Crear carpeta
        creaCarpeta.setActionCommand(CREARCARPETACONRUTACOMPLETA);
    }//GEN-LAST:event_creaCarpetaActionPerformed

    private void muestraDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muestraDirActionPerformed
        //Muestra contenido directorio
        muestraDir.setActionCommand(MUESTRATODO);
    }//GEN-LAST:event_muestraDirActionPerformed

    private void muestraDirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muestraDirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_muestraDirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGrafica().setVisible(true);
            }
        });
    }

    @Override
    public void setControlador(ControlCarpeta c) {
        creaCarpeta.addActionListener(c);
        muestraDir.addActionListener(c);
    }

    @Override
    public void setControlador(ControlArchivo ca) {
        
    }

    @Override //No pongo el pack porque lo pone por defecto
    public void arranca() { 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public String getRuta() {
        return ruta.getText();
    }

    @Override
    public String getNombre() {
        return ruta.getText();
    }

    public String getNombreNuevo() {
        return ruta.getText();
    }

    public String getRutaNueva() {
        return ruta.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creaCarpeta;
    private javax.swing.JButton muestraDir;
    private javax.swing.JTextField ruta;
    // End of variables declaration//GEN-END:variables
}