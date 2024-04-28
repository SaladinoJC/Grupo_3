package vehiculos;

public class Auto extends Vehiculo {

	public Auto(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
	}

	@Override
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(condPasajeros) {
			if(condBaul)
				return this.getCantMaxPasajeros() * 40;
			else
				return this.getCantMaxPasajeros() * 30;
		}
		else
			return null;
	}

	@Override
	public String toString() {
		return "Auto\nnroPatente: " + nroPatente + "\ncantMaxPasajeros="+ cantMaxPasajeros +"\npetFriendly: "+ petFriendly + "\nbaul: "+ baul;
	}
        
}
