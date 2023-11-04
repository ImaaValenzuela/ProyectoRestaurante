package dominio;

public class Ticket {

	private int numeroDeMesa;
	private String fechaYHora;
	private String alimentosYBebidas[];
	private double precioTotal;
	
	public Ticket(int numeroDeMesa, String fechaYHora, String[] alimentosYBebidas, double precioTotal) {

		this.numeroDeMesa = numeroDeMesa;
		this.fechaYHora = fechaYHora;
		this.alimentosYBebidas = alimentosYBebidas;
		this.precioTotal = precioTotal;
	}

	
}
