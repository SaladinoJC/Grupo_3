package prueba;

import empresa.Sistema;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.ZoneInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.FactoryViaje;
import vehiculos.FactoryVehiculo;
import vehiculos.Vehiculo;
import vehiculos.exepciones.NoSePuedeCrearVehiculoException;
import vehiculos.exepciones.VehiculoExistenteException;

import java.time.LocalDate;
import java.time.LocalTime;

import choferes.Chofer;
import empresa.Administrador;
import empresa.Empresa;
import empresa.Pedido;
import empresa.Cliente;
import choferes.Contratado;
import choferes.Empleado;
import choferes.Permanente;
import choferes.Temporario;
import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.FechaMalIngresadaExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;

public class Main {
    public static void main(String[] args) throws PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption, valorPositivoExeption, FechaMalIngresadaExeption {
       	//crear una nueva instancia de Administrador (si es necesario)
        Administrador adm = new Administrador("nombre", "admin", "admin");
        LocalDate fechaEjemplo1 = LocalDate.of(2024, 5, 1);
        LocalTime timeEjemplo1 = LocalTime.of(8,45);
        //LocalDate fechaEjemplo2 = LocalDate.of(2022, 4, 3);
        //LocalDate fechaEjemplo3 = LocalDate.of(2004, 12, 12);
        // Crear una nueva instancia de Sistema
        Sistema s = new Sistema(adm);
        Empresa E = new Empresa(); //cambie el constructor a public para poder testear
        FactoryViaje factoryviaje = new FactoryViaje();
        FactoryVehiculo factoryvehiculo = new FactoryVehiculo();
        
        // Crear choferes
        Permanente ch1 = new Permanente(20, 30, 1, fechaEjemplo1, 0.1, "Roberto", "42231365", 300000);
        Contratado ch2 = new Contratado(1500, "Jimeno", "42231366");
        Temporario ch3 = new Temporario(10, 0.2, "Rumiante", "42231367", 200000);
        ch3.aumentarCantidadViajes(8);
        Contratado ch4 = new Contratado(10,"Sullivan", "42231368");
        
        //Crear clientes
        Cliente c1 = new Cliente("cliente1", "pass1", "Cliente Uno");
        Cliente c2 = new Cliente("cliente2", "pass2", "Cliente Dos"); 
        Cliente c3 = new Cliente("cliente3", "pass3", "Cliente Tres"); 
        Cliente c4 = new Cliente("cliente4", "pass4", "Cliente Cuatro");
        
        //Crear vehiculos
        
        try {
            Vehiculo v1 = factoryvehiculo.getVehiculo("111AAA", 4, true, true);
            E.insertarVehiculo(v1);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
         	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}    
        try {
        	Vehiculo v2 = factoryvehiculo.getVehiculo("222BBB", 3, true, true);
            E.insertarVehiculo(v2);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
         	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v3 = factoryvehiculo.getVehiculo("333CCC", 10, false, true);
            E.insertarVehiculo(v3);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
         	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v4 = factoryvehiculo.getVehiculo("444DDD", 10, true, true);
            E.insertarVehiculo(v4);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
         	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v5 = factoryvehiculo.getVehiculo("555EEE", 1, false, false);
            E.insertarVehiculo(v5);
            E.insertarVehiculo(v5);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
         	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v6 = factoryvehiculo.getVehiculo("666FFF", 3, false, true);
            E.insertarVehiculo(v6);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
			// TODO Auto-generated catch block
        	System.out.println("No se pudo crear el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        

        //Debug
       // System.out.println("ch1 es " + ch1);
       // System.out.println("ch2 es " + ch2);
       // System.out.println("ch3 es " + ch3);
       // System.out.println("ch4 es " + ch4);
       // System.out.println(" ");
       // System.out.println(" ");
       // System.out.println("s" + s);
       // System.out.println(" ");
      //  System.out.println(" ");
       // System.out.println("c1 es " + c1);
      //  System.out.println("c2 es " + c2);
       // System.out.println("c3 es " + c3);
      //  System.out.println("c4 es " + c4);
        
        E.insertarChofer(ch1);
        E.insertarChofer(ch2);
        E.insertarChofer(ch3);
        E.insertarChofer(ch4);
        try {
			E.insertarCliente(c1);
		} catch (ClienteExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
			E.insertarCliente(c2);
		} catch (ClienteExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
			E.insertarCliente(c3);
		} catch (ClienteExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
			E.insertarCliente(c4);
		} catch (ClienteExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
			E.insertarCliente(c4);
		} catch (ClienteExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}

        try {
        	Pedido p = new Pedido(fechaEjemplo1, timeEjemplo1, "Sin asfaltar", false, "Manual", 3, c1);
        //	try{
        	//	E.dispVehiculo(p);
        	//	Viaje v1 = factoryviaje.getViaje(p, E.asignoChofer(),  );
        	//}
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("             Listado de Choferes");
        System.out.println(E.ListarChoferes());
        System.out.println("             Listado de Vehiculos");
        System.out.println(E.ListarVehiculos());
        System.out.println("             Listado de Clientes");
        System.out.println(E.ListarClientes());
        System.out.println("             Listado de Viajes");
        System.out.println(E.ListarViajes());
        System.out.println("Total a pagar a los choferes= "+E.TotalPagar());

    }
}