package interfaz;

import dominio.*;
import java.util.*;

public class MainRestaurante {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Restaurante messi");
		int salir = 0;
		do {
			agregarCliente(restaurante);
			System.out.println("Salir 99 si");
			salir = teclado.nextInt();
		} while (salir != 99);

	}

	Cliente cliente = null;
	Menu menu = null;

	private static void agregarCliente(Restaurante restaurante) {
		// TODO Auto-generated method stub

		System.out.println("Nombre cel cliente:");
		String nombre = teclado.next();
		System.out.println("Cantidad de platos a pedir:");
		int platos = teclado.nextInt();

		Cliente cliente = new Cliente(nombre, platos);
		boolean agregado = restaurante.nuevoCliente(cliente);

		if (agregado) {
			System.out.println("Hola " + cliente.getNombreCliente() + " que va a pedir?");
			agregarPlatos(cliente, platos);
		}

		mostrarCliente(cliente);

	}

	private static void mostrarCliente(Cliente cliente2) {
		// TODO Auto-generated method stub
		System.out.println(cliente2.toString());

	}

	private static void agregarPlatos(Cliente cliente, int platos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < platos; i++) {
			System.out.println("Nombre plato");
			String nombrePlato = teclado.next();
			System.out.println("Precio plato");
			double precioPlato = teclado.nextDouble();
			System.out.println("Bebida");
			String bebida = teclado.next();
			System.out.println("Precio bebida");
			double precioBebida = teclado.nextDouble();

			Menu menu = new Menu(nombrePlato, precioPlato, bebida, precioBebida);

			boolean platoAgregado = cliente.agregarPlato(menu);

			if (platoAgregado) {
				System.out.println("Plato agregado");
			} else {
				System.out.println("El plato no pudo ser agregado");
			}
		}
	}
}
