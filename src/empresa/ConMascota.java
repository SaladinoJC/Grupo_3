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
	
	@Override
	public String toString() {
		return "Viaje ConMascota " + this.getTipoDeViaje().toString() + "\n\n Su costo total fue: $"+ this.getTipoDeViaje().getIncPax() + this.getTipoDeViaje().getIncKm() +".\n\n\n";
	}
}
