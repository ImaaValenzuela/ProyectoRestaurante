package dominio;

import java.util.Arrays;

public class Cliente {
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

}
