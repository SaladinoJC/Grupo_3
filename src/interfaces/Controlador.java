/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import empresa.Cliente;
import empresa.Pedido;
import empresa.Sistema;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.ZoneInvalidException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author manso
 */
public class Controlador {
    private static Sistema sistema=Sistema.getReferencia();

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
        Pedido nuevo=new Pedido(fecha, hora, zona, mascota, equipaje, cantPasajeros, cliente);
    }
    
}
