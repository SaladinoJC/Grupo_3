/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

/**
 * Clase que representa a un administrador en el sistema.
 * @author manso
 */
public class Administrador {
    private String nombre;
    private String nombreDeUsuario;
    private String contraseña;

    /**
     * Constructor de la clase Administrador.
     * 
     * @param nombre          El nombre del administrador.
     * @param nombreDeUsuario El nombre de usuario del administrador.
     * @param contrase�a      La contrase�a del administrador.
     */
    public Administrador(String nombre, String nombreDeUsuario, String contraseña) {
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
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
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Devuelve una representaci�n en forma de cadena del objeto Administrador.
     * 
     * @return Una cadena que representa el objeto Administrador.
     */
	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + ", nombreDeUsuario=" + nombreDeUsuario + ", contraseña=" + contraseña
				+ "]";
	}
    
}
