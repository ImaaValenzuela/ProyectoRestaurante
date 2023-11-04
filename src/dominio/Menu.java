package dominio;

public class Menu {
    private String nombreDelPlato;
    private String nombreDeLaBebida;
    private double precioDelPlato;
    private double precioDeLaBebida;
    private static int ID = 0;

    public Menu(String nombreDelPlato, String nombreDeLaBebida, double precioDelPlato, double precioDeLaBebida) {
        this.nombreDelPlato = nombreDelPlato;
        this.nombreDeLaBebida = nombreDeLaBebida;
        this.precioDelPlato = precioDelPlato;
        this.precioDeLaBebida = precioDeLaBebida;
        ID++;
    }

    public double precioTotal() {
        return precioDelPlato + precioDeLaBebida;
    }

    public String getNombreDelPlato() {
        return nombreDelPlato;
    }

    public void setNombreDelPlato(String nombreDelPlato) {
        this.nombreDelPlato = nombreDelPlato;
    }

    public String getNombreDeLaBebida() {
        return nombreDeLaBebida;
    }

    public void setNombreDeLaBebida(String nombreDeLaBebida) {
        this.nombreDeLaBebida = nombreDeLaBebida;
    }

    public double getPrecioDelPlato() {
        return precioDelPlato;
    }

    public void setPrecioDelPlato(double precioDelPlato) {
        this.precioDelPlato = precioDelPlato;
    }

    public double getPrecioDeLaBebida() {
        return precioDeLaBebida;
    }

    public void setPrecioDeLaBebida(double precioDeLaBebida) {
        this.precioDeLaBebida = precioDeLaBebida;
    }

    public static int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Menú #" + ID + "\n" +
               "Plato: " + nombreDelPlato + "\n" +
               "Precio del plato: $" + precioDelPlato + "\n" +
               "Bebida: " + nombreDeLaBebida + "\n" +
               "Precio de la bebida: $" + precioDeLaBebida + "\n" +
               "Precio Total: $" + precioTotal();
    }
}