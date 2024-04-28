package vehiculos;

public class Combi extends Vehiculo {

	public Combi(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
	}

	@Override
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(!condMascota && condPasajeros) {
			if(condBaul)
				return 100 + this.getCantMaxPasajeros() * 10;
			else
				return this.getCantMaxPasajeros() * 10;
		}
		else
			return null;
	}

	@Override
	public String toString() {
		return "Combi\nnroPatente: " + nroPatente + "\ncantMaxPasajeros="+ cantMaxPasajeros +"\npetFriendly: "+ petFriendly + "\nbaul: "+ baul;
	}
    
}
