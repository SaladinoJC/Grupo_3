package empresa;

/**
 * Clase que representa a un administrador en el sistema.
 * @author manso
 */
public class Administrador {
    private String nombre;
    private String nombreDeUsuario;
    private String contrasenia;

    /**
     * Constructor de la clase Administrador.
     * 
     * @param nombre          El nombre del administrador.
     * @param nombreDeUsuario El nombre de usuario del administrador.
     * @param contrase�a      La contrase�a del administrador.
     */
    public Administrador(String nombre, String nombreDeUsuario, String contrasenia) {
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el nombre del administrador.
     * 
     * @return El nombre del administrador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nombre de usuario del administrador.
     * 
     * @return El nombre de usuario del administrador.
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * Obtiene la contrase�a del administrador.
     * 
     * @return La contrase�a del administrador.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Devuelve una representaci�n en forma de cadena del objeto Administrador.
     * 
     * @return Una cadena que representa el objeto Administrador.
     */
	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + ", nombreDeUsuario=" + nombreDeUsuario + ", contraseña=" + contrasenia
				+ "]";
	}
    
}
