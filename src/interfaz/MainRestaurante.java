package interfaz;

import dominio.Cliente;
import dominio.Menu;
import dominio.Restaurante;

import java.util.Scanner;

public class MainRestaurante {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Restaurante Messi");

        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente(restaurante, teclado);
                    break;
                case 2:
                    System.out.println("Gracias por venir al Restaurante Messi, Vuelva pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 2);

        teclado.close();
    }

    private static void agregarCliente(Restaurante restaurante, Scanner teclado) {
        System.out.println("Nombre del cliente:");
        String nombre = teclado.next();
        System.out.println("Cantidad de platos a pedir:");
        int cantidadPlatos = teclado.nextInt();

        Cliente cliente = new Cliente(nombre, cantidadPlatos);
        boolean agregado = restaurante.nuevoCliente(cliente);

        if (agregado) {
            System.out.println("Hola " + cliente.getNombreCliente() + ", ¿qué va a pedir?");
            agregarPlatos(cliente, teclado);
        }

        mostrarCliente(cliente);
    }

    private static void agregarPlatos(Cliente cliente, Scanner teclado) {
        for (int i = 0; i < cliente.getMenu().length; i++) {
            System.out.println("Plato #" + (i + 1));
            System.out.println("Nombre del plato:");
            String nombrePlato = teclado.next();
            System.out.println("Precio del plato:");
            double precioPlato = teclado.nextDouble();
            System.out.println("Nombre de la bebida:");
            String nombreBebida = teclado.next();
            System.out.println("Precio de la bebida:");
            double precioBebida = teclado.nextDouble();

            Menu menu = new Menu(nombrePlato, nombreBebida, precioPlato, precioBebida);

            boolean platoAgregado = cliente.agregarPlato(menu);

            if (platoAgregado) {
                System.out.println("Plato agregado.");
            } else {
                System.out.println("El plato no pudo ser agregado.");
            }
        }
    }

    private static void mostrarCliente(Cliente cliente) {
        System.out.println("Detalles del Cliente:");
        System.out.println(cliente.toString());
    }
}
