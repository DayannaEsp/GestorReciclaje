import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int puntos;
    private String nivel;
    private List<String> historialReciclaje;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.nivel = "Reciclador Novato";
        this.historialReciclaje = new ArrayList<>();
    }

    public void reciclar(String tipo, int cantidad) {
        int puntosGanados = switch (tipo) {
            case "botella" -> 5 * cantidad;
            case "papel" -> 3 * cantidad;
            case "plastico" -> 4 * cantidad;
            default -> 0;
        };
        puntos += puntosGanados;
        historialReciclaje.add(cantidad + "x " + tipo);
        actualizarNivel();
        System.out.println(nombre + " recicló " + cantidad + " " + tipo + "(s) y ganó " + puntosGanados + " puntos.");
    }

    private void actualizarNivel() {
        if (puntos >= 300) nivel = "Maestro Verde";
        else if (puntos >= 150) nivel = "Eco-Héroe";
        else nivel = "Reciclador Novato";
    }

    public void mostrarEstado() {
        System.out.println("\nUsuario: " + nombre);
        System.out.println("Puntos: " + puntos);
        System.out.println("Nivel: " + nivel);
        System.out.println("Historial: " + historialReciclaje);
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    // Restar puntos cuando se canjea una recompensa
    public void restarPuntos(int puntosArestar) {
        puntos -= puntosArestar;
    }
}
