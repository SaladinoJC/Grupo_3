package empresa.excepciones;

public class NoHayVehiculoDisponibleException extends Exception {
	public String mensaje;
	public NoHayVehiculoDisponibleException() {
		this.mensaje="No hay vehiculo disponible para ese viaje en el arraylist";
	}
}
