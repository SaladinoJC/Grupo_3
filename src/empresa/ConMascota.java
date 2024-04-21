package empresa;

public class ConMascota extends Mascota {

	public ConMascota(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
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