public class Recompensa {
    private String nombre;
    private int costo;

    public Recompensa(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }
}