package empresa.excepciones;

/**
 * Esta excepción se lanza cuando se proporciona un equipaje inválido.
 */
public class LuggageInvalidException  extends Exception{
    protected String luggage;

    /**
     * Construye una nueva excepción con el equipaje especificado.
     * 
     * @param luggage El equipaje que causó la excepción.
     */
    public LuggageInvalidException(String luggage) {
    	super("Equipaje invalido");
        this.luggage = luggage;
    }

    /**
     * Obtiene el equipaje que causó la excepción.
     * 
     * @return El equipaje que causó la excepción.
     */
    public String getLuggage() {
        return luggage;
    }
}