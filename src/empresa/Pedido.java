package empresa;

import java.time.*;

import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.ZoneInvalidException;

/**
 * La clase Pedido representa un pedido de viaje en la empresa.
 * Contiene informaci�n sobre la fecha, hora, zona, mascotas, equipaje, cantidad de pasajeros y el cliente asociado al pedido.
 */

public class Pedido implements Cloneable{
	private LocalDate fecha;
    private LocalTime hora;
	private String zona;
	private boolean mascotas;
	private String equipaje;
	private int cantDePasajeros;

    /**
     * El cliente asociado al pedido.
     * 
     * @aggregation shared
     */
    private Cliente cliente;
	
    /**
     * Constructor de la clase Pedido.
     * 
     * @param fecha            La fecha del pedido.
     * @param hora             La hora del pedido.
     * @param zona             La zona del pedido (Estandar, Sin asfaltar, Peligrosa).
     * @param mascotas         Indica si hay mascotas en el viaje.
     * @param equipaje         El tipo de equipaje.
     * @param cantDePasajeros  La cantidad de pasajeros.
     * @param cliente          El cliente que realiza el pedido.
     * @throws TODO error en la fecha - dateInvalidException
     * @throws TODO error en la zona  - zoneInvalidException	
     * @throws TODO error en equipaje - luggageInvalideException
     * @throws TODO error en cant de pasajeros, tal vez puede ser una precondici�n
     */
	public Pedido(LocalDate fecha, LocalTime hora, String zona, boolean mascotas, String equipaje, int cantDePasajeros, Cliente cliente) throws DateInvalidException, ZoneInvalidException, LuggageInvalidException{

		if(fecha.getYear()>0)
			this.fecha = fecha;
         else
        	throw new DateInvalidException(fecha);
        	 
		this.hora = hora;
		
		if(zona.equalsIgnoreCase("Estandar") || zona.equalsIgnoreCase("Sin asfaltar") || zona.equalsIgnoreCase("Peligrosa")) 
			this.zona = zona;
		else
			throw new ZoneInvalidException(zona);
			
		this.mascotas = mascotas;
		
		if(equipaje.equalsIgnoreCase("Manual") || equipaje.equalsIgnoreCase("Baul"))
			this.equipaje = equipaje;
		else
			throw new LuggageInvalidException(equipaje);
			
		if(cantDePasajeros > 0)
			this.cantDePasajeros = cantDePasajeros;
		else {
			 //Lanza una excepci�n por cantidad de pasajeros inv�lida
		}
		this.cliente = cliente;

	}
	
    /**
     * Obtiene la fecha del pedido.
     * 
     * @return La fecha del pedido.
     */
	public LocalDate getFecha() {
		return fecha;
	}

    /**
     * Obtiene la hora del pedido.
     * 
     * @return La hora del pedido.
     */
    public LocalTime getHora() {
        return hora;
    }
      
    /**
     * Obtiene la zona del pedido.
     * 
     * @return La zona del pedido.
     */
	public String getZona() {
		return zona;
	}
	
    /**
     * Indica si hay mascotas en el viaje.
     * 
     * @return true si hay mascotas, false de lo contrario.
     */
	public boolean isMascotas() {
		return mascotas;
	}
	
    /**
     * Obtiene el tipo de equipaje del pedido.
     * 
     * @return El tipo de equipaje del pedido.
     */
	public String getEquipaje() {
		return equipaje;
	}
	
    /**
     * Obtiene la cantidad de pasajeros del pedido.
     * 
     * @return La cantidad de pasajeros del pedido.
     */
	public int getCantDePasajeros() {
		return cantDePasajeros;
	}
	
    /**
     * Obtiene el cliente asociado al pedido.
     * 
     * @return El cliente asociado al pedido.
     */
	public Cliente getCliente() {
		return cliente;
	}

    @Override
    public String toString() {
        return "Pedido {" + "\nfecha: " + fecha +"\nfue a la hora: "+hora+ "\nzona: " + zona + "\nmascotas: " + mascotas + "\nequipaje: " + equipaje + "\ncantDePasajeros: " + cantDePasajeros + "\ncliente " + this.cliente +" }";
    }

	@Override
	public Object clone(){
		Object pedidoClon=null;
		try {
			pedidoClon = super.clone();
		}
		catch (CloneNotSupportedException e) {
			//ESTE BLOQUE NO SE EJECUTA JAMAS
			e.printStackTrace();
		}
		return pedidoClon;
	}
	
}
