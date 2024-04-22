package empresa;

public class Estandar extends Zona {
	
	public Estandar(TipoDeViaje tipoDeViaje) {
		super(tipoDeViaje);
	}

	@Override
	public double getIncPax() {
		return 1.1 * this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.1 * this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "en Zona Estandar " + this.getTipoDeViaje().toString();
	}
	
}
