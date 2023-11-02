package dominio;

public class Cliente {
	private String nombre;
	private String pedido[];
	private Menu menu;
	private TipoDePago tipoDePago;
	private final double APLICACION = 0.15;
	private final double EFECTIVO = 0.20;
	private final double TARJETA_CREDITO = 0.10;
	private final double TRANSFERENCIA = 0;

	public Cliente(String nombre, String[] pedido, Menu menu, TipoDePago tipoDePago) {
		super();
		this.nombre = nombre;
		this.pedido = pedido;
		this.menu = menu;
		this.tipoDePago = tipoDePago;
	}

	public double precioFinal() {
		menu.precioTotal();
		double precioFinal = 0.0;
		if (this.tipoDePago.equals(tipoDePago.APLICACION)) {
			precioFinal = menu.precioTotal() - (menu.precioTotal() * APLICACION);

		} else if (this.tipoDePago.equals(tipoDePago.EFECTIVO)) {
			precioFinal = menu.precioTotal() - (menu.precioTotal() * EFECTIVO);

		} else if (this.tipoDePago.equals(tipoDePago.TARJETA_CREDITO)) {
			precioFinal = menu.precioTotal() + (menu.precioTotal() * TARJETA_CREDITO);
		} else {
			precioFinal = menu.precioTotal();
			
		}
		return precioFinal;

	}
}