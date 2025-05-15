public class Reto {
    private String descripcion;
    private int objetivo;
    private int progreso;
    private int recompensa;

    public Reto(String descripcion, int objetivo, int recompensa) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.progreso = 0;
    }

    public void registrarReciclaje(int cantidad) {
        progreso += cantidad;
    }

    public boolean completado() {
        return progreso >= objetivo;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getProgreso() {
        return progreso;
    }

    public int getObjetivo() {
        return objetivo;
    }
}