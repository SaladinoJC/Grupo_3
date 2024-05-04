package empresa.excepciones;

/**
 * Esta excepci�n se lanza cuando se proporciona una zona inv�lida.
 */
public class ZoneInvalidException extends Exception{
	    protected String zone;

	    /**
	     * Construye una nueva excepci�n con la zona especificada.
	     * 
	     * @param zone La zona que caus� la excepci�n.
	     */
	    public ZoneInvalidException(String zone) {
	    	super("Zona invalida");
	        this.zone = zone;
	    }

	    /**
	     * Obtiene la zona que caus� la excepci�n.
	     * 
	     * @return La zona que caus� la excepci�n.
	     */
	    public String getZone() {
	        return zone;
	    }
}
