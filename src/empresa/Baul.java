package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class Baul extends Equipaje {

	public Baul(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	@Override
	public double getIncPax() {
		return 1.1 * getPrecioBase()*getPasajeros() + this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.05 * getPrecioBase()*getDistanciaRealRecorrida() + this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "Baul " + this.getTipoDeViaje().toString();
	}

	@Override
	public Chofer getChofer() {
		return this.getTipoDeViaje().getChofer();
	}

	@Override
	public Pedido getPedido() {
		return this.getTipoDeViaje().getPedido();
	}

	@Override
	public double getDistanciaRealRecorrida() {
		return this.getTipoDeViaje().getDistanciaRealRecorrida();
	}

	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}

	@Override
	public Vehiculo getVehiculo() {
		return this.getTipoDeViaje().getVehiculo();
	}

	@Override
	public double getPrecioBase() {
		return this.getTipoDeViaje().getPrecioBase();
	}

	@Override
	public int getPasajeros() {
		return this.getTipoDeViaje().getPasajeros();
	}
	
	@Override
	public Object clone(){
		Baul baulClon=null;
		baulClon = (Baul) super.clone();
		baulClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return baulClon;
	}
}
