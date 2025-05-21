public class Usuario {
    private String nombre;
    private int puntos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void reciclar(String tipo, int cantidad, int puntosPorUnidad, Reto reto) {
        int total = cantidad * puntosPorUnidad;
        puntos += total;

        if (total > 0) {
            reto.registrarReciclaje(cantidad);
        }

        if (reto.completado()) {
            System.out.println("Felicidades. Completaste el reto y ganaste " + reto.getRecompensa() + " puntos extra.");
            puntos += reto.getRecompensa();
        }

        System.out.println("Ganaste " + total + " puntos por reciclar " + cantidad + " " + tipo + "(s).");
    }

    public void mostrarEstado() {
        System.out.println("Usuario: " + nombre);
        System.out.println("Puntos: " + puntos);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void restarPuntos(int cantidad) {
        puntos = Math.max(0, puntos - cantidad);
    }
}