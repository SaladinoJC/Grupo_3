package vehiculos;

import vehiculos.exepciones.NoSePuedeCrearVehiculoException;

/**
 * Clase que presenta el factory de vehiculos
 */

public class FactoryVehiculo{
	
	/**
	 * Crea y devuelve un objeto de tipo Vehiculo según los parámetros proporcionados.
	 * 
	 * @param nroPatente         El número de patente del vehículo.
	 * @param cantMaxPasajeros   La cantidad máxima de pasajeros que puede llevar el vehículo.
	 * @param petFriendly        Indica si el vehículo es apto para mascotas o no.
	 * @param baul               Indica si el vehículo tiene baul o no.
	 * @return Un objeto de tipo Vehiculo creado según los parámetros.
	 * @throws NoSePuedeCrearVehiculoException si no se puede crear el vehículo con los parámetros dados.
	 */
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
