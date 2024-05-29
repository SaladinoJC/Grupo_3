package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;


/**
 * Clase que representa el equipaje de tipo Baul.
 */
public class Baul extends Equipaje {

    /**
     * Constructor de la clase Baul.
     * 
     * @param tipo_de_viaje El tipo de viaje asociado al equipaje.
     */
	public Baul(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

    /**
     * Calcula el incremento en el costo por pasajero del equipaje Baul.
     * 
     * @return El incremento en el costo por pasajero del equipaje Baul.
     */
	@Override
	public double getIncPax() {
		return 0.1 * getPrecioBase()*getPasajeros() + this.getTipoDeViaje().getIncPax();
	}

    /**
     * Calcula el incremento en el costo por kil�metro del equipaje Baul.
     * 
     * @return El incremento en el costo por kil�metro del equipaje Baul.
     */
	@Override
	public double getIncKm() {
		return 0.05 * getPrecioBase()*getDistanciaRealRecorrida() + this.getTipoDeViaje().getIncKm();
	}

    /**
     * Devuelve una representaci�n en forma de cadena del objeto Baul.
     * 
     * @return Una cadena que representa el objeto Baul.
     */
	@Override
	public String toString() {
		return "Baul " + this.getTipoDeViaje().toString();
	}

    /**
     * Obtiene el chofer asociado al tipo de viaje.
     * 
     * @return El chofer asociado al tipo de viaje.
     */
	@Override
	public Chofer getChofer() {
		return this.getTipoDeViaje().getChofer();
	}

    /**
     * Obtiene el pedido asociado al tipo de viaje.
     * 
     * @return El pedido asociado al tipo de viaje.
     */
	@Override
	public Pedido getPedido() {
		return this.getTipoDeViaje().getPedido();
	}

    /**
     * Obtiene la distancia real recorrida del tipo de viaje.
     * 
     * @return La distancia real recorrida del tipo de viaje.
     */
	@Override
	public double getDistanciaRealRecorrida() {
		return this.getTipoDeViaje().getDistanciaRealRecorrida();
	}

    /**
     * Obtiene el costo total del viaje.
     * 
     * @return El costo total del viaje.
     */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}

    /**
     * Obtiene el veh�culo asociado al tipo de viaje.
     * 
     * @return El veh�culo asociado al tipo de viaje.
     */
	@Override
	public Vehiculo getVehiculo() {
		return this.getTipoDeViaje().getVehiculo();
	}

    /**
     * Obtiene el precio base del tipo de viaje.
     * 
     * @return El precio base del tipo de viaje.
     */
	@Override
	public double getPrecioBase() {
		return this.getTipoDeViaje().getPrecioBase();
	}

    /**
     * Obtiene la cantidad de pasajeros asociada al tipo de viaje.
     * 
     * @return La cantidad de pasajeros asociada al tipo de viaje.
     */
	@Override
	public int getPasajeros() {
		return this.getTipoDeViaje().getPasajeros();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Baul baulClon=null;
		baulClon = (Baul) super.clone();
		baulClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return baulClon;
	}
}
