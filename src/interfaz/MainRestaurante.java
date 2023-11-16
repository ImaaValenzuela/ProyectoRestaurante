package interfaz;

import dominio.*;
import java.util.*;

public class MainRestaurante {
	public static final int AGREGAR_CLIENTE = 1, MESA_A_PAGAR = 2, VER_RECAUDACION_DEL_DIA = 3,
			VER_TICKET_POR_TIPODEPAGO = 4, SALIR = 5;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Restaurante messi");
		agregarPlatosAleatoriaamente(restaurante);
		int salir = 0;
		do {
			mostrarMenu();
			int opcion = ingresarEntero("Ingrese opcion");

			switch (opcion) {
			case AGREGAR_CLIENTE:
				agregarCliente(restaurante);
				break;
			case MESA_A_PAGAR:
				pagarCuenta(restaurante);
				break;
			case VER_RECAUDACION_DEL_DIA:
				verRecaucaionDelDia(restaurante);
				break;
			case VER_TICKET_POR_TIPODEPAGO:
				verTicketPorTipoDePago(restaurante);
				break;
			}

		} while (salir != 99);

	}

	private static void verTicketPorTipoDePago(Restaurante restaurante) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= TipoPago.values().length; i++) {

			mostrarPorPantalla(i + ")" + TipoPago.values()[i - 1]);

		}

		TipoPago metodoPago = metodoPago("Ingrese el tipo de pago");

		Cliente[] clientes = restaurante.ticketDeClientePorTipoDepago(metodoPago);

		mostrarTicketClientes(clientes);
	}

	private static void verRecaucaionDelDia(Restaurante restaurante) {
		// TODO Auto-generated method stub

		mostrarPorPantalla("La recaudacion del dia es:$" + restaurante.recaudacionDelDia());

	}

	private static void agregarCliente(Restaurante restaurante) {
		// TODO Auto-generated method stub

		mostrarPorPantalla("Nombre del cliente:");
		String nombre = teclado.next();
		mostrarPorPantalla("Cantidad de platos a pedir:");
		int platos = teclado.nextInt();
		int numeroDeMesa = restaurante.obtenerNumeroDeMesa();

		Cliente cliente = new Cliente(nombre, platos, numeroDeMesa);
		boolean agregado = restaurante.nuevoCliente(cliente);

		if (agregado) {
			mostrarPorPantalla("Hola " + cliente.getNombreCliente() + " que va a pedir?");
			Menu[] platosDelMenu = restaurante.mostrarMenuRestaurant();
			mostrarPlatos(platosDelMenu);
			agregarPlatosAlCliente(cliente, platos, restaurante);
		}

	}

	private static void pagarCuenta(Restaurante restaurante) {

		mostrarPorPantalla("Lista de clientes");
		Cliente[] cliente = restaurante.mostrarClientes();
		mostrarListaClientes(cliente);

		int numeroMesa = ingresarEntero("Seleccione numero de mesa que va a pagar");

		Cliente clienteMesa = restaurante.obtenerClientePorNumeroDeMesa(numeroMesa);

		mostrarCliente(clienteMesa);
		finalizarPago(restaurante, clienteMesa);

	}

	private static void agregarPlatosAlCliente(Cliente cliente, int platos, Restaurante restaurante) {
		// TODO Auto-generated method stub
		for (int i = 0; i < platos; i++) {
			mostrarPorPantalla("Ingrese ID:");
			int id = teclado.nextInt();

			Menu menu = restaurante.buscarPlatoPorID(id);

			boolean platoAgregado = cliente.agregarPlato(menu);

			if (platoAgregado) {
				mostrarPorPantalla("Plato agregado");
			} else {
				mostrarPorPantalla("El plato no pudo ser agregado");
			}
		}
	}

	private static void finalizarPago(Restaurante restaurante, Cliente cliente) {

		for (int i = 1; i <= TipoPago.values().length; i++) {

			mostrarPorPantalla(i + ")" + TipoPago.values()[i - 1]);

		}

		TipoPago metodo = metodoPago("Eliga un metodo de pago");

		cliente.setTipoPago(metodo);
		mostrarPorPantalla("Monto a pagar:$" + restaurante.verMontoDePago(cliente));

		int montoAPagar = ingresarEntero("Ingrese monto de pago:$");

		boolean yaPago = restaurante.realizarPago(cliente, montoAPagar);

		if (yaPago) {
			mostrarPorPantalla("Pago efectuado");
			cliente.setEstadoDePago(yaPago);
			mostrarTicketCliente(cliente);
		} else {
			mostrarPorPantalla("El pago no pudo ser efectuado");
		}
	}

	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		mostrarPorPantalla(AGREGAR_CLIENTE + "- AGREGAR CLIENTE");
		mostrarPorPantalla(MESA_A_PAGAR + "- MESA A PAGAR");
		mostrarPorPantalla(VER_RECAUDACION_DEL_DIA + "- VER RECAUDACION DEL DIA");
		mostrarPorPantalla(VER_TICKET_POR_TIPODEPAGO + "- VER TICKETS POR TIPO DE PAGO");
		mostrarPorPantalla(SALIR + "- SALIR");

	}

	private static void mostrarListaClientes(Cliente[] clientes) {
		// TODO Auto-generated method stub
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				mostrarPorPantalla(clientes[i].listaClientes());
			}
		}

	}

	private static void mostrarTicketClientes(Cliente[] clientes) {
		// TODO Auto-generated method stub
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				mostrarPorPantalla(clientes[i].toString());
			}
		}

	}

	private static void mostrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(cliente.listaClientes());
	}

	private static void mostrarTicketCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		mostrarPorPantalla(cliente.toString());

	}

	private static void mostrarPlatos(Menu menu[]) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i] != null) {
				mostrarPorPantalla(menu[i].platos());
			}
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

	private static int ingresarEntero(String mensaje) {
		mostrarPorPantalla(mensaje);

		return teclado.nextInt();
	}

	public static TipoPago metodoPago(String mensaje) {
		mostrarPorPantalla(mensaje);
		int num = teclado.nextInt();
		return TipoPago.values()[num - 1];
	}

	private static void agregarPlatosAleatoriaamente(Restaurante restaurante) {
		String[] plato = { "Asado", "Pizza", "Pastas", "Empanadas", "Milanesa", "Tarta", "Pastel de papas" };

		String[] bebida = { "Coca Cola", "Pepsi", "Manaos", "Seven up", "Fanta" };

		double[] precioBebida = { 350, 250, 400, 550, 450 };

		double[] precioPlato = { 1567, 1150, 1600, 1750, 1000, 1670, 1450 };

		// Random random = new Random();

		for (int i = 0; i < 7; i++) {
			String nombrePlato = plato[i];
			double precio = precioPlato[i];
			int id = (int) (Math.random() * 99) + 1;
			Menu menu = new Menu(nombrePlato, precio, TipoProducto.PLATO, id);
			restaurante.agregarPlatoAlMenu(menu);

		}

		for (int i = 0; i < 5; i++) {
			String nombrePlato = bebida[i];
			double precio = precioBebida[i];
			int id = (int) (Math.random() * 99) + 1;
			Menu menu = new Menu(nombrePlato, precio, TipoProducto.BEBIDA, id);
			restaurante.agregarPlatoAlMenu(menu);

		}
	}

}