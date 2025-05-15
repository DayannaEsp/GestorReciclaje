public class Recompensa {
    private String nombre;
    private int costoPuntos;

    public Recompensa(String nombre, int costoPuntos) {
        this.nombre = nombre;
        this.costoPuntos = costoPuntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoPuntos() {
        return costoPuntos;
    }

    public boolean canjear(int puntosDisponibles) {
        return puntosDisponibles >= costoPuntos;
    }
}
