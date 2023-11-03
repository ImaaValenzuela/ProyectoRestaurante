package dominio;

public class Menu {
	private String nombrePlato;
	private double precioPlato;
	private String nombreBebida;
	private double precioBebida;
	
	public Menu(String nombrePlato, double precioPlato, String nombreBebida, double precioBebida) {
		this.nombrePlato = nombrePlato;
		this.precioPlato = precioPlato;
		this.nombreBebida = nombreBebida;
		this.precioBebida = precioBebida;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public double getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		this.precioPlato = precioPlato;
	}

	public String getNombreBebida() {
		return nombreBebida;
	}

	public void setNombreBebida(String nombreBebida) {
		this.nombreBebida = nombreBebida;
	}

	public double getPrecioBebida() {
		return precioBebida;
	}

	public void setPrecioBebida(double precioBebida) {
		this.precioBebida = precioBebida;
	}

	@Override
	public String toString() {
		return "Menu [nombrePlato=" + nombrePlato + ", precioPlato=" + precioPlato + ", nombreBebida=" + nombreBebida
				+ ", precioBebida=" + precioBebida + "]";
	}
	
	
	
}
