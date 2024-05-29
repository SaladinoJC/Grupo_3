package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

/**
 * La clase Peligrosa representa un tipo de viaje considerado como zona peligrosa.
 * Extiende la clase Viaje e implementa m�todos espec�ficos para este tipo de viaje.
 */
public class Peligrosa extends Viaje {

	/**
     * Constructor de la clase Peligrosa.
     * 
     * @param pedido                  El pedido asociado.
     * @param chofer                  El chofer asignado.
     * @param distanciaRealRecorrida  La distancia real recorrida en el viaje.
     * @param vehiculo                El veh�culo utilizado en el viaje.
     */
	public Peligrosa(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		super(pedido,chofer,distanciaRealRecorrida,vehiculo);
	}

    /**
     * Calcula el incremento de costo por pasajero para una zona peligrosa.
     * 
     * @return El incremento de costo por pasajero.
     */
	@Override
	public double getIncPax() {
		return 0.1 * getPrecioBase() * getPasajeros()+getPrecioBase();
	}

    /**
     * Calcula el incremento de costo por kil�metro para una zona peligrosa.
     * 
     * @return El incremento de costo por kil�metro.
     */
	@Override
	public double getIncKm() {
		return 0.2 * getPrecioBase() * getDistanciaRealRecorrida();
	}
	
	@Override
	public String toString() {
		return "en Zona Peligrosa [ fecha: " + getPedido().getFecha() +" fue a la hora: "+getPedido().getHora()+" la cantidad de pasajeros transportados fue: "+ getPasajeros() +".\n\nCliente: "+ this.getPedido().getCliente() +"\n\nChofer: " + getChofer() + "\n\nVehiculo: " + getVehiculo() + "\n\ndistanciaRealRecorrida=" + getDistanciaRealRecorrida() + "km ]";
	}

    /**
     * Calcula el costo total del viaje en zona peligrosa.
     * 
     * @return El costo total del viaje en zona peligrosa.
     */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Peligrosa peligrosaClon=null;
		peligrosaClon = (Peligrosa) super.clone();
		peligrosaClon.pedido = (Pedido) peligrosaClon.pedido.clone();
		return peligrosaClon;
	}
}
