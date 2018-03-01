/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shelter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author minguez
 */
public class Shelter extends javax.swing.JFrame {

    private String username;
    private ClienteSocket objCliente;

    Thread hilodeEscucha;

    /**
     * Creates new form Shelter
     */
    public Shelter() {
        username = "manu";
        initComponents();
        try {
            inicio();
        } catch (Exception e) {
            printStackTrace(e);
            System.out.println("Ha saltado excepcion en el inicio()");
        }

    }

    public void inicio() throws IOException {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostIP = address.getHostAddress();
            String hostName = address.getHostName();
            System.out.println("IP: " + hostIP + "\n" + "Name: " + hostName);
            objCliente = new ClienteSocket();
            //LE PASAMOS AL SERVIDOR LOS DATOS DEL USUARIO
            objCliente.iniciaConexion(hostIP, "4000", username); //llamamos a registrar el usuario en el servidor
            //objCliente.iniciaServidor();
            objCliente.escuchaServidor();
            //actualizarTextArea();

            System.out.println("asdasdasadsadads");

        } catch (UnknownHostException ex) {
            Logger.getLogger(Shelter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        textprueba = new javax.swing.JTextField();
        botonprueba = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Athelas", 0, 24)); // NOI18N
        jLabel1.setText("Shelter");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shelter/img/home (1).png"))); // NOI18N

        textprueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textpruebaActionPerformed(evt);
            }
        });
        textprueba.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textpruebaKeyPressed(evt);
            }
        });

        botonprueba.setText("Envía");
        botonprueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonpruebaActionPerformed(evt);
            }
        });

        textarea.setColumns(20);
        textarea.setRows(5);
        textarea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textarea.setEnabled(false);
        jScrollPane1.setViewportView(textarea);

        jLabel2.setFont(new java.awt.Font("Shree Devanagari 714", 0, 24)); // NOI18N
        jLabel2.setText("Chats");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        jButton1.setText("Recibe mensaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(icon))))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textprueba)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonprueba)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(icon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textprueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonprueba)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTextArea() {
        textarea.setText(textarea.getText() + textprueba.getText() + "\n");

        //Enviamos la cadena al servidor
        String msj = objCliente.escuchaServidor();

        textarea.setText(textarea.getText() + msj + "\n");
    }
    private void botonpruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonpruebaActionPerformed
        textarea.setText("Yo: " + textarea.getText() + textprueba.getText() + "\n");
        //Enviamos la cadena al servidor
        //String cadena = "Mensaje@" + username + "@" + textprueba.getText();
        String cadena = username + ": " + textprueba.getText();

        objCliente.procesaPeticion(cadena);
        textprueba.setText("");
    }//GEN-LAST:event_botonpruebaActionPerformed

    private void textpruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textpruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textpruebaActionPerformed

    private void textpruebaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textpruebaKeyPressed
        if (evt.getKeyCode() == 10) {
            textarea.setText(textarea.getText() + textprueba.getText() + "\n");
            textprueba.setText("");
        }

    }//GEN-LAST:event_textpruebaKeyPressed

    public javax.swing.JTextArea getArea() {
        return textarea;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        String msj = objCliente.escuchaServidor();
        
        String[] partes = msj.split(":");
        
        if(!partes[0].equals(username)){
            textarea.setText(textarea.getText() + msj + "\n");
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Shelter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shelter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shelter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shelter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shelter().setVisible(true);

                //String mensaje = objCliente.escuchaServidor();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonprueba;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea textarea;
    private javax.swing.JTextField textprueba;
    // End of variables declaration//GEN-END:variables
}
