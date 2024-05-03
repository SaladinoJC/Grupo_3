package vehiculos.exepciones;


/**
 * Clase de una excepci�n que se lanza cuando no se puede crear un veh�culo con los par�metros proporcionados.
 */
public class NoSePuedeCrearVehiculoException extends Exception {
	protected String nroPatente;
	protected int cantMaxPasajeros;
	protected boolean petFriendly;
	protected boolean baul;
	
    /**
     * Constructor de la excepci�n.
     * 
     * @param nroPatente        El n�mero de patente del veh�culo que no se puede crear.
     * @param cantMaxPasajeros  La cantidad m�xima de pasajeros del veh�culo que no se puede crear.
     * @param petFriendly       Indica si el veh�culo debe ser apto para mascotas o no.
     * @param baul              Indica si el veh�culo debe tener baul o no.
     */
	public NoSePuedeCrearVehiculoException(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
	}

    /**
     * Obtiene el n�mero de patente del veh�culo que no se pudo crear.
     * 
     * @return El n�mero de patente del veh�culo.
     */
	public String getNroPatente() {
		return nroPatente;
	}

    /**
     * Obtiene la cantidad m�xima de pasajeros del veh�culo que no se pudo crear.
     * 
     * @return La cantidad m�xima de pasajeros del veh�culo.
     */
	public int getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}

    /**
     * Indica si el veh�culo que no se pudo crear debe ser apto para mascotas o no.
     * 
     * @return true si el veh�culo es apto para mascotas, false de lo contrario.
     */
	public boolean isPetFriendly() {
		return petFriendly;
	}

    /**
     * Indica si el veh�culo que no se pudo crear debe tener baul o no.
     * 
     * @return true si el veh�culo debe tener baul, false de lo contrario.
     */
	public boolean isBaul() {
		return baul;
	}
	
}
