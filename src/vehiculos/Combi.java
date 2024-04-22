package vehiculos;

import empresa.Pedido;

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
	protected boolean verificaTransporteMascota(Pedido pedido) {
		if(pedido.isMascotas())
			return true;
		else
			return false;
	}

	@Override
	protected boolean verificaUsoBaul(Pedido pedido) {
		if(pedido.getEquipaje().equalsIgnoreCase("Baul"))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Combi\nnroPatente: " + nroPatente + "\ncantMaxPasajeros="+ cantMaxPasajeros +"\npetFriendly: "+ petFriendly + "\nbaul: "+ baul;
	}
    
}
