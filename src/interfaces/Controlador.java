/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import choferes.Chofer;
import empresa.Cliente;
import empresa.Estandar;
import empresa.FactoryViaje;
import empresa.Pedido;
import empresa.Peligrosa;
import empresa.SinAsfaltar;
import empresa.Sistema;
import empresa.TipoDeViaje;
import empresa.Viaje;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import empresa.excepciones.ZoneInvalidException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import vehiculos.Vehiculo;

/**
 *
 * @author manso
 */
public class Controlador implements Observer{
    private static Sistema sistema=Sistema.getReferencia();
    private static Controlador referencia=null;
    private General general;
    
    private Controlador(){
       this.general=new General();
       this.general.setVisible(true);
        //crea un ventana general
    }
    
   public static Controlador getReferencia()
   {
       if(referencia == null)
           referencia=new Controlador();
       
       return referencia;
   }
    

    public static void registrarce(String nombre,String nombreUsuario,String contraseña) throws ClienteExistenteException
    {
        Cliente nuevo=new Cliente(nombreUsuario, contraseña, nombre);
        sistema.insertarCliente(nuevo);
    }
    
    public static Cliente buscarCliente(String nombreUsuario,String contraseña) throws  ClienteNoExistenteExeption
    {
       Cliente buscar=new Cliente(nombreUsuario, contraseña,null);
       buscar=sistema.buscarXcliente(buscar); 
       return buscar;
       
    }
    
    public static void HacerPedido(int cantPasajeros,String zona,String equipaje,boolean mascota,LocalDate fecha,LocalTime hora,Cliente cliente) throws DateInvalidException, ZoneInvalidException, LuggageInvalidException
    {
        ViajeInterface ventana=new ViajeInterface();
        ventana.setVisible(true);
        boolean disponible;
        Pedido nuevoPedido=new Pedido(fecha, hora, zona, mascota, equipaje, cantPasajeros, cliente);
        TipoDeViaje nuevoViaje=null;
        while(nuevoViaje == null)
        {
            try {
                disponible=sistema.dispVehiculo(nuevoPedido);
                nuevoViaje = FactoryViaje.getViaje(nuevoPedido,sistema.asignoChofer(),sistema.getDistancia(),sistema.asignoVehiculo(nuevoPedido));
                ventana.agregar("se asigno el chofer "+sistema.asignoChofer().getNombre());
                ventana.agregar("se asigno el vehiculo "+sistema.asignoVehiculo(nuevoPedido).getNroPatente());
                ventana.agregar("el precio a pagar es "+nuevoViaje.getCostoTotal());
                ventana.botonPagar();
                } catch (NoHayChoferDisponibleException ex) {
                    ventana.agregar("no hay chofer disponible");
                }
                  catch(NoHayVehiculoDisponibleException e){
                      ventana.agregar("no vehiculo disponible");
                  }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        sistema.setViaje(nuevoViaje);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o !=sistema)
            throw  new IllegalArgumentException();
        
        if(arg instanceof Cliente)
        {
            Cliente aux=(Cliente)arg;
            general.agregarAcciones("se agrego el cliente "+aux.getNombreDeUsuario());
        }
        if(arg instanceof Chofer)
        {
            Chofer aux=(Chofer) arg;
            general.agregarAcciones("se agrego al chofer "+aux.getNombre());
        }
        if(arg instanceof Viaje)
        {
            Viaje aux=(Viaje)arg;
            general.agregarAcciones("se agrego el viaje "+aux.toString());
        }
        if(arg instanceof Vehiculo)
        {
            Vehiculo aux=(Vehiculo)arg;
            general.agregarAcciones("se agrego el vehiculo "+aux.getNroPatente());
        }
    }
    
    
}
