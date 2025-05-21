public class Reto {
    private String descripcion;
    private int objetivo;
    private int progreso;
    private int recompensa;
    private boolean completado;

    public Reto(String descripcion, int objetivo, int recompensa) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.progreso = 0;
        this.completado = false;
    }

    public void registrarReciclaje(int cantidad) {
        if (!completado) {
            progreso += cantidad;
            if (progreso >= objetivo) {
                completado = true;
            }
        }
    }

    public boolean completado() {
        return completado;
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