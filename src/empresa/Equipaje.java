package empresa  ;

public abstract class Equipaje extends DecoratorViaje {

	public Equipaje(TipoDeViaje tipo_de_viaje) {
		super.setTipoDeViaje(tipo_de_viaje);
	}

}
