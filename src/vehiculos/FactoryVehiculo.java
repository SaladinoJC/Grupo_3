package vehiculos;

import vehiculos.exepciones.NoSePuedeCrearVehiculoException;

public class FactoryVehiculo{
	
	public Vehiculo getVehiculo(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) throws NoSePuedeCrearVehiculoException {
		Vehiculo vehiculo=null;
		
		if(!petFriendly && !baul)
			vehiculo = new Moto(nroPatente, cantMaxPasajeros, petFriendly, baul);
		else
			if(!petFriendly && baul)
				vehiculo = new Combi(nroPatente, cantMaxPasajeros, petFriendly, baul);
			else 
				if(petFriendly && baul)
					vehiculo = new Auto(nroPatente, cantMaxPasajeros, petFriendly, baul);
		
		if(vehiculo==null)
			throw new NoSePuedeCrearVehiculoException(nroPatente, cantMaxPasajeros, petFriendly, baul);
		else
			return vehiculo;
	}
}
