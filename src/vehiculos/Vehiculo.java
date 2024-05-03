package vehiculos;

import empresa.Pedido;
import java.util.Objects;

/**
 * Clase abstracta que representa un vehiculo generico
 */

public abstract class Vehiculo{
	protected String nroPatente;
	protected int cantMaxPasajeros;
	protected boolean petFriendly;
	protected boolean baul;
	
    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param nroPatente        El número de patente del vehículo.
     * @param cantMaxPasajeros  La cantidad máxima de pasajeros que puede llevar el vehículo.
     * @param petFriendly       Indica si el vehículo es apto para mascotas o no.
     * @param baul              Indica si el vehículo tiene baul o no.
     */
	public Vehiculo(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
	}
	

    /**
     * Verifica si el vehículo puede llevar la cantidad de pasajeros requerida por un pedido.
     * 
     * @param pedido El pedido que se desea verificar.
     * @return true si el vehículo puede llevar la cantidad de pasajeros requerida, false de lo contrario.
     */
	public boolean verificaCantPasajeros(Pedido pedido) {
		if(pedido.getCantDePasajeros() <= this.getCantMaxPasajeros())
			return true;
		else
			return false;
	}

    /**
     * Obtiene la prioridad del vehículo para un pedido.
     * 
     * @param pedido El pedido para el que se calcula la prioridad.
     * @return La prioridad del vehículo para el pedido.
     */
	
	public Integer getPrioridad(Pedido pedido) {
		boolean condPasajeros=this.verificaCantPasajeros(pedido);
		boolean condBaul=this.verificaUsoBaul(pedido);
		boolean condMascota=this.verificaTransporteMascota(pedido);
		return calculaPrioridad(condBaul,condMascota,condPasajeros);
	}
	
    /**
     * Calcula la prioridad del vehículo para un pedido.
     * 
     * @param condBaul       Indica si el vehículo tiene baul o no.
     * @param condMascota    Indica si el vehículo es apto para mascotas o no.
     * @param condPasajeros  Indica si el vehículo puede llevar la cantidad de pasajeros requerida por el pedido.
     * @return La prioridad del vehículo para el pedido.
     */
	protected abstract Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros);
	
	/**
	 * Verifica si el vehiculo acepta mascotas segun las condiciones del pedido.
	 * 
	 * @param pedido El pedido del viaje.
	 * @return true si acepta y el pedido solicita viaje con mascota, false en caso contrario.
	 */
	protected boolean verificaTransporteMascota(Pedido pedido) {
		if(pedido.isMascotas() && this.petFriendly)
			return true;
		else
			return false;
	}
	
	/**
	 * Verifica si el vehículo puede usar el baul según las condiciones del pedido.
	 * 
	 * @param pedido El pedido que se desea verificar
	 * @return true si el pedido solicita un baul y si el vehiculo tiene baul, false en caso contrario
	 */
	protected boolean verificaUsoBaul(Pedido pedido) {
		if(pedido.getEquipaje().equalsIgnoreCase("Baul") && this.baul)
			return true;
		else
			return false;
	}

    /**
     * Obtiene el número de patente del vehículo.
     * 
     * @return El número de patente del vehículo.
     */
	public String getNroPatente() {
		return nroPatente;
	}
	
    /**
     * Obtiene la cantidad máxima de pasajeros que puede llevar el vehículo.
     * 
     * @return La cantidad máxima de pasajeros que puede llevar el vehículo.
     */
	public int getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}
	
    /**
     * Verifica si el vehículo es apto para mascotas.
     * 
     * @return true si el vehículo es apto para mascotas, false de lo contrario.
     */
	public boolean isPetFriendly() {
		return petFriendly;
	}

    /**
     * Verifica si el vehículo tiene baul.
     * 
     * @return true si el vehículo tiene baul, false de lo contrario.
     */
	public boolean isBaul() {
		return baul;
	}

	 /**
     * Compara este vehículo con otro objeto para determinar si son iguales.
     * 
     * @param obj El objeto con el que se compara este vehículo.
     * @return true si los vehículos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.nroPatente, other.nroPatente);
    }

}
