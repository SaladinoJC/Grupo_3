package empresa;

public abstract class Zona extends DecoratorViaje {

	public Zona(TipoDeViaje tipo_de_viaje) {
		super.setTipoDeViaje(tipo_de_viaje);;
	}
	
}
