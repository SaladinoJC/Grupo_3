package empresa.excepciones;

/**
 * Esta excepción se lanza cuando se proporciona una zona inválida.
 */
public class ZoneInvalidException extends Exception{
	    protected String zone;

	    /**
	     * Construye una nueva excepción con la zona especificada.
	     * 
	     * @param zone La zona que causó la excepción.
	     */
	    public ZoneInvalidException(String zone) {
	    	super("Zona invalida");
	        this.zone = zone;
	    }

	    /**
	     * Obtiene la zona que causó la excepción.
	     * 
	     * @return La zona que causó la excepción.
	     */
	    public String getZone() {
	        return zone;
	    }
}
