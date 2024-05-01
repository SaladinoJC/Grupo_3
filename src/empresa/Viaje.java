package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;
import empresa.FactoryViaje;


public abstract class Viaje implements TipoDeViaje{
	protected Pedido pedido;
	protected Chofer chofer;
	protected Vehiculo vehiculo;
	protected double distanciaRealRecorrida;
	private static double precioBase=1000;
        

	public Viaje(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
        this.pedido = pedido;
		this.chofer = chofer;
		if(distanciaRealRecorrida > 0)
			this.distanciaRealRecorrida = distanciaRealRecorrida;
		else
			//exception
		this.vehiculo=vehiculo;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public static void setPrecioBase(double precioBase) {
		if(precioBase > 0)
			Viaje.precioBase = precioBase;  
		else
			//exception
	}
	
	public double getPrecioBase() {
		return precioBase;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public double getDistanciaRealRecorrida() {
		return distanciaRealRecorrida;
	}

	@Override
	public int getPasajeros() {
		return this.getPedido().getCantDePasajeros();
	}
	
	@Override
	public Object clone(){
		Viaje viajeClon=null;
		try {
			viajeClon = (Viaje)super.clone();
		}
		catch (CloneNotSupportedException e) {
			//ESTE BLOQUE NO SE EJECUTA JAMAS
			e.printStackTrace();
		}
		return viajeClon;
	}
}
