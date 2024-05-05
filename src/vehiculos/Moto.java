package vehiculos;
/**
 * Clase que representa un objeto de tipo Moto, que es un tipo de Veh�culo.
 */
public class Moto extends Vehiculo {

    /**
     * Constructor de la clase Moto.
     * 
     * @param nroPatente        El n�mero de patente de la moto.
     * @param cantMaxPasajeros  La cantidad m�xima de pasajeros que puede llevar la moto.
     * @param petFriendly       Indica si la moto es apta para mascotas o no.
     * @param baul              Indica si la moto tiene baul o no.
     */
	public Moto(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
	}
	
    /**
     * Calcula la prioridad de la moto.
     * 
     * @param condBaul       Indica si la moto tiene baul o no.
     * @param condMascota    Indica si la moto es apta para mascotas o no.
     * @param condPasajeros  Indica si la moto lleva pasajeros o no.
     * @return La prioridad calculada para la moto.
     */
	@Override
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(!condBaul && !condMascota && condPasajeros)
			return 1000;
		else
			return null;
	}

    /**
     * Devuelve una representaci�n en forma de cadena del objeto Moto.
     * 
     * @return Una cadena que representa el objeto Moto.
     */
	@Override
	public String toString() {
		return "Moto:  nroPatente: " + nroPatente + "  cantMaxPasajeros="+ cantMaxPasajeros +"  petFriendly: "+ petFriendly + "  baul: "+ baul;
	}       
}
