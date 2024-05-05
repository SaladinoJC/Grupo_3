package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

/**
 * Representa un tipo de viaje est�ndar.
 * Este tipo de viaje se caracteriza por tener un incremento de tarifa basado en la distancia recorrida y la cantidad de pasajeros.
 */
public class Estandar extends Viaje {
	
	/**
	 * Constructor de la clase Estandar.
	 * 
	 * @param pedido                 El pedido asociado.
	 * @param chofer                 El chofer asignado.
	 * @param distanciaRealRecorrida La distancia real recorrida en el viaje.
	 * @param vehiculo               El tipo de veh�culo utilizado en el viaje.
	 */
	public Estandar(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		super(pedido, chofer, distanciaRealRecorrida, vehiculo);
	}

	/**
	 * Calcula el incremento en la tarifa debido a la cantidad de pasajeros.
	 * 
	 * @return El incremento en la tarifa.
	 */
	@Override
	public double getIncPax() {
		return 0.1 * getPrecioBase() * getPasajeros()+getPrecioBase();
	}

	/**
	 * Calcula el incremento en la tarifa debido a la distancia recorrida.
	 * 
	 * @return El incremento en la tarifa por kil�metro recorrido.
	 */
	@Override
	public double getIncKm() {
		return 0.1 * getPrecioBase() * getDistanciaRealRecorrida();
	}
	
	public String toString() {
		return "en Zona Estandar [ fecha: " + getPedido().getFecha() +" fue a la hora: "+getPedido().getHora()+" la cantidad de pasajeros transportados fue: "+ getPasajeros() +".\n\nCliente: "+ this.getPedido().getCliente() +"\n\nChofer: " + getChofer() + "\n\nVehiculo: " + getVehiculo() + "\n\ndistanciaRealRecorrida=" + getDistanciaRealRecorrida() + "km ]";
	}
	
	@Override
	public Object clone(){
		Estandar estandarClon=null;
		estandarClon = (Estandar) super.clone();
		estandarClon.pedido = (Pedido) estandarClon.pedido.clone();
		return estandarClon;
	}

	/**
	 * Calcula el costo total del viaje est�ndar.
	 * 
	 * @return El costo total del viaje est�ndar.
	 */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}
}
