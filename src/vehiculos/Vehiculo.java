package vehiculos;

import empresa.Pedido;
import java.util.Objects;

public abstract class Vehiculo {
	protected String nroPatente;
	protected int cantMaxPasajeros;
	protected boolean petFriendly;
	protected boolean baul;
	
	public Vehiculo(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) {
		this.nroPatente = nroPatente;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.petFriendly = petFriendly;
		this.baul = baul;
	}
	
	public boolean verificaCantPasajeros(Pedido pedido) {
		if(pedido.getCantDePasajeros() <= this.getCantMaxPasajeros())
			return true;
		else
			return false;
	}
	
	public Integer getPrioridad(Pedido pedido) {
		boolean condPasajeros=this.verificaCantPasajeros(pedido);
		boolean condBaul=this.verificaUsoBaul(pedido);
		boolean condMascota=this.verificaTransporteMascota(pedido);
		return calculaPrioridad(condBaul,condMascota,condPasajeros);
	}
	
	protected abstract Integer calculaPrioridad(boolean condBaul, boolean condMascota, boolean condPasajeros);

	protected abstract boolean verificaTransporteMascota(Pedido pedido);

	protected abstract boolean verificaUsoBaul(Pedido pedido);

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.nroPatente, other.nroPatente);
    }

    @Override
    public  abstract String toString();

}
