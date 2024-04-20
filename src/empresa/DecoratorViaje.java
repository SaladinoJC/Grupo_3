package empresa;

public abstract class DecoratorViaje implements TipoDeViaje {
	protected TipoDeViaje tipoDeViaje;

	public TipoDeViaje getTipoDeViaje() {
		return tipoDeViaje;
	}

	public void setTipoDeViaje(TipoDeViaje tipoDeViaje) {
		this.tipoDeViaje = tipoDeViaje;
	}

}
