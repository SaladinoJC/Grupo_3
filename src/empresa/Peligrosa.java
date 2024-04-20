package empresa;

public class Peligrosa extends Zona {

	public Peligrosa(TipoDeViaje tipoDeViaje) {
		super(tipoDeViaje);
	}

	@Override
	public double getIncPax() {
		return 1.1 * this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.2 * this.getTipoDeViaje().getIncKm();
	}
}
