package empresa;

import vehiculos.Vehiculo;
import choferes.Chofer;

public interface TipoDeViaje extends Cloneable{
	public double getIncPax();
	public double getIncKm();
	public String toString();
	public Chofer getChofer();
	public Pedido getPedido();
	public int getPasajeros();
	public double getDistanciaRealRecorrida();
	public double getCostoTotal();
	public Vehiculo getVehiculo();
	public double getPrecioBase();
	public Object clone();
}
