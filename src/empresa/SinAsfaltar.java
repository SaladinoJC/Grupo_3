package empresa;

public class SinAsfaltar extends Zona {

	public SinAsfaltar(TipoDeViaje tipoDeViaje) {
		super(tipoDeViaje);
	}

	@Override
	public double getIncPax() {
		return 1.2 * this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.15 * this.getTipoDeViaje().getIncKm();
	}

	@Override
	public String toString() {
		return "en Zona SinAsfaltar " + this.getTipoDeViaje().toString();
	}
	
}
