/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import empresa.excepciones.ClienteExistenteException;



/**
 *
 * @author manso
 */
public class Registrarce extends javax.swing.JFrame {

    /**
     * Creates new form Registrarce
     */
    public Registrarce() {
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

        jTextFieldNombreReal = new javax.swing.JTextField();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jTextFieldContraseña = new javax.swing.JTextField();
        jButtonRegistrarce = new javax.swing.JButton();
        jLabel_NombreIncorrecto = new javax.swing.JLabel();
        jLabel_NombreUsuario_Incorrecto_Existente = new javax.swing.JLabel();
        jLabel_ContraseñaIncorrecto = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jLabelExistente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldNombreReal.setText("Nombre Real");
        jTextFieldNombreReal.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldNombreRealInputMethodTextChanged(evt);
            }
        });

        jTextFieldNombreUsuario.setText("Nombre De Usuario");

        jTextFieldContraseña.setText("Contraseña");
        jTextFieldContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContraseñaActionPerformed(evt);
            }
        });

        jButtonRegistrarce.setText("Registrarce");
        jButtonRegistrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarceActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVolver)
                    .addComponent(jLabel_ContraseñaIncorrecto)
                    .addComponent(jLabel_NombreUsuario_Incorrecto_Existente)
                    .addComponent(jLabel_NombreIncorrecto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRegistrarce)
                        .addGap(74, 74, 74)
                        .addComponent(jLabelExistente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldNombreReal)
                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jTextFieldContraseña))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel_NombreIncorrecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombreReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel_NombreUsuario_Incorrecto_Existente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel_ContraseñaIncorrecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jButtonRegistrarce))
                    .addComponent(jLabelExistente))
                .addGap(31, 31, 31)
                .addComponent(jButtonVolver)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContraseñaActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
                LogueoUsuario ventana=new LogueoUsuario();
                this.setVisible(false);//dejo la ventana actual de ser visible
                this.dispose();//elimino la ventana para que no ocupe memoria (eliminar el objeto)
                ventana.setVisible(true);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jTextFieldNombreRealInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldNombreRealInputMethodTextChanged
           
    }//GEN-LAST:event_jTextFieldNombreRealInputMethodTextChanged

    //la accion de registrar un nuevo ususario
    private void jButtonRegistrarceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarceActionPerformed
            String nombre,nombreUsuario,contraseña;
            nombre=jTextFieldNombreReal.getText();
            nombreUsuario=jTextFieldNombreUsuario.getText();
            contraseña=jTextFieldContraseña.getText();
            if(Valido(nombre, nombreUsuario, contraseña)){//pregunta si sus campos son validos    
                try{
                    Controlador.registrarce(nombre, nombreUsuario, contraseña);//intenta registrar el nuevo usuario
                    jLabelExistente.setText("registro exitoso");
                }
                catch(ClienteExistenteException e){//si ya existe le avisa al ususario
                       jLabelExistente.setText("usuario ya existente");
                }
            }
    }//GEN-LAST:event_jButtonRegistrarceActionPerformed
    //verifica si todos los campos son validos
    private boolean Valido(String nombre,String nombreUsuario,String contraseña) {
        boolean bandera=true;
        if(tieneNumeros(nombre))//si tiene numeros un nombre Real es incorrecto
        {
            jLabel_NombreIncorrecto.setText("Nombre incorecto, no puede llevar numeros");
            bandera=false;
        }
        else
            jLabel_NombreIncorrecto.setText("");
        if(tieneEspacios(nombreUsuario))
        {
          jLabel_NombreUsuario_Incorrecto_Existente.setText("el nombre de usuario no debe llevar espacios");
          bandera=false;
        }
        else
           jLabel_NombreUsuario_Incorrecto_Existente.setText("");
        if(tieneEspacios(contraseña))
        {
          jLabel_ContraseñaIncorrecto.setText("la contraseña no debe contar con espacios");
          bandera=false;
        }
        else
           jLabel_ContraseñaIncorrecto.setText("");
        return bandera;
    }
    
    
    
    //verifica si un string tiene numeros 
    private boolean tieneNumeros(String aux)
    {
       int i=0;
       while(i<aux.length() && i!= -1)
       {
          if(Character.isDigit(aux.charAt(i)))
             i=-1;
         else
             i++;
       }
       return i == -1;
    }
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
            java.util.logging.Logger.getLogger(Registrarce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarce().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrarce;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelExistente;
    private javax.swing.JLabel jLabel_ContraseñaIncorrecto;
    private javax.swing.JLabel jLabel_NombreIncorrecto;
    private javax.swing.JLabel jLabel_NombreUsuario_Incorrecto_Existente;
    private javax.swing.JTextField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldNombreReal;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
