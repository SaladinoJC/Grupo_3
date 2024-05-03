package vehiculos;

/**
 * Clase que representa un objeto de tipo Auto, que es un tipo de Vehículo.
 */
public class Auto extends Vehiculo {

    /**
     * Constructor de la clase Auto.
     * 
     * @param nroPatente        El número de patente del auto.
     * @param cantMaxPasajeros  La cantidad máxima de pasajeros que puede llevar el auto.
     * @param petFriendly       Indica si el auto es apto para mascotas o no.
     * @param baul              Indica si el auto tiene baul o no.
     */
	public Auto(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
	}

    /**
     * Calcula la prioridad del auto.
     * 
     * @param condBaul       Indica si el auto tiene baul o no.
     * @param condMascota    Indica si el auto es apto para mascotas o no.
     * @param condPasajeros  Indica si el auto lleva pasajeros o no.
     * @return La prioridad calculada para el auto.
     */
	@Override
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(condPasajeros) {
			if(condBaul)
				return this.getCantMaxPasajeros() * 40;
			else
				return this.getCantMaxPasajeros() * 30;
		}
		else
			return null;
	}
	
    /**
     * Devuelve una representación en forma de cadena del objeto Auto.
     * 
     * @return Una cadena que representa el objeto Auto.
     */
	@Override
	public String toString() {
		return "Auto\nnroPatente: " + nroPatente + "\ncantMaxPasajeros="+ cantMaxPasajeros +"\npetFriendly: "+ petFriendly + "\nbaul: "+ baul;
	}
        
}
