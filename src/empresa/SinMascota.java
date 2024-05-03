package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;


/**
 * La clase SinMascota representa un tipo de viaje sin mascotas.
 * Extiende la clase Mascota e implementa métodos específicos para este tipo de viaje.
 */
public class SinMascota extends Mascota {

    /**
     * Constructor de la clase SinMascota.
     * 
     * @param tipo_de_viaje El tipo de viaje que no transporta mascota.
     */
	public SinMascota(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	 /**
     * Obtiene el incremento de costo por pasajero para un viaje sin mascotas. (no aumenta)
     * 
     * @return El incremento de costo por pasajero.
     */
	@Override
	public double getIncPax() {
		return this.getTipoDeViaje().getIncPax();
	}
	
    /**
     * Obtiene el incremento de costo por kilómetro para un viaje sin mascotas. (no aumenta)
     * 
     * @return El incremento de costo por kilómetro.
     */
	@Override
	public double getIncKm() {
		return this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "Viaje SinMascota " + this.getTipoDeViaje().toString() + "\n\nSu costo total fue: $"+ this.getTipoDeViaje().getIncPax() + this.getTipoDeViaje().getIncKm() +".\n\n\n";
	}

    /**
     * Obtiene el chofer asociado al viaje sin mascotas.
     * 
     * @return El chofer asociado al viaje sin mascotas.
     */
	@Override
	public Chofer getChofer() {
		return this.getTipoDeViaje().getChofer();
	}


    /**
     * Obtiene el pedido asociado al viaje sin mascotas.
     * 
     * @return El pedido asociado al viaje sin mascotas.
     */
	@Override
	public Pedido getPedido() {
		return this.getTipoDeViaje().getPedido();
	}

    /**
     * Obtiene la distancia real recorrida en el viaje sin mascotas.
     * 
     * @return La distancia real recorrida en el viaje sin mascotas.
     */
	@Override
	public double getDistanciaRealRecorrida() {
		return this.getTipoDeViaje().getDistanciaRealRecorrida();
	}

    /**
     * Calcula el costo total del viaje sin mascotas.
     * 
     * @return El costo total del viaje sin mascotas.
     */
	@Override
	public double getCostoTotal() {
		return getPrecioBase() + this.getIncKm() + this.getIncPax();
	}

    /**
     * Obtiene el vehículo asociado al viaje sin mascotas.
     * 
     * @return El vehículo asociado al viaje sin mascotas.
     */
	@Override
	public Vehiculo getVehiculo() {
		return this.getTipoDeViaje().getVehiculo();
	}

    /**
     * Obtiene el precio base del viaje sin mascotas.
     * 
     * @return El precio base del viaje sin mascotas.
     */
	@Override
	public double getPrecioBase() {
		return this.getTipoDeViaje().getPrecioBase();
	}

    /**
     * Obtiene la cantidad de pasajeros del viaje sin mascotas.
     * 
     * @return La cantidad de pasajeros del viaje sin mascotas.
     */
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
