package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class SinMascota extends Mascota {

	public SinMascota(TipoDeViaje tipo_de_viaje) {
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
		return "Viaje SinMascota " + this.getTipoDeViaje().toString() + "\n\nSu costo total fue: $"+ this.getTipoDeViaje().getIncPax() + this.getTipoDeViaje().getIncKm() +".\n\n\n";
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
		SinMascota sinMascotaClon=null;
		sinMascotaClon = (SinMascota)super.clone();
		sinMascotaClon.tipoDeViaje = (TipoDeViaje)this.tipoDeViaje.clone();
		return sinMascotaClon;
	}
	
}
