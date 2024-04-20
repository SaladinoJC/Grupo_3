package empresa;

public class DeMano extends Equipaje {

	public DeMano(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	@Override
	public double getIncPax() {
		return 1.1 * this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return 1.05 * this.getTipoDeViaje().getIncKm();
	}
}
