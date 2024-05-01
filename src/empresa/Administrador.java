/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

/**
 *
 * @author manso
 */
public class Administrador {
    private String nombre;
    private String nombreDeUsuario;
    private String contraseña;

    public Administrador(String nombre, String nombreDeUsuario, String contraseña) {
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + ", nombreDeUsuario=" + nombreDeUsuario + ", contraseña=" + contraseña
				+ "]";
	}
    
    
    
}
