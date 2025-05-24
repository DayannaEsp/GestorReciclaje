public class Reto {
    private String descripcion;
    private int objetivo;
    private int progreso;
    private int recompensa;
    private boolean completado;
    private String tipoObjetivo;

    public Reto(String descripcion, int objetivo, int recompensa, String tipoObjetivo) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.recompensa = recompensa;
        this.progreso = 0;
        this.completado = false;
        this.tipoObjetivo = tipoObjetivo;

    }

    public void registrarReciclaje(String tipo, int cantidad) {
        if (!completado) {
            if (tipoObjetivo == null || tipoObjetivo.equalsIgnoreCase(tipo)) {
                progreso += cantidad;
                if (progreso >= objetivo) {
                    completado = true;
                }
            }
        }
    }



    public boolean completado(){
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
public String getTipoObjetivo() {
    return tipoObjetivo;
}

}

