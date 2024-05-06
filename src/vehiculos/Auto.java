package vehiculos;

/**
 * Clase que representa un objeto de tipo Auto, que es un tipo de Veh�culo.
 */
public class Auto extends Vehiculo {

    /**
     * Constructor de la clase Auto.
     * 
     * @param nroPatente        El n�mero de patente del auto.
     * @param cantMaxPasajeros  La cantidad m�xima de pasajeros que puede llevar el auto.
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
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros, int CantPasajeros) {
		if(condPasajeros) {
			if(condBaul)
				return CantPasajeros * 40;
			else
				return CantPasajeros * 30;
		}
		else
			return 0;
	}
	
    /**
     * Devuelve una representaci�n en forma de cadena del objeto Auto.
     * 
     * @return Una cadena que representa el objeto Auto.
     */
	@Override
	public String toString() {
		return "Auto:  nroPatente: " + nroPatente + "  cantMaxPasajeros="+ cantMaxPasajeros +"  petFriendly: "+ petFriendly + "  baul: "+ baul;
	}
        
}
