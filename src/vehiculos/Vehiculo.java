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
	protected boolean disponible;
	
    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param nroPatente        El n�mero de patente del veh�culo.
     * @param cantMaxPasajeros  La cantidad m�xima de pasajeros que puede llevar el veh�culo.
     * @param petFriendly       Indica si el veh�culo es apto para mascotas o no.
     * @param baul              Indica si el veh�culo tiene baul o no.
     */
	public Vehiculo(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
		this.disponible=true;
	}
	

    /**
     * Verifica si el veh�culo puede llevar la cantidad de pasajeros requerida por un pedido.
     * 
     * @param pedido El pedido que se desea verificar.
     * @return true si el veh�culo puede llevar la cantidad de pasajeros requerida, false de lo contrario.
     */
	public boolean verificaCantPasajeros(Pedido pedido) {
		if(pedido.getCantDePasajeros() <= this.getCantMaxPasajeros())
			return true;
		else
			return false;
	}

    /**
     * Obtiene la prioridad del veh�culo para un pedido.
     * 
     * @param pedido El pedido para el que se calcula la prioridad.
     * @return La prioridad del veh�culo para el pedido.
     */
	
	public Integer getPrioridad(Pedido pedido) {
		boolean condPasajeros=this.verificaCantPasajeros(pedido);
		boolean condBaul=this.verificaUsoBaul(pedido);
		boolean condMascota=this.verificaTransporteMascota(pedido);
		return calculaPrioridad(condBaul,condMascota,condPasajeros,pedido.getCantDePasajeros());
	}
	
    /**
     * Calcula la prioridad del veh�culo para un pedido.
     * 
     * @param condBaul       Indica si el veh�culo tiene baul o no.
     * @param condMascota    Indica si el veh�culo es apto para mascotas o no.
     * @param condPasajeros  Indica si el veh�culo puede llevar la cantidad de pasajeros requerida por el pedido.
     * @return La prioridad del veh�culo para el pedido.
     */
	protected abstract Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros, int CantPasajeros);
	
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
	 * Verifica si el veh�culo puede usar el baul seg�n las condiciones del pedido.
	 * 
	 * @param pedido El pedido que se desea verificar
	 * @return true si el pedido solicita un baul y si el vehiculo tiene baul, false en caso contrario
	 */
	protected boolean verificaUsoBaul(Pedido pedido) {
		if(pedido.getEquipaje().equalsIgnoreCase("Baul") && this.baul) {
			//System.out.println("cond baul es true");
			return true;}
		else {
			//System.out.println("cond baul es false");
			return false;}
	}

    /**
     * Obtiene el n�mero de patente del veh�culo.
     * 
     * @return El n�mero de patente del veh�culo.
     */
	public String getNroPatente() {
		return nroPatente;
	}
	
    /**
     * Obtiene la cantidad m�xima de pasajeros que puede llevar el veh�culo.
     * 
     * @return La cantidad m�xima de pasajeros que puede llevar el veh�culo.
     */
	public int getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}
	
    /**
     * Verifica si el veh�culo es apto para mascotas.
     * 
     * @return true si el veh�culo es apto para mascotas, false de lo contrario.
     */
	public boolean isPetFriendly() {
		return petFriendly;
	}

    /**
     * Verifica si el veh�culo tiene baul.
     * 
     * @return true si el veh�culo tiene baul, false de lo contrario.
     */
	public boolean isBaul() {
		return baul;
	}
	
	public boolean isDisponible() {
		return this.disponible;
	}
	
	public void setDisponible(boolean disp) {
		this.disponible=disp;
	}

	 /**
     * Compara este veh�culo con otro objeto para determinar si son iguales.
     * 
     * @param obj El objeto con el que se compara este veh�culo.
     * @return true si los veh�culos son iguales, false de lo contrario.
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
