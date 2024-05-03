package empresa;

/**
 * La clase abstracta Equipaje extiende a DecoratorViaje y representa un tipo de viaje decorado con equipaje.
 */
public abstract class Equipaje extends DecoratorViaje {

    /**
     * Constructor de la clase Equipaje.
     * 
     * @param tipo_de_viaje El tipo de viaje al que se le agrega equipaje.
     */
	public Equipaje(TipoDeViaje tipo_de_viaje) {
		super.setTipoDeViaje(tipo_de_viaje);
	}

}
