package dominio;

public class Restaurante {
	private String nombreRestaurant;
	private Cliente[] cliente = new Cliente[1000];
	private Menu[] menu = new Menu[100];
	private Menu[] menuVentas = new Menu[100];

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
			contador++;
		}
		return seAgrego;
	}

	public Menu buscarPlatoPorID(int id) {
		Menu menu = null;
		boolean seEncontro = false;
		int contador = 0;

		while (!seEncontro && contador < this.menu.length) {
			if (this.menu[contador].getId() == id) {
				menu = this.menu[contador];
				seEncontro = true;
			}
			contador++;
		}
		return menu;
	}

	public boolean agregarPlatoAlMenu(Menu menu) {

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

	public void agregarVentaDePlatos(Menu menu) {

		boolean seAgrego = false;
		int contador = 0;

		while (!seAgrego && contador < this.menuVentas.length) {
			if (this.menuVentas[contador] == null) {
				this.menuVentas[contador] = menu;
				seAgrego = true;
			}
			contador++;
		}

	}

	public Cliente[] ticketDeClientePorTipoDepago(TipoPago tipoPago) {

		Cliente[] clientes = new Cliente[this.cliente.length];
		int posicion = 0;
		for (int i = 0; i < this.cliente.length; i++) {
			if (this.cliente[i] != null && this.cliente[i].getTipoPago().equals(tipoPago)) {
				clientes[posicion] = this.cliente[i];
				posicion++;
			}
		}

		return clientes;
	}
	

	public double recaudacionDelDia() {

		double montoObtenido = 0;

		for (int i = 0; i < this.cliente.length; i++) {
			if (this.cliente[i] != null) {
				montoObtenido += this.cliente[i].getMontoAPagar();
			}
		}

		return montoObtenido;

	}

	public int obtenerNumeroDeMesa() {
		int numeroDeMesa = (int) (Math.random() * 30) + 15;
		numeroDeMesa = verificarNumeroDeMesa(numeroDeMesa);
		return numeroDeMesa;
	}

	public int verificarNumeroDeMesa(int numeroDeMesa) {
		boolean yaExiste = false;
		int contador = 0;

		while (!yaExiste && contador < this.menu.length) {
			if (this.cliente[contador] != null && this.cliente[contador].getNumeroMesa() == numeroDeMesa) {
				yaExiste = true;
			}
			contador++;
		}

		int nuevoNumeroDeMesa = numeroDeMesa;
		// Si el ID ya existe, buscar un nuevo ID único
		if (yaExiste) {

			this.cliente[contador].setNumeroMesa(nuevoNumeroDeMesa++);

			boolean encontradoNuevoID = false; // Variable para controlar si se encuentra un nuevo ID

			while (!encontradoNuevoID) {
				boolean existeElNuevoID = false;
				nuevoNumeroDeMesa = this.cliente[contador].getNumeroMesa();

				for (int i = 0; i < this.cliente.length; i++) {
					if (this.cliente[i] != null && this.cliente[i].getNumeroMesa() == nuevoNumeroDeMesa) {
						existeElNuevoID = true;
						break; // Salir del bucle interno si se encuentra el nuevo ID
					}
				}

				if (!existeElNuevoID) {
					encontradoNuevoID = true; // Se encontró un nuevo ID válido, sal del bucle externo
				} else {
					this.cliente[contador].setNumeroMesa(nuevoNumeroDeMesa++); // Incrementar el ID y continuar buscando
				}
			}
		}

		return nuevoNumeroDeMesa;
	}

	public Cliente obtenerClientePorNumeroDeMesa(int id) {

		Cliente cliente = null;

		boolean seEncontro = false;
		int contador = 0;

		while (!seEncontro && contador < this.cliente.length) {
			if (this.cliente[contador] != null && this.cliente[contador].getNumeroMesa() == id) {
				cliente = this.cliente[contador];
				seEncontro = true;
			}
			contador++;
		}
		return cliente;

	}

	public int verificarID(int id) {
		boolean yaExiste = false;
		int contador = 0;

		while (!yaExiste && contador < this.menu.length) {
			if (this.menu[contador] != null && this.menu[contador].getId() == id) {
				yaExiste = true;
			}
			contador++;
		}

		int control = 0;
		// Si el ID ya existe, buscar un nuevo ID único
		if (yaExiste) {

			int nuevoID = id;
			this.menu[contador].setId(nuevoID++);

			boolean encontradoNuevoID = false; // Variable para controlar si se encuentra un nuevo ID

			while (!encontradoNuevoID) {
				boolean existeElNuevoID = false;
				control = this.menu[contador].getId();

				for (int i = 0; i < this.menu.length; i++) {
					if (this.menu[i] != null && this.menu[i].getId() == control) {
						existeElNuevoID = true;
						break; // Salir del bucle interno si se encuentra el nuevo ID
					}
				}

				if (!existeElNuevoID) {
					encontradoNuevoID = true; // Se encontró un nuevo ID válido, sal del bucle externo
				} else {
					this.menu[contador].setId(nuevoID++); // Incrementar el ID y continuar buscando
				}
			}
		}

		return control;
	}

	public Cliente[] mostrarClientes() {
		Cliente[] clientes = new Cliente[this.cliente.length];

		for (int i = 0; i < this.cliente.length; i++) {
			if (this.cliente[i] != null && !this.cliente[i].isEstadoDePago()) {
				clientes[i] = this.cliente[i];
			}
		}

		return clientes;
	}

	public Menu[] mostrarMenuRestaurant() {
		Menu[] menuRestaurant = new Menu[this.menu.length];
		int contador = 0;
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i] != null) {
				contador++;
			}
		}

		int control = 0;
		if (contador > 0) {
			for (int i = 0; i < contador; i++) {
				if (this.menu[i] != null) {
					menuRestaurant[control] = this.menu[i];
					control++;
				}
			}
		}
		return menuRestaurant;
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

			if (cliente.getMenu()[i] != null
					&& cliente.getMenu()[i].getTipoProducto().PLATO.equals(TipoProducto.PLATO)) {
				montoSinRecargo += cliente.getMenu()[i].getPrecio();
			} else if (cliente.getMenu()[i] != null
					&& cliente.getMenu()[i].getTipoProducto().BEBIDA.equals(TipoProducto.BEBIDA)) {
				montoSinRecargo += cliente.getMenu()[i].getPrecio();
			}
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
