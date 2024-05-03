package empresa;

import java.util.Objects;

/**
 * Clase que representa a un cliente en el sistema.
 */
public class Cliente {
	private String nombreDeUsuario;
	private String contrasena;
	private String nombreReal;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombreDeUsuario El nombre de usuario del cliente.
     * @param contrasena      La contraseña del cliente.
     * @param nombreReal      El nombre real del cliente.
     */
    public Cliente(String nombreDeUsuario, String contrasena, String nombreReal) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
        this.nombreReal = nombreReal;
    }
	
    /**
     * Obtiene el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	
    /**
     * Establece el nombre de usuario del cliente.
     * 
     * @param nombreDeUsuario El nuevo nombre de usuario del cliente.
     */
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	
    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
	public String getContrasena() {
		return contrasena;
	}
	
    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasena La nueva contraseña del cliente.
     */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
    /**
     * Obtiene el nombre real del cliente.
     * 
     * @return El nombre real del cliente.
     */
	public String getNombreReal() {
		return nombreReal;
	}

    /**
     * Comprueba si un objeto es igual al cliente.
     * 
     * @param obj El objeto a comparar con el cliente.
     * @return true si el objeto es igual al cliente, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombreDeUsuario, other.nombreDeUsuario)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

    @Override
    public String toString() {
        return "Ciente nombre real:"+this.nombreReal+"\nnombre de usuario:"+this.nombreDeUsuario
         +"\ncontraseÃ±a:"+this.contrasena;
    }   
}