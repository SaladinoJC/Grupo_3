package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class DeMano extends Equipaje {

	public DeMano(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	@Override
	public double getIncPax() {
		return this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "DeMano " + this.getTipoDeViaje().toString();
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
		DeMano deManoClon=null;
		deManoClon = (DeMano) super.clone();
		deManoClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return deManoClon;
	}
}
