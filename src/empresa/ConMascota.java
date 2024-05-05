	package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

/**
 * Clase que representa un viaje con mascota en el sistema.
 */
public class ConMascota extends Mascota {

    /**
     * Constructor de la clase ConMascota.
     * 
     * @param tipo_de_viaje El tipo de viaje asociado al viaje con mascota.
     */
	public ConMascota(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

    /**
     * Calcula el incremento en el costo por pasajero del viaje.
     * 
     * @return El incremento en el costo por pasajero del viaje.
     */
	@Override
	public double getIncPax() {
		return 0.1 * getPrecioBase()*getPasajeros() + getTipoDeViaje().getIncPax();
	}
	
    /**
     * Calcula el incremento en el costo por kil�metro del viaje.
     * 
     * @return El incremento en el costo por kil�metro del viaje.
     */
	@Override
	public double getIncKm() {
		return 0.2 * getPrecioBase()*getDistanciaRealRecorrida() + getTipoDeViaje().getIncKm();
	}
	
	@Override
	public String toString() {
		return "Viaje ConMascota " + this.getTipoDeViaje().toString() + "\n\n Su costo total fue: $"+ (this.getTipoDeViaje().getIncPax() + this.getTipoDeViaje().getIncKm() )+".\n\n\n";
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
     * Obtiene el costo total del viaje con mascota.
     * 
     * @return El costo total del viaje con mascota.
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
	public Object clone(){
		ConMascota conMascotaClon=null;
		conMascotaClon = (ConMascota) super.clone();
		conMascotaClon.tipoDeViaje = (TipoDeViaje) this.tipoDeViaje.clone();
		return conMascotaClon;
	}
}
