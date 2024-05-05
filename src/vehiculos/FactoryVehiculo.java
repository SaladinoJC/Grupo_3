package vehiculos;

import vehiculos.exepciones.NoSePuedeCrearVehiculoException;

/**
 * Clase que presenta el factory de vehiculos
 */

public class FactoryVehiculo{
	
	/**
	 * Crea y devuelve un objeto de tipo Vehiculo seg�n los par�metros proporcionados.
	 * 
	 * @param nroPatente         El n�mero de patente del veh�culo.
	 * @param cantMaxPasajeros   La cantidad m�xima de pasajeros que puede llevar el veh�culo.
	 * @param petFriendly        Indica si el veh�culo es apto para mascotas o no.
	 * @param baul               Indica si el veh�culo tiene baul o no.
	 * @return Un objeto de tipo Vehiculo creado seg�n los par�metros.
	 * @throws NoSePuedeCrearVehiculoException si no se puede crear el veh�culo con los par�metros dados.
	 */
	public Vehiculo getVehiculo(String nroPatente, int cantMaxPasajeros, boolean petFriendly, boolean baul) throws NoSePuedeCrearVehiculoException {
		Vehiculo vehiculo=null;
		
		if(!petFriendly && !baul && (cantMaxPasajeros==1))
			vehiculo = new Moto(nroPatente, cantMaxPasajeros, petFriendly, baul);
		else
			if(!petFriendly && baul && (cantMaxPasajeros==10))
				vehiculo = new Combi(nroPatente, cantMaxPasajeros, petFriendly, baul);
			else 
				if(petFriendly && baul && (cantMaxPasajeros==4))
					vehiculo = new Auto(nroPatente, cantMaxPasajeros, petFriendly, baul);
		
		if(vehiculo==null)
			throw new NoSePuedeCrearVehiculoException(nroPatente, cantMaxPasajeros, petFriendly, baul);
		else
			return vehiculo;
	}
}
