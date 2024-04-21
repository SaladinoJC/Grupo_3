package vehiculos;

import empresa.Pedido;

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
        return "Auto{" + '}';
    }
        
}
