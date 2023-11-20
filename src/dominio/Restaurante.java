package dominio;

public class Restaurante {
	private String nombreRestaurant;
	private Cliente[] cliente = new Cliente[1000];
	private Menu[] menu = new Menu[100];
	private Menu[] menuVentas = new Menu[100];

	private final double APLICACION = 0.1;
	private final double TARJETA = 0.10;
	private final double TRANSFERENCIA = 0.1;
	private final double EFECTIVO = 0.0;

	public Restaurante(String nombreRestaurant) {
		this.nombreRestaurant = nombreRestaurant;
	}

	public String getNombreRestaurant() {
		return nombreRestaurant;
	}

	public void setNombreRestaurant(String nombreRestaurant) {
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

	public Menu[] getMenuVentas() {
		return menuVentas;
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
		int numeroDeMesa = (int) (Math.random() * 10) + 5;
		numeroDeMesa = verificarNumeroDeMesa(numeroDeMesa);
		return numeroDeMesa;
	}

	public int verificarNumeroDeMesa(int numeroDeMesa) {
		boolean yaExiste = false;
		int contador = 0;
		int nuevoNumeroDeMesa = numeroDeMesa;

		while (!yaExiste && contador < this.menu.length) {
			if (this.cliente[contador] != null && this.cliente[contador].getNumeroMesa() == nuevoNumeroDeMesa) {
				yaExiste = true;
			}
			contador++;
		}

		// Si el ID ya existe, buscar un nuevo ID único

		if (yaExiste) {

			nuevoNumeroDeMesa = obtenerNumeroDeMesa();

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

	public int obtenerID() {
		int id = (int) (Math.random() * this.menu.length);
		verificarID(id);

		return id;
	}

	public int verificarID(int id) {
		int nuevoID = 0;

		boolean seEncontro = false;
		int contador = 0;

		while (!seEncontro && contador < this.cliente.length) {
			if (this.cliente[contador] != null && this.cliente[contador].getNumeroMesa() == id) {
				seEncontro = true;
			}
			contador++;
		}

		nuevoID = id;

		if (seEncontro) {
			nuevoID = obtenerID();
		}

		return nuevoID;
	}

	public Cliente[] getCliente() {
		return cliente;
	}

	public Menu[] getMenu() {
		return menu;
	}

	public Menu[] ordenarMenuDeVentasPorPrecioAscendente() {

		Menu[] menu = this.menu.clone();
		for (int i = 0; i < this.menu.length; i++) {
			for (int j = 0; j < this.menu.length - 1; j++) {

				if (menu[j] != null && menu[j + 1] != null && menu[j].getPrecio() > menu[j + 1].getPrecio()) {
					Menu aux = menu[j];
					menu[j] = menu[j + 1];
					menu[j + 1] = aux;
				}

			}
		}
		return menu;
	}

	public Menu[] obtenerMenuDeVentasPorProduco(TipoProducto tipoProducto) {

		Menu[] menu = new Menu[this.menu.length];
		int contador = 0;
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i] != null && this.menu[i].getTipoProducto().equals(tipoProducto)) {
				menu[contador] = this.menu[i];
				contador++;
			}

		}
		return menu;

	}

	public double obtenerPrecio(TipoPago tipoPago, double monto) {

		double montoFinal = monto;

		switch (tipoPago) {
		case APLICACION:
			monto *= APLICACION;
			montoFinal -= monto;
			break;
		case TARJETA_CREDITO:
			monto *= TARJETA;
			montoFinal += monto;
			break;
		case TRANSFERENCIA:
			monto *= TRANSFERENCIA;
			montoFinal += monto;
			break;
		default:
			monto *= EFECTIVO;
			montoFinal += monto;
			break;
		}
		return montoFinal;
	}

	public double verMontoDePago(Cliente cliente) {

		double montoSinRecargo = 0;

		for (int i = 0; i < cliente.getMenu().length; i++) {

			if (cliente.getMenu()[i] != null) {

				switch (cliente.getMenu()[i].getTipoProducto()) {
				case PLATO:
					montoSinRecargo += cliente.getMenu()[i].getPrecio();
					break;
				case BEBIDA:
					montoSinRecargo += cliente.getMenu()[i].getPrecio();
					break;
				default:
					break;
				}
			}
		}

		double montoFinal = obtenerPrecio(cliente.getTipoPago(), montoSinRecargo);

		cliente.setMontoAPagar(montoFinal);
		return montoFinal;

	}

	public boolean realizarPago(Cliente cliente, double monto, Camarero camarero) {

		if (monto >= cliente.getMontoAPagar()) {
			double propina = monto - cliente.getMontoAPagar();
			camarero.recibirPropina(propina);
			return true;
		}
		return false;
	}

	public String ventasDelDia() {
		StringBuilder ventasDelDia = new StringBuilder();

		return ventasDelDia.toString();
	}
	
    public boolean agregarPlato(Menu plato) {
        boolean seAgrego = false;
        int contador = 0;

        while (!seAgrego && contador < this.menu.length) {
            if (this.menu[contador] == null) {
                this.menu[contador] = plato;
                seAgrego = true;
            }
            contador++;
        }

        return seAgrego;
    }

    public boolean eliminarPlatoPorId(int id) {
        boolean seElimino = false;
        int contador = 0;

        while (!seElimino && contador < this.menu.length) {
            if (this.menu[contador] != null && this.menu[contador].getId() == id) {
                this.menu[contador] = null;
                seElimino = true;
            }
            contador++;
        }

        return seElimino;
    }

}
