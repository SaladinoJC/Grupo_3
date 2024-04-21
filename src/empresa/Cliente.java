package empresa;

import java.util.Objects;

public class Cliente {
	private String nombreDeUsuario;
	private String contrasena;
	private String nombreReal;

    public Cliente(String nombreDeUsuario, String contrasena, String nombreReal) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
        this.nombreReal = nombreReal;
    }
        
        
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombreReal() {
		return nombreReal;
	}


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
         +"\ncontraseña:"+this.contrasena;
    }
    
        
        
}