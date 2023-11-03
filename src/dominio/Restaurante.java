package dominio;

public class Restaurante {
	private String nombreRestaurant;
	private Cliente[] cliente = new Cliente[1000];

	private final double APLICACION = 0.5;
	private final double TARJETA = 0.10;
	private final double TRANSFERENCIA = 0.1;
	private final double EFECTIVO = 0.0;

	public Restaurante(String nombreRestaurant) {
		this.nombreRestaurant = nombreRestaurant;
	}

	public boolean nuevoCliente(Cliente cliente) {
		boolean seAgrego = false;
		int contador = 0;
		while (!seAgrego && contador < this.cliente.length) {
			if (this.cliente[contador] == null) {
				this.cliente[contador] = cliente;
				seAgrego = true;
			}
		}
		return seAgrego;
	}

	public double obtenerPrecio(TipoPago tipoPago, double monto) {

		double montoFinal = monto;

		if (tipoPago.equals(TipoPago.APLICACION)) {
			monto = monto * APLICACION;
			montoFinal += monto;
		} else if (tipoPago.equals(TipoPago.TARJETA_CREDITO)) {
			monto = monto * TARJETA;
			montoFinal += monto;
		} else if (tipoPago.equals(TipoPago.TRANSFERENCIA)) {
			monto = monto * TRANSFERENCIA;
			montoFinal += monto;
		} else {
			monto = monto * EFECTIVO;
			montoFinal += monto;
		}
		return montoFinal;
	}

	public double verMontoDePago(Cliente cliente) {

		double montoSinRecargo = 0;

		for (int i = 0; i < cliente.getMenu().length; i++) {

			montoSinRecargo = cliente.getMenu()[i].getPrecioPlato() + cliente.getMenu()[i].getPrecioBebida();
		}

		double montoFinal = obtenerPrecio(cliente.getTipoPago(), montoSinRecargo);
		cliente.setMontoAPagar(montoFinal);
		return montoFinal;

	}

	public boolean realizarPago(Cliente cliente, double monto) {

		if (monto >= cliente.getMontoAPagar()) {
			return true;
		}
		return false;
	}

}
