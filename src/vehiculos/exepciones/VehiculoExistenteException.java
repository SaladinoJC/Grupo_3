package vehiculos.exepciones;

import vehiculos.Vehiculo;

/**
 * Clase de una excepci�n que se lanza cuando no se puede aniadir un vehiculo al arraylist ya que ya esta en el arraylist.
 */
public class VehiculoExistenteException extends Exception {
	public Vehiculo vehiculo;
	
	
	public VehiculoExistenteException(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
	}
	
}
