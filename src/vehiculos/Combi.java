package vehiculos;

/**
 * Clase que representa un objeto de tipo Combi, que es un tipo de Veh�culo.
 */
public class Combi extends Vehiculo {

    /**
     * Constructor de la clase Combi.
     * 
     * @param nroPatente        El n�mero de patente de la combi.
     * @param cantMaxPasajeros  La cantidad m�xima de pasajeros que puede llevar la combi.
     * @param petFriendly       Indica si la combi es apta para mascotas o no.
     * @param baul              Indica si la combi tiene baul o no.
     */
	public Combi(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
	}
	
    /**
     * Calcula la prioridad de la combi.
     * 
     * @param condBaul       Indica si la combi tiene baul o no.
     * @param condMascota    Indica si la combi es apta para mascotas o no.
     * @param condPasajeros  Indica si la combi lleva pasajeros o no.
     * @return La prioridad calculada para la combi.
     */
	@Override
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(!condMascota && condPasajeros) {
			if(condBaul)
				return 100 + this.getCantMaxPasajeros() * 10;
			else
				return this.getCantMaxPasajeros() * 10;
		}
		else
			return null;
	}

    /**
     * Devuelve una representaci�n en forma de cadena del objeto Combi.
     * 
     * @return Una cadena que representa el objeto Combi.
     */
	@Override
	public String toString() {
		return "Combi:  nroPatente: " + nroPatente + "  cantMaxPasajeros="+ cantMaxPasajeros +"  petFriendly: "+ petFriendly + "  baul: "+ baul;
	}
}
