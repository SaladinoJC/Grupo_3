package empresa;

/**
 * Clase abstracta que representa un decorator para viajes con mascotas.
 */
public abstract class Mascota extends DecoratorViaje {

    /**
     * Constructor de la clase Mascota.
     * 
     * @param tipo_de_viaje El tipo de viaje asociado al viaje.
     */
	public Mascota(TipoDeViaje tipo_de_viaje) {
		super.setTipoDeViaje(tipo_de_viaje);
	}

}
