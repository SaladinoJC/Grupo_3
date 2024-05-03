package prueba;

import empresa.Sistema;
import java.time.LocalDate;

import choferes.Chofer;
import empresa.Administrador;
import empresa.Empresa;
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
    	// Crear una nueva instancia de Administrador (si es necesario)
        Administrador adm = new Administrador("nombre", "admin", "admin");
        LocalDate fechaEjemplo1 = LocalDate.of(2024, 5, 1);
        LocalDate fechaEjemplo2 = LocalDate.of(2022, 4, 3);
        LocalDate fechaEjemplo3 = LocalDate.of(2004, 12, 12);
        
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
        Auto v1 = new Auto(111, 4, true, false);
        Auto v2 = new Auto(222, 3, false, true);
        Combi v3 = new Combi(333, 5, true, true);
        Combi v4 = new Combi(444, 6, false, false);
        Moto v5 = new Moto(555, 1, false, true);
        Moto v6 = new Moto(666, 1, true, true);
        //Debug
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(ch4);
        System.out.println(s);  
    }
}