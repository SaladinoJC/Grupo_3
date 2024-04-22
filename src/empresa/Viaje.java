package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class Viaje implements TipoDeViaje,Comparable<Viaje> {
	private Pedido pedido;
	private Chofer chofer;
	private Vehiculo vehiculo;
	private double distanciaRealRecorrida;
	private static double precioBase;

	public Viaje(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, double precioBase) {
		this.pedido = pedido;
		this.chofer = chofer;
		this.distanciaRealRecorrida = distanciaRealRecorrida;
		Viaje.precioBase = precioBase;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public static void setPrecioBase(double precioBase) {
		Viaje.precioBase = precioBase;
	}
	
	public static double getPrecioBase() {
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
	public double getIncPax() {
		return this.getPedido().getCantDePasajeros() * getPrecioBase();
	}

	@Override
	public double getIncKm() {
		return this.getDistanciaRealRecorrida() * getPrecioBase();
	}

    @Override
    public String toString() {
        return "Viaje{" + "pedido=" + pedido + ", chofer=" + chofer + ", vehiculo=" + vehiculo + ", distanciaRealRecorrida=" + distanciaRealRecorrida + '}';
    }
    
    //implementa compareTO para poder compara viajes por costos
    @Override
    public int compareTo(Viaje otro) {
       double costo1,costo2;
       costo1=this.getIncKm()+this.getIncPax();//almaceno los costos de los viajes a comparar
       costo2=otro.getIncKm()+otro.getIncPax();
       if(costo1>costo2)
           return -1;
       else
           if(costo1<costo2)
               return 1;
           else
               return 0;
    }

        
}
