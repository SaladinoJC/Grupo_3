/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import choferes.Chofer;
import empresa.Sistema;
import vehiculos.Auto;
import vehiculos.Vehiculo;
import vehiculos.exepciones.VehiculoExistenteException;

/**
 *
 * @author manso
 */
public class Prueba2 {
    public static void main(String[] args) throws VehiculoExistenteException {
        Controlador aux=Controlador.getReferencia();
        Sistema s=Sistema.getReferencia();
        
        Vehiculo auto=new Auto("hyd", 0, true, true);
        s.insertarVehiculo(auto);
        Chofer c=new ;
        
        
       
    }
    
}
