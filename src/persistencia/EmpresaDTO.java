package persistencia;

import java.util.ArrayList;

import choferes.Chofer;
import empresa.Cliente;
import empresa.TipoDeViaje;
import vehiculos.Vehiculo;

public class EmpresaDTO {
    private ArrayList<Cliente>clientes;
    private ArrayList<Chofer>choferes;
    private ArrayList<TipoDeViaje>viajes;
    private ArrayList<Vehiculo>vehiculos;
    private int cantClientes;
    private int cantMaximaViajesPorCliente;
    private int cantChoferesDeCadaTipo;
    private int cantMaximaViajesPorChofer;
    private int cantMaximaVehiculosDeCadaTipo;
    
    
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}
	
	
	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}
	
	
	public ArrayList<TipoDeViaje> getViajes() {
		return viajes;
	}
	
	
	public void setViajes(ArrayList<TipoDeViaje> viajes) {
		this.viajes = viajes;
	}
	
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	public int getCantClientes() {
		return cantClientes;
	}
	
	
	public void setCantClientes(int cantClientes) {
		this.cantClientes = cantClientes;
	}
	
	
	public int getCantMaximaViajesPorCliente() {
		return cantMaximaViajesPorCliente;
	}
	
	
	public void setCantMaximaViajesPorCliente(int cantMaximaViajesPorCliente) {
		this.cantMaximaViajesPorCliente = cantMaximaViajesPorCliente;
	}
	
	
	public int getCantChoferesDeCadaTipo() {
		return cantChoferesDeCadaTipo;
	}
	
	
	public void setCantChoferesDeCadaTipo(int cantChoferesDeCadaTipo) {
		this.cantChoferesDeCadaTipo = cantChoferesDeCadaTipo;
	}
	
	
	public int getCantMaximaViajesPorChofer() {
		return cantMaximaViajesPorChofer;
	}
	
	
	public void setCantMaximaViajesPorChofer(int cantMaximaViajesPorChofer) {
		this.cantMaximaViajesPorChofer = cantMaximaViajesPorChofer;
	}
	
	
	public int getCantMaximaVehiculosDeCadaTipo() {
		return cantMaximaVehiculosDeCadaTipo;
	}
	
	
	public void setCantMaximaVehiculosDeCadaTipo(int cantMaximaVehiculosDeCadaTipo) {
		this.cantMaximaVehiculosDeCadaTipo = cantMaximaVehiculosDeCadaTipo;
	}
    
}
