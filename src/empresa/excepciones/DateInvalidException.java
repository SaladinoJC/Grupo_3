package empresa.excepciones;

import java.time.LocalDate;

/**
 * Esta excepción se lanza cuando se proporciona una fecha inválida.
 */
public class DateInvalidException extends Exception{
    protected LocalDate date;

    /**
     * Construye una nueva excepción con la fecha especificada.
     * 
     * @param date La fecha que causó la excepción.
     */
    public DateInvalidException(LocalDate date) {
    	super(date + "Es una fecha invalida");
        this.date = date;
    }

    /**
     * Obtiene la fecha que causó la excepción.
     * 
     * @return La fecha que causó la excepción.
     */
    public LocalDate getDate() {
        return date;
    }
}