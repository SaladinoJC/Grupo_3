package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

/**
 * La clase SinAsfaltar representa un tipo de viaje considerado como zona sin asfaltar.
 * Extiende la clase Viaje e implementa métodos específicos para este tipo de viaje.
 */
public class SinAsfaltar extends Viaje {

    /**
     * Constructor de la clase SinAsfaltar.
     * 
     * @param pedido                  El pedido asociado.
     * @param chofer                  El chofer asignado.
     * @param distanciaRealRecorrida  La distancia real recorrida en el viaje.
     * @param vehiculo                El vehículo utilizado en el viaje.
     */
	public SinAsfaltar(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		super(pedido,chofer,distanciaRealRecorrida,vehiculo);
	}

    /**
     * Calcula el incremento de costo por pasajero para una zona sin asfaltar.
     * 
     * @return El incremento de costo por pasajero.
     */
	@Override
	public double getIncPax() {
		return 1.2 * getPrecioBase() * getPasajeros();
	}

    /**
     * Calcula el incremento de costo por kilómetro para una zona sin asfaltar.
     * 
     * @return El incremento de costo por kilómetro.
     */
	@Override
	public double getIncKm() {
		return 1.15 * getPrecioBase() * getDistanciaRealRecorrida();
	}

	@Override
	public String toString() {
		return "en Zona SinAsfaltar [ fecha: " + getPedido().getFecha() +" fue a la hora: "+getPedido().getHora()+" la cantidad de pasajeros transportados fue: "+ getPasajeros() +".\n\nCliente: "+ this.getPedido().getCliente() +"\n\nChofer: " + getChofer() + "\n\nVehiculo: " + getVehiculo() + "\n\ndistanciaRealRecorrida=" + getDistanciaRealRecorrida() + "km ]";
	}

    /**
     * Calcula el costo total del viaje en zona sin asfaltar.
     * 
     * @return El costo total del viaje en zona sin asfaltar.
     */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}
	
	@Override
	public Object clone(){
		SinAsfaltar sinAsfaltarClon=null;
		sinAsfaltarClon = (SinAsfaltar) super.clone();
		sinAsfaltarClon.pedido = (Pedido) sinAsfaltarClon.pedido.clone();
		return sinAsfaltarClon;
	}
}
