/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import choferes.Chofer;
import empresa.Cliente;
import empresa.Empresa;
import empresa.FactoryViaje;
import empresa.Pedido;
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
    private static Sistema sistema;
    private static Empresa empresa;
    private static Controlador referencia=null;
    private static General general;
    private static ViajeInterface viajeinterface;
    private static  ChoferInterface choferinterface;
    
    private Controlador(){
       this.general=new General();
       this.general.setVisible(true);
       this.sistema=Sistema.getReferencia();
       this.empresa=Empresa.getReferencia();
       this.viajeinterface = new ViajeInterface();
       this.viajeinterface.setVisible(true);
       this.choferinterface=new ChoferInterface();
       this.choferinterface.setVisible(true);
       
        //crea un ventana general
    }
    
   public static Controlador getReferencia()
   {
       if(referencia == null) {
           referencia=new Controlador();
           sistema.addObserver(referencia);
           empresa.addObserver(referencia);
       }
       
       return referencia;
   }
    

    public static void registrarce(String nombre,String nombreUsuario,String contraseña) throws ClienteExistenteException
    {
        //registra un usuario nuevo, los dato los recibe de la interfazregistrarce por lo que estan validado
        Cliente nuevo=new Cliente(nombreUsuario, contraseña, nombre);
        sistema.insertarCliente(nuevo);//insierta el nuevo cliente
    }
    
    public static Cliente buscarCliente(String nombreUsuario,String contraseña) throws  ClienteNoExistenteExeption
    {
       //busca un cliente para poder loguiarlo en caso de que exista,si no sigue lanzando la exepcion clienteNOexisteExeption
       Cliente buscar=new Cliente(nombreUsuario, contraseña,null);
       buscar=sistema.buscarXcliente(buscar); 
       return buscar;
       
    }
    
    //realiza un pedido,a parti del pedido crea un viaje y lo informa en la ventana de viajeInterface. si no pude crear el viaje lo informa 
    public static void HacerPedido(int cantPasajeros,String zona,String equipaje,boolean mascota,LocalDate fecha,LocalTime hora,Cliente cliente) throws DateInvalidException, ZoneInvalidException, LuggageInvalidException
    {
        ViajeInterface ventana=new ViajeInterface();
        ventana.setVisible(true);
        boolean disponible;
        Pedido nuevoPedido=new Pedido(fecha, hora, zona, mascota, equipaje, cantPasajeros, cliente);
        general.agregarAcciones("el cliente "+cliente.getNombreDeUsuario()+" realizo un pedido");
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
               //   catch(NoHayVehiculoDisponibleException e){
                //      ventana.agregar("no vehiculo disponible");
             
                //  }
            if(nuevoViaje == null){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
        sistema.setViaje(nuevoViaje);
    }

    //catualiza la vista general de todo lo que pasa en la empresa, aparti de aplicar el patron observer/observable
    @Override
    public void update(Observable o, Object arg) {
    	//System.out.println("O es "+ o.hashCode() + " \n Sistema es " + sistema.hashCode());
        if(o != sistema && o!= empresa)
            throw  new IllegalArgumentException();
        String texto=(String)arg; 
        general.agregarAcciones(texto);  
    }
    
    public static void infoCliente(String texto) {
    	viajeinterface.agregar(texto);
    }
    
    public static void infoChofer(String texto) {
    	choferinterface.agregarAccion(texto);
    }
    
    public static void setearNombreChofer(String nombre)
    {
        choferinterface.agregarchofer(nombre);
    }

}
