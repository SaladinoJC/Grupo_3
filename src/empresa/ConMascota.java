package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class ConMascota extends Mascota {

	public ConMascota(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	@Override
	public double getIncPax() {
		return 1.1 * getPrecioBase()*getPasajeros() + getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.2 * getPrecioBase()*getDistanciaRealRecorrida() + getTipoDeViaje().getIncKm();
	}
	
	@Override
	public String toString() {
		return "Viaje ConMascota " + this.getTipoDeViaje().toString() + "\n\n Su costo total fue: $"+ this.getTipoDeViaje().getIncPax() + this.getTipoDeViaje().getIncKm() +".\n\n\n";
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
		ConMascota conMascotaClon=null;
		conMascotaClon = (ConMascota) super.clone();
		conMascotaClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return conMascotaClon;
	}
}
