package prueba;

import empresa.Sistema;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.ZoneInvalidException;
import empresa.excepciones.LuggageInvalidException;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;

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
        // Crear choferes
        Permanente ch1 = new Permanente(20, 30, 1, fechaEjemplo1, 0.1, "Roberto", "42231365", 300000);
        Contratado ch2 = new Contratado(1500, "Jimeno", "42231366");
        Temporario ch3 = new Temporario(10, 0.2, "Rumiante", "42231367", 200000);
        ch3.aumentarCantidadViajes(8);
        Contratado ch4 = new Contratado(10,"Sullivan", "42231368");
        //Crear clientes
        Cliente c1 = new Cliente("Cliente 1", "pass1", "Cliente Uno");
        Cliente c2 = new Cliente("Cliente 2", "pass2", "Cliente Dos"); 
        Cliente c3 = new Cliente("Cliente 3", "pass3", "Cliente Tres"); 
        Cliente c4 = new Cliente("Cliente 4", "pass4", "Cliente Cuatro");
        //Crear vehiculos
        Auto v1 = new Auto("111 AAA", 4, true, false);
        Auto v2 = new Auto("222 BBB", 3, false, true);
        Combi v3 = new Combi("333 CCC", 5, true, true);
        Combi v4 = new Combi("444 DDD", 6, false, false);
        Moto v5 = new Moto("555 EEE", 1, false, true);
        Moto v6 = new Moto("666 FFF", 1, true, true);        
        //Empresa
        Empresa E = new Empresa(); //cambie el constructor a public para poder testear
        E.insertarChofer(ch1);
        E.insertarCliente(c1);
        E.insertarCliente(c2);
        E.insertarCliente(c3);
        E.insertarCliente(c4);
        E.insertarVehiculo(v1);
        E.insertarVehiculo(v2);
        E.insertarVehiculo(v3);
        E.insertarVehiculo(v4);
        E.insertarVehiculo(v5);
        E.insertarVehiculo(v6);
        try {
        	Pedido P = new Pedido(fechaEjemplo1, timeEjemplo1, "Sin asfaltar", false, "Manual", 3, c1);
        }
        catch(DateInvalidException e1){
        	
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        }
        finally {
        	
        }
        //Debug
        System.out.println("ch1" + ch1);
        System.out.println("ch2" + ch2);
        System.out.println("ch3" + ch3);
        System.out.println("ch4" + ch4);
        System.out.println("s" + s);  
        System.out.println("c1" + c1);
        System.out.println("c2" + c2);
        System.out.println("c3" + c3);
        System.out.println("c4" + c4);
        System.out.println("v1" + v1);
        System.out.println("v2" + v2);
        System.out.println("v3" + v3);
        System.out.println("v4" + v4);
        System.out.println("v5" + v5);
        System.out.println("v6" + v6);
    }
}