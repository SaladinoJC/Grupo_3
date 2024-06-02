/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import empresa.Cliente;
import empresa.excepciones.ClienteNoExistenteExeption;

/**
 *
 * @author manso
 */
public class LogueoUsuario extends javax.swing.JFrame {

    /**
     * Creates new form LogueoUsuario
     */
    public LogueoUsuario() {
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

        jButtonAceptar = new javax.swing.JButton();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonRegistrarce = new javax.swing.JButton();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();
        jLabelContraseña = new javax.swing.JLabel();
        jLabel_UsuarioIncorrecto = new javax.swing.JLabel();
        jLabelClienteNoExiste = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setActionCommand("");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jTextFieldNombreUsuario.setText("Nombre de usuario");

        jLabel1.setText("¿usuario nuevo?");

        jButtonRegistrarce.setText("Registrarce");
        jButtonRegistrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarceActionPerformed(evt);
            }
        });

        jPasswordFieldContraseña.setText("Contraseña");

        jLabelContraseña.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_UsuarioIncorrecto)
                    .addComponent(jLabelContraseña)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRegistrarce)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addComponent(jPasswordFieldContraseña))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addGap(52, 52, 52)
                        .addComponent(jLabelClienteNoExiste, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel_UsuarioIncorrecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jLabelClienteNoExiste, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrarce)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarceActionPerformed
               Registrarce ventana=new Registrarce();
               this.setVisible(false);//dejo la ventana actual de ser visible
               this.dispose();//elimino la ventana para que no ocupe memoria (eliminar el objeto)
               ventana.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarceActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        String nombreUsuario,contraseña;
        contraseña=jPasswordFieldContraseña.getText();
        nombreUsuario=jTextFieldNombreUsuario.getText();
        Cliente aux;
        PedidoIterface ventana;
        
        if(Valido(nombreUsuario, contraseña))
        {
            try{
                aux=Controlador.buscarCliente(nombreUsuario, contraseña);
                ventana=new PedidoIterface(nombreUsuario,contraseña);
                this.setVisible(false);
                this.dispose();
                ventana.setVisible(true);
            }
            catch(ClienteNoExistenteExeption e)
            {
                jLabelClienteNoExiste.setText("el cliente ingresado no existe");
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed
   

    private boolean Valido(String nombreUsuario,String contraseña)
    {
        boolean bandera=true;
        if(tieneEspacios(contraseña))
        {
            jLabelContraseña.setText("la contraseña no puede tener espacios");
            bandera=false;
        }
        else
           jLabelContraseña.setText("");
        
        if(tieneEspacios(nombreUsuario))
        {
           jLabel_UsuarioIncorrecto.setText("el nombre de usuario no puede contener espacios");
           bandera=false;
        }
        else
          jLabel_UsuarioIncorrecto.setText("");
        return bandera;
    }
//verifica si tiene espacios una cadena de texto
    private boolean tieneEspacios(String aux)
    {
       int i=0;
       while(i<aux.length() && i!= -1)
       {
          if(Character.isSpaceChar(aux.charAt(i)))
             i=-1;
         else
             i++;
       }
       return i == -1;
        
    }
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
            java.util.logging.Logger.getLogger(LogueoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogueoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogueoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogueoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogueoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonRegistrarce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClienteNoExiste;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabel_UsuarioIncorrecto;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
