package empresa.excepciones;

import choferes.*;

public class ChoferExistenteException extends Exception {

	public Chofer chofer;
	
	
	public ChoferExistenteException(Chofer chofer) {
		this.chofer=chofer;
	}
}
