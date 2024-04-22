package vehiculos;

import empresa.Pedido;

public class Moto extends Vehiculo {

	public Moto(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		super(nroPatente, cantMaxPasajeros, petFriendly, baul);
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
	protected Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros) {
		if(!condBaul && !condMascota && condPasajeros)
			return 1000;
		else
			return null;
	}

	@Override
	public String toString() {
		return "Moto\nnroPatente: " + nroPatente + "\ncantMaxPasajeros="+ cantMaxPasajeros +"\npetFriendly: "+ petFriendly + "\nbaul: "+ baul;
	}
        
}
