package empresa.excepciones;



public class NoHayChoferDisponibleException extends Exception {
	
	
	public String mensaje;
	public NoHayChoferDisponibleException() {
		this.mensaje="No hay chofer disponible en el arraylist";
	}
}
