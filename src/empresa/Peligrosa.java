package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class Peligrosa extends Viaje {

	public Peligrosa(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		super(pedido,chofer,distanciaRealRecorrida,vehiculo);
	}

	@Override
	public double getIncPax() {
		return 1.1 * getPrecioBase() * getPasajeros();
	}

	@Override
	public double getIncKm() {
		return 1.2 * getPrecioBase() * getDistanciaRealRecorrida();
	}
	
	@Override
	public String toString() {
		return "en Zona Peligrosa [ fecha: " + getPedido().getFecha() +" fue a la hora: "+getPedido().getHora()+" la cantidad de pasajeros transportados fue: "+ getPasajeros() +".\n\nCliente: "+ this.getPedido().getCliente() +"\n\nChofer: " + getChofer() + "\n\nVehiculo: " + getVehiculo() + "\n\ndistanciaRealRecorrida=" + getDistanciaRealRecorrida() + "km ]";
	}

	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}
	
	@Override
	public Object clone(){
		Peligrosa peligrosaClon=null;
		peligrosaClon = (Peligrosa) super.clone();
		peligrosaClon.pedido = (Pedido) peligrosaClon.pedido.clone();
		return peligrosaClon;
	}
}
