package empresa;

import vehiculos.Vehiculo;
import choferes.Chofer;

/**
 * La interfaz TipoDeViaje define m�todos para obtener informaci�n sobre un viaje.
 * Estos m�todos deben ser implementados por las clases que implementen TipoDeViaje.
 */
public interface TipoDeViaje extends Cloneable{
    /**
     * Obtiene el incremento en el costo del viaje debido al n�mero de pasajeros.
     * 
     * @return El incremento en el costo del viaje por pasajero.
     */
	public double getIncPax();
	
	/**
     * Obtiene el incremento en el costo del viaje debido a la distancia recorrida.
     * 
     * @return El incremento en el costo del viaje por kil�metro recorrido.
     */
	public double getIncKm();
	
    /**
     * Obtiene el chofer asociado al viaje.
     * 
     * @return El chofer del viaje.
     */
	public Chofer getChofer();
	
    /**
     * Obtiene el pedido asociado al viaje.
     * 
     * @return El pedido del viaje.
     */
	public Pedido getPedido();
	
    /**
     * Obtiene la cantidad de pasajeros del viaje.
     * 
     * @return El n�mero de pasajeros del viaje.
     */
	public int getPasajeros();
	
	 /**
     * Obtiene la distancia real recorrida en el viaje.
     * 
     * @return La distancia real recorrida en el viaje.
     */
	public double getDistanciaRealRecorrida();
	
    /**
     * Obtiene el costo total del viaje, incluyendo todos los incrementos.
     * 
     * @return El costo total del viaje.
     */
	public double getCostoTotal();
	

    /**
     * Obtiene el veh�culo utilizado en el viaje.
     * 
     * @return El veh�culo del viaje.
     */
	public Vehiculo getVehiculo();
	

    /**
     * Obtiene el precio base del viaje.
     * 
     * @return El precio base del viaje.
     */
	public double getPrecioBase();
	public Object clone() throws CloneNotSupportedException;
	public String toString();
}
