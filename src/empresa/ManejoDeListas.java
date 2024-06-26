/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package empresa;

import choferes.Chofer;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import empresa.excepciones.ChoferExistenteException;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import persistencia.ParametrosIniciales;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import vehiculos.Vehiculo;
import vehiculos.exepciones.VehiculoExistenteException;

/**
 *
 * @author manso
 */
public interface ManejoDeListas {
    public void insertarChofer(Chofer chofer) throws ChoferExistenteException;
    public boolean buscarChofer(Chofer chofer);
    public Chofer buscarXchofer(Chofer chofer);
    public Chofer getChofer(int index);
    public String ListarChoferes() throws SueldoBasicoIncorrectoExeption;
    public String ListarViajesXchofer(Chofer chofer,LocalDate inicio,LocalDate fin);
    public Vehiculo getVehiculo(int index);
    public String ListarVehiculos();
    public boolean buscarVehiculo(Vehiculo vehiculo);
    public Vehiculo buscarXVehiculo(Vehiculo vehiculo);
    public void insertarVehiculo(Vehiculo vehiculo) throws VehiculoExistenteException;
    public Cliente getCliente(int index);
    public String ListarClientes();
    public  boolean buscarCliente(Cliente cliente);
    public Cliente buscarXcliente (Cliente cliente) throws ClienteNoExistenteExeption;
    public String ListarViajesXcliente(Cliente cliente,LocalDate inicio,LocalDate fin) throws ClienteNoExistenteExeption;
    public void insertarCliente(Cliente cliente) throws ClienteExistenteException;
    public TipoDeViaje getViaje(int index);
    public void setViaje(TipoDeViaje viaje);
    public void setiarSueldoContratados() throws SueldoBasicoIncorrectoExeption;
    public void setiarCantidadViajesTemporarios();
    public void calculoDePuntaje();
    public double TotalPagar() throws SueldoBasicoIncorrectoExeption;
    public Chofer asignoChofer() throws NoHayChoferDisponibleException;
    public boolean dispVehiculo(Pedido p) /*throws NoHayVehiculoDisponibleException*/;
    public double getDistancia();
    public Vehiculo asignoVehiculo(Pedido p);
	public void mueveChofer();
	public ArrayList<Cliente> getClientes();
	public void setClientes(ArrayList<Cliente> clientes);
	public ArrayList<Chofer> getChoferes();
	public void setChoferes(ArrayList<Chofer> choferes);
	public ArrayList<TipoDeViaje> getViajes();
	public void setViajes(ArrayList<TipoDeViaje> viajes);
	public ArrayList<Vehiculo> getVehiculos();
	public void setVehiculos(ArrayList<Vehiculo> vehiculos);
	public void persistirInformacion(int cantClientes, int cantMaximaViajesPorCliente, int cantChoferesDeCadaTipo, int cantMaximaViajesPorChofer, int cantMaximaVehiculosDeCadaTipo) throws IOException;
	public ParametrosIniciales despersistirInformacion() throws IOException, ClassNotFoundException;
	public void solicitaviaje(Pedido p, Cliente c) throws NoHayChoferDisponibleException;
	public void pagaviaje(Cliente c);
	
}

