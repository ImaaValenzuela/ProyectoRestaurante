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

<<<<<<< HEAD
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
=======
	private String nombreDelPlato;
	private String nombreDeLaBebida;
	private double precioDelPlato;
	private double precioDeLaBebida;
	private static int ID = 0;

	public Menu(String nombreDelPlato, String nombreDeLaBebida, double precioDelPlato, double precioDeLaBebida) {

		this.nombreDelPlato = nombreDelPlato;
		this.nombreDeLaBebida = nombreDeLaBebida;
		this.precioDelPlato = precioDelPlato;
		this.precioDeLaBebida = precioDeLaBebida;
		ID++;
	}
	
	public double precioTotal() {
		double precioTotal = 0.0;
		precioTotal = precioDeLaBebida + precioDelPlato;
		return precioTotal;
		
	}

	public String getNombreDelPlato() {
		return nombreDelPlato;
	}

	public void setNombreDelPlato(String nombreDelPlato) {
		this.nombreDelPlato = nombreDelPlato;
	}

	public String getNombreDeLaBebida() {
		return nombreDeLaBebida;
	}

	public void setNombreDeLaBebida(String nombreDeLaBebida) {
		this.nombreDeLaBebida = nombreDeLaBebida;
	}

	public double getPrecioDelPlato() {
		return precioDelPlato;
	}

	public void setPrecioDelPlato(double precioDelPlato) {
		this.precioDelPlato = precioDelPlato;
	}

	public double getPrecioDeLaBebida() {
		return precioDeLaBebida;
	}

	public void setPrecioDeLaBebida(double precioDeLaBebida) {
		this.precioDeLaBebida = precioDeLaBebida;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
>>>>>>> 99f03edaad6ecf260fe58f4d5138d4850121c302
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Menu [nombrePlato=" + nombrePlato + ", precioPlato=" + precioPlato + ", nombreBebida=" + nombreBebida
				+ ", precioBebida=" + precioBebida + "]";
	}
	
	
	
=======
		return "Menu [nombreDelPlato=" + nombreDelPlato + ", nombreDeLaBebida=" + nombreDeLaBebida + ", precioDelPlato="
				+ precioDelPlato + ", precioDeLaBebida=" + precioDeLaBebida + "]";
	}

>>>>>>> 99f03edaad6ecf260fe58f4d5138d4850121c302
}
