package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;
import empresa.FactoryViaje;

/**
 * La clase abstracta Viaje representa un tipo gen�rico de viaje.
 * Implementa la interfaz TipoDeViaje y proporciona m�todos comunes para los diferentes tipos de viaje.
 */

public abstract class Viaje implements TipoDeViaje{
   
	/**
     * El pedido asociado al viaje.
     * @aggregation composite
     */
    protected Pedido pedido;

    /**
     * El chofer asignado al viaje.
     * @aggregation shared
     */
    protected Chofer chofer;

    /**
     * El veh�culo utilizado en el viaje.
     * @aggregation shared
     */
    protected Vehiculo vehiculo;
    /**
     * La distancia real recorrida en el viaje.
     */
	protected double distanciaRealRecorrida;
    /**
     * El precio base del viaje.
     */
	private static double precioBase=1000;
        
    /**
     * Constructor de la clase Viaje.
     * 
     * @param pedido                  El pedido asociado al viaje.
     * @param chofer                  El chofer asignado al viaje.
     * @param distanciaRealRecorrida  La distancia real recorrida en el viaje.
     * @param vehiculo                El veh�culo utilizado en el viaje.
     * @throws TODO Lanza excepcion en caos de que la distanciaRealRecorrida sea menor a 0, puede ser una precondici�n
     */
	public Viaje(Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
        this.pedido = pedido;
		this.chofer = chofer;
		if(distanciaRealRecorrida > 0)
			this.distanciaRealRecorrida = distanciaRealRecorrida;
		else
			System.out.println("roberto");//exception
		this.vehiculo=vehiculo;
	}
	
    /**
     * Obtiene el veh�culo utilizado en el viaje.
     * 
     * @return El veh�culo del viaje.
     */
	public Vehiculo getVehiculo() {
		
		return vehiculo;
	}

    /**
     * Establece el precio base del viaje.
     * 
     * @param precioBase El nuevo precio base del viaje.
     * @throws TODO Lanza excepcion en caso de que el precio base sea menor a 0, podria ser una precondici�n.
     */
	public static void setPrecioBase(double precioBase) {
		if(precioBase > 0)
			Viaje.precioBase = precioBase;  
		else
			System.out.println("roberto");
			//exception
	}
	
    /**
     * Obtiene el precio base del viaje.
     * 
     * @return El precio base del viaje.
     */
	public double getPrecioBase() {
		return precioBase;
	}

    /**
     * Obtiene el pedido asociado al viaje.
     * 
     * @return El pedido del viaje.
     */
	public Pedido getPedido() {
		return pedido;
	}

    /**
     * Obtiene el chofer asignado al viaje.
     * 
     * @return El chofer del viaje.
     */
	public Chofer getChofer() {
		return chofer;
	}

    /**
     * Obtiene la distancia real recorrida en el viaje.
     * 
     * @return La distancia real recorrida en el viaje.
     */
	public double getDistanciaRealRecorrida() {
		return distanciaRealRecorrida;
	}


    /**
     * Obtiene la cantidad de pasajeros del viaje.
     * 
     * @return El n�mero de pasajeros del viaje.
     */
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
