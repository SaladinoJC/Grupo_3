package empresa;

public abstract class Mascota extends DecoratorViaje {

	public Mascota(TipoDeViaje tipo_de_viaje) {
		super.setTipoDeViaje(tipo_de_viaje);
	}

}
