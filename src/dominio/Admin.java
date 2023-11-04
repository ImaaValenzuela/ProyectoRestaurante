package dominio;

public class Admin {
// Usuario 
// Contraseña
// Recuento de las ventas 
// Crear platos	
	private String usuario;
	private String contrasenia;

	public Admin(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Admin [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

}
