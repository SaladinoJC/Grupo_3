package empresa.excepciones;

import empresa.Cliente;

public class ClienteExistenteException extends Exception {
public Cliente cliente;
	
	
	public ClienteExistenteException(Cliente cliente) {
		this.cliente=cliente;
	}
	
}

