package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class Estandar extends Viaje {
	
	public Estandar(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		super(pedido,chofer,distanciaRealRecorrida,vehiculo);
	}

	@Override
	public double getIncPax() {
		return 1.1 * getPrecioBase() * getPasajeros();
	}

	@Override
	public double getIncKm() {
		return 1.1 * getPrecioBase() * getDistanciaRealRecorrida();
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

	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}
}
