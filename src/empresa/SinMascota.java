package empresa;

public class SinMascota extends Mascota {

	public SinMascota(TipoDeViaje tipo_de_viaje) {
		super(tipo_de_viaje);
	}

	@Override
	public double getIncPax() {
		return this.getTipoDeViaje().getIncPax();
	}

	@Override
	public double getIncKm() {
		return this.getTipoDeViaje().getIncKm();
	}
}
