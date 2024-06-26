/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import empresa.Cliente;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.ZoneInvalidException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author manso
 */
public class PedidoIterface extends javax.swing.JFrame {
    private String nombreUsuario;//la interface tiene el nombre de usuario y la contrseña 
    private String contraseña;

    /**
     * Creates new form Pedido
     */
    public PedidoIterface(String nombreUsuario,String contraseña) {
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.contraseña=contraseña;
        SeterCliente(this.nombreUsuario,this.contraseña);//setea un label con la informacion del cliente
        SeterFecha();//setea un label con la fecha actual
        SeterHora();//setea un label con la hora actual
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupZONA = new javax.swing.ButtonGroup();
        buttonGroupANIMALES = new javax.swing.ButtonGroup();
        buttonGroupEquipaje = new javax.swing.ButtonGroup();
        jLabelZONA = new javax.swing.JLabel();
        jRadioButtonPeligrosa = new javax.swing.JRadioButton();
        jRadioButtonSinAfaltar = new javax.swing.JRadioButton();
        jRadioButtonEstandar = new javax.swing.JRadioButton();
        jLabelAnimales = new javax.swing.JLabel();
        jCheckBoxSI = new javax.swing.JCheckBox();
        jCheckBoxNO = new javax.swing.JCheckBox();
        jLabelPasajeros = new javax.swing.JLabel();
        jTextFieldPasajeros = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelEquipaje = new javax.swing.JLabel();
        jCheckBoxDeMano = new javax.swing.JCheckBox();
        jCheckBoxBaul = new javax.swing.JCheckBox();
        jButtonPedir = new javax.swing.JButton();
        jLabelFaltaZona = new javax.swing.JLabel();
        jLabelFaltaMascota = new javax.swing.JLabel();
        jLabelFaltaEquipaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelZONA.setText("ZONA");

        buttonGroupZONA.add(jRadioButtonPeligrosa);
        jRadioButtonPeligrosa.setText("Peligrosa");

        buttonGroupZONA.add(jRadioButtonSinAfaltar);
        jRadioButtonSinAfaltar.setText("Sin Afaltar");

        buttonGroupZONA.add(jRadioButtonEstandar);
        jRadioButtonEstandar.setText("Estandar");

        jLabelAnimales.setText("ANIMALES");

        buttonGroupANIMALES.add(jCheckBoxSI);
        jCheckBoxSI.setText("SI");

        buttonGroupANIMALES.add(jCheckBoxNO);
        jCheckBoxNO.setText("NO");

        jLabelPasajeros.setText("Cantidad de Pasajeros");

        jTextFieldPasajeros.setText("0");

        jLabelCliente.setText("Cliente:Cliente");

        jLabelFecha.setText("Fecha:Fecha");

        jLabelHora.setText("Hora:hora");

        jLabelEquipaje.setText("EQUIPAJE");

        buttonGroupEquipaje.add(jCheckBoxDeMano);
        jCheckBoxDeMano.setText("De Mano");

        buttonGroupEquipaje.add(jCheckBoxBaul);
        jCheckBoxBaul.setText("Baul");

        jButtonPedir.setText("Pedir");
        jButtonPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelZONA)
                                    .addComponent(jRadioButtonPeligrosa)
                                    .addComponent(jRadioButtonSinAfaltar))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxSI)
                                        .addGap(125, 125, 125)
                                        .addComponent(jCheckBoxDeMano))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxNO)
                                        .addGap(116, 116, 116)
                                        .addComponent(jCheckBoxBaul))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelAnimales)
                                            .addComponent(jLabelFaltaMascota))
                                        .addGap(100, 100, 100)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelFaltaEquipaje)
                                            .addComponent(jLabelEquipaje)))))
                            .addComponent(jLabelCliente))
                        .addGap(138, 177, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPasajeros)
                            .addComponent(jTextFieldPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPedir)
                            .addComponent(jLabelFaltaZona)
                            .addComponent(jRadioButtonEstandar))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabelFecha)
                .addGap(18, 18, 18)
                .addComponent(jLabelHora)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jLabelHora))
                .addGap(18, 18, 18)
                .addComponent(jLabelCliente)
                .addGap(39, 39, 39)
                .addComponent(jLabelPasajeros)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFaltaZona)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelFaltaMascota)
                        .addComponent(jLabelFaltaEquipaje)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelZONA)
                    .addComponent(jLabelAnimales)
                    .addComponent(jLabelEquipaje))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPeligrosa)
                    .addComponent(jCheckBoxSI)
                    .addComponent(jCheckBoxDeMano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNO)
                    .addComponent(jRadioButtonSinAfaltar)
                    .addComponent(jCheckBoxBaul))
                .addGap(12, 12, 12)
                .addComponent(jRadioButtonEstandar)
                .addGap(34, 34, 34)
                .addComponent(jButtonPedir)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedirActionPerformed
        String cantPasajeros=jTextFieldPasajeros.getText();
        if(Valido(cantPasajeros))//pregunta si estan todos los campos completo y con valores validos
        {   
            this.setVisible(false);
            enviarDatos();
            this.dispose(); 
        }
    }//GEN-LAST:event_jButtonPedirActionPerformed
    //este metodo extrae los dato de la interface pedido y se los envia al controlador
    private void enviarDatos()
    {
        
        int cantPasajeros=Integer.parseInt(jTextFieldPasajeros.getText());
        String zona,equipaje,usuario,contraseña;
        boolean animales;
        LocalDate fecha=LocalDate.now();
        LocalTime hora=LocalTime.now();
     
        //zona
        if(jRadioButtonEstandar.isSelected())
            zona="Estandar";
        else if(jRadioButtonPeligrosa.isSelected())
              zona="Peligrosa";
        else
              zona="Sin asfalta";
        
        //animales
        if(jCheckBoxSI.isSelected())
            animales=true;
        else
            animales=false;
        //equipaje
        if(jCheckBoxBaul.isSelected())
            equipaje="Baul";
        else
            equipaje="Manual";
            
        try {
            try {
                Controlador.HacerPedido(cantPasajeros, zona, equipaje, animales, fecha, hora,Controlador.buscarCliente(this.nombreUsuario,this.contraseña));
            } catch (DateInvalidException ex) {
                Logger.getLogger(PedidoIterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ZoneInvalidException ex) {
                Logger.getLogger(PedidoIterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LuggageInvalidException ex) {
                Logger.getLogger(PedidoIterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClienteNoExistenteExeption ex) {
            Logger.getLogger(PedidoIterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //devuelve si un pedio es valido
    private boolean  Valido(String cantPasajeros)
    {
        boolean bandera=true;
        if(buttonGroupANIMALES.getSelection() == null)
        {
            bandera=false;
            jLabelFaltaMascota.setText("selecione si o no Mascota");
        }
        else
            jLabelFaltaMascota.setText("");
        
        if(buttonGroupZONA.getSelection() == null)
        {
            bandera=false;
            jLabelFaltaZona.setText("selecione una Zona");
        }
        else
            jLabelFaltaZona.setText("");
        
        if(buttonGroupEquipaje.getSelection() == null)
        {
             bandera=false;
             jLabelFaltaEquipaje.setText("selecione un tipo de equipaje");
        }
        else
            jLabelFaltaEquipaje.setText("");
        
        if(tieneLetras(cantPasajeros)){
            bandera=false;
            jLabelPasajeros.setText("Cantidad de Pasajeros: Tiene que se numeros");
        }
        else
            if(Integer.parseInt(cantPasajeros)>30)
            {   
                bandera=false;
                jLabelPasajeros.setText("Cantidad de Pasajeros maxima  es 30");
            }
            else
                jLabelPasajeros.setText("Cantidad de Pasajeros");
       return bandera;
    }
    
    //devuelve verdadero, si no es un digito la cantidad de pasajeros
    private boolean tieneLetras(String pasajeros)
    {
        int i=0;
        while(i<pasajeros.length() && i != -1)
        {
            if(Character.isDigit(pasajeros.charAt(i)))//pregunto si no es un digito
                i++;
            else
                i=-1;
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
            java.util.logging.Logger.getLogger(PedidoIterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoIterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoIterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoIterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
     
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoIterface(null,null).setVisible(true);
            }
        });
    }
    
    //setea el label de cliente
    private void SeterCliente(String nombreUsuario,String contraseña)
    {
        Cliente aux=new Cliente(null,null,null);
        try {
           aux=Controlador.buscarCliente(nombreUsuario, contraseña);
        } catch (ClienteNoExistenteExeption ex) {
            
        }
        jLabelCliente.setText(aux.toString2());
    }
    //setea la fecha de label Fecha
    private void SeterFecha()
    {
      LocalDate fecha=LocalDate.now();//obtengo la fecha actual
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");//le doy formato
      String fechaFormateada = fecha.format(formato);
      jLabelFecha.setText(fechaFormateada);//lo paso a un string para luego insertarlo en un label
    }
    //setea la hora del label hora
    private void SeterHora()
    {
        Timer time=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime hora=LocalTime.now();//obtengo la hora actual
                DateTimeFormatter fomato=DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);//le doy formato
                String horaFormatiada=hora.format(fomato);
                jLabelHora.setText(horaFormatiada);//lo ingreso en una cadena texto para luego setiarlo en un label
            }
        });
        time.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupANIMALES;
    private javax.swing.ButtonGroup buttonGroupEquipaje;
    private javax.swing.ButtonGroup buttonGroupZONA;
    private javax.swing.JButton jButtonPedir;
    private javax.swing.JCheckBox jCheckBoxBaul;
    private javax.swing.JCheckBox jCheckBoxDeMano;
    private javax.swing.JCheckBox jCheckBoxNO;
    private javax.swing.JCheckBox jCheckBoxSI;
    private javax.swing.JLabel jLabelAnimales;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelEquipaje;
    private javax.swing.JLabel jLabelFaltaEquipaje;
    private javax.swing.JLabel jLabelFaltaMascota;
    private javax.swing.JLabel jLabelFaltaZona;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelPasajeros;
    private javax.swing.JLabel jLabelZONA;
    private javax.swing.JRadioButton jRadioButtonEstandar;
    private javax.swing.JRadioButton jRadioButtonPeligrosa;
    private javax.swing.JRadioButton jRadioButtonSinAfaltar;
    private javax.swing.JTextField jTextFieldPasajeros;
    // End of variables declaration//GEN-END:variables
}
