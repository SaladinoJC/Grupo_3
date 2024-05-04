package empresa.excepciones;

/**
 * Esta excepci�n se lanza cuando se proporciona un equipaje inv�lido.
 */
public class LuggageInvalidException  extends Exception{
    protected String luggage;

    /**
     * Construye una nueva excepci�n con el equipaje especificado.
     * 
     * @param luggage El equipaje que caus� la excepci�n.
     */
    public LuggageInvalidException(String luggage) {
    	super("Equipaje invalido");
        this.luggage = luggage;
    }

    /**
     * Obtiene el equipaje que caus� la excepci�n.
     * 
     * @return El equipaje que caus� la excepci�n.
     */
    public String getLuggage() {
        return luggage;
    }
}