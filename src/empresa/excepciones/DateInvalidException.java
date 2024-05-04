package empresa.excepciones;

import java.time.LocalDate;

/**
 * Esta excepci�n se lanza cuando se proporciona una fecha inv�lida.
 */
public class DateInvalidException extends Exception{
    protected LocalDate date;

    /**
     * Construye una nueva excepci�n con la fecha especificada.
     * 
     * @param date La fecha que caus� la excepci�n.
     */
    public DateInvalidException(LocalDate date) {
    	super(date + "Es una fecha invalida");
        this.date = date;
    }

    /**
     * Obtiene la fecha que caus� la excepci�n.
     * 
     * @return La fecha que caus� la excepci�n.
     */
    public LocalDate getDate() {
        return date;
    }
}