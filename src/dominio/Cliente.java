package dominio;

import java.util.Arrays;

public class Cliente {
	private String nombreCliente;
	private Menu menu[];
	private TipoDePago tipoPago;
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

	public TipoDePago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoDePago tipoPago) {
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
			monto = this.menu[i].getPrecioDelPlato() + this.menu[i].getPrecioDeLaBebida();
		}
		return monto;

	}

	@Override
	
	// TODO: toString con uso de Arrays
	/* public String toString() {
		return "Cliente [nombreCliente=" + nombreCliente + ", menu=" + Arrays.toString(menu) + "]";
	}*/ 
	
	public String toString() {
	    String clienteString = "Cliente: " + nombreCliente + "\n";
	    String menuString = "Menú:\n";

	    for (int i = 0; i < menu.length; i++) {
	        Menu menuItem = menu[i];
	        if (menuItem != null) {
	            if (i > 0) {
	                menuString += "-------------------------\n";
	            }
	            menuString += "Plato #" + (i + 1) + ":\n" + menuItem.toString() + "\n";
	        }
	    }

	    return clienteString + menuString;
	}
	
	// TODO: Checkear  si agregamos o no
	
    /* private String nombre;
    private String[] pedido;
    private Menu menu;
    private TipoDePago tipoDePago;
    private final double APLICACION = 0.15;
    private final double EFECTIVO = 0.20;
    private final double TARJETA_CREDITO = 0.10;
    private final double TRANSFERENCIA = 0;

    public Cliente(String nombre, String[] pedido, Menu menu, TipoDePago tipoDePago) {
        this.nombre = nombre;
        this.pedido = pedido;
        this.menu = menu;
        this.tipoDePago = tipoDePago;
    }

    public double precioFinal() {
        double precioFinal = menu.precioTotal();

        if (tipoDePago == TipoDePago.APLICACION) {
            precioFinal -= precioFinal * APLICACION;
        } else if (tipoDePago == TipoDePago.EFECTIVO) {
            precioFinal -= precioFinal * EFECTIVO;
        } else if (tipoDePago == TipoDePago.TARJETA_CREDITO) {
            precioFinal += precioFinal * TARJETA_CREDITO;
        }

        return precioFinal;
    } */
}