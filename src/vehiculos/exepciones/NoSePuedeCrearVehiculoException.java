package vehiculos.exepciones;


/**
 * Clase de una excepción que se lanza cuando no se puede crear un vehículo con los parámetros proporcionados.
 */
public class NoSePuedeCrearVehiculoException extends Exception {
	protected String nroPatente;
	protected int cantMaxPasajeros;
	protected boolean petFriendly;
	protected boolean baul;
	
    /**
     * Constructor de la excepción.
     * 
     * @param nroPatente        El número de patente del vehículo que no se puede crear.
     * @param cantMaxPasajeros  La cantidad máxima de pasajeros del vehículo que no se puede crear.
     * @param petFriendly       Indica si el vehículo debe ser apto para mascotas o no.
     * @param baul              Indica si el vehículo debe tener baul o no.
     */
	public NoSePuedeCrearVehiculoException(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
	}

    /**
     * Obtiene el número de patente del vehículo que no se pudo crear.
     * 
     * @return El número de patente del vehículo.
     */
	public String getNroPatente() {
		return nroPatente;
	}

    /**
     * Obtiene la cantidad máxima de pasajeros del vehículo que no se pudo crear.
     * 
     * @return La cantidad máxima de pasajeros del vehículo.
     */
	public int getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}

    /**
     * Indica si el vehículo que no se pudo crear debe ser apto para mascotas o no.
     * 
     * @return true si el vehículo es apto para mascotas, false de lo contrario.
     */
	public boolean isPetFriendly() {
		return petFriendly;
	}

    /**
     * Indica si el vehículo que no se pudo crear debe tener baul o no.
     * 
     * @return true si el vehículo debe tener baul, false de lo contrario.
     */
	public boolean isBaul() {
		return baul;
	}
	
}
