package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

/**
 * La clase DeMano extiende de equipaje y representa un equipaje para un viaje existente.
 * Este tipo de equipaje no agrega ning�n costo adicional al viaje, simplemente es un tipo de identificaci�n.
 */
public class DeMano extends Equipaje {

	/**
	 * Constructor de la clase DeMano.
	 * 
	 * @param tipo_de_viaje El tipo de viaje al que se a�ade el equipaje de mano.
	 */
	public DeMano(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	/**
	 * Obtiene el incremento en la tarifa debido a la cantidad de pasajeros.
	 * 
	 * @return El incremento en la tarifa por pasajero.
	 */
	@Override
	public double getIncPax() {
		return this.getTipoDeViaje().getIncPax();
	}

	/**
	 * Obtiene el incremento en la tarifa debido a la distancia recorrida.
	 * 
	 * @return El incremento en la tarifa por kil�metro recorrido.
	 */
	@Override
	public double getIncKm() {
		return this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "DeMano " + this.getTipoDeViaje().toString();
	}

	/**
	 * Obtiene el chofer asociado al viaje.
	 * 
	 * @return El chofer asociado al viaje.
	 */
	@Override
	public Chofer getChofer() {
		return this.getTipoDeViaje().getChofer();
	}

	/**
	 * Obtiene el pedido asociado al viaje.
	 * 
	 * @return El pedido asociado al viaje.
	 */
	@Override
	public Pedido getPedido() {
		return this.getTipoDeViaje().getPedido();
	}

	/**
	 * Obtiene la distancia real recorrida en el viaje.
	 * 
	 * @return La distancia real recorrida en el viaje.
	 */
	@Override
	public double getDistanciaRealRecorrida() {
		return this.getTipoDeViaje().getDistanciaRealRecorrida();
	}
	
	/**
	 * Calcula el costo total del viaje con el equipaje de mano.
	 * 
	 * @return El costo total del viaje con el equipaje de mano.
	 */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}

	/**
	 * Obtiene el veh�culo asociado al viaje.
	 * 
	 * @return El veh�culo asociado al viaje.
	 */
	@Override
	public Vehiculo getVehiculo() {
		return this.getTipoDeViaje().getVehiculo();
	}

	/**
	 * Obtiene el precio base del viaje.
	 * 
	 * @return El precio base del viaje.
	 */
	@Override
	public double getPrecioBase() {
		return this.getTipoDeViaje().getPrecioBase();
	}

	/**
	 * Obtiene la cantidad de pasajeros en el viaje.
	 * 
	 * @return La cantidad de pasajeros en el viaje.
	 */
	@Override
	public int getPasajeros() {
		return this.getTipoDeViaje().getPasajeros();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		DeMano deManoClon=null;
		deManoClon = (DeMano) super.clone();
		deManoClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return deManoClon;
	}
}
