package dominio;

public class Camarero {
	private String nombre;
	private double propina;
	
	public Camarero(String nombre) {
		this.nombre = nombre;
		this.propina = 0.0;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPropina() {
		return propina;
	}

	public void setPropina(double propina) {
		this.propina = propina;
	}
	
	public void recibirPropina(double propina) {
		this.propina += propina;
	}

	@Override
	public String toString() {
		return "Camarero " + nombre + ", propina " + propina + "$";
	}
	
}
