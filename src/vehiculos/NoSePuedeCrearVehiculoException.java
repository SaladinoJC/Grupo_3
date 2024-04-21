package vehiculos;

public class NoSePuedeCrearVehiculoException extends Exception {
	protected String nroPatente;
	protected int cantMaxPasajeros;
	protected boolean petFriendly;
	protected boolean baul;
	
	public NoSePuedeCrearVehiculoException(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
	}

	public String getNroPatente() {
		return nroPatente;
	}

	public int getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}

	public boolean isPetFriendly() {
		return petFriendly;
	}

	public boolean isBaul() {
		return baul;
	}
	
}
