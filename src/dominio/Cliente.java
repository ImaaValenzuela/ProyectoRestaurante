package dominio;

import java.util.Arrays;

public class Cliente {
<<<<<<< HEAD
	private String nombreCliente;
	private Menu menu[];
	private TipoPago tipoPago;
	private double montoFinal;

	public Cliente(String nombreCliente, int cantidadPlatos) {
		this.nombreCliente = nombreCliente;
		this.menu = new Menu[cantidadPlatos];
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public boolean agregarPlato(Menu menu) {
		boolean seAgrego = false;
		int contador = 0;

		while (!seAgrego && contador < this.menu.length) {
			if (this.menu[contador] == null) {
				this.menu[contador] = menu;
				seAgrego = true;
			}
			contador++;
		}
		return seAgrego;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	

	public double getMontoAPagar() {
		return montoFinal;
	}

	public void setMontoAPagar(double montoPagado) {
		this.montoFinal = montoPagado;
	}

	public Menu[] getMenu() {
		return menu;
	}

	public double montoApagar() {

		double monto = 0;
		for (int i = 0; i < this.menu.length; i++) {
			monto = this.menu[i].getPrecioPlato() + this.menu[i].getPrecioBebida();
		}
		return monto;

	}

	@Override
	public String toString() {
		return "Cliente [nombreCliente=" + nombreCliente + ", menu=" + Arrays.toString(menu) + "]";
	}
=======
	private String nombre;
	private String pedido[];
	private Menu menu;
	private TipoDePago tipoDePago;
	private final double APLICACION = 0.15;
	private final double EFECTIVO = 0.20;
	private final double TARJETA_CREDITO = 0.10;
	private final double TRANSFERENCIA = 0;
>>>>>>> 99f03edaad6ecf260fe58f4d5138d4850121c302

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