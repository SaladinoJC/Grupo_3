/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import empresa.Sistema;

/**
 *
 * @author manso
 */
public class Prueba2 {
    public static void main(String[] args) {
        Controlador aux=Controlador.getReferencia();
        System.out.println(Sistema.getReferencia().toString());
        Registrarce ventana=new Registrarce();
        ventana.setVisible(true);
    }
    
}
