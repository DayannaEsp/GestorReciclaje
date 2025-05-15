import java.util.ArrayList;
import java.util.List;

public class GestorReciclaje {
    private List<Usuario> usuarios;
    private List<Recompensa> recompensas;
    private Reto retoSemanal;

    public GestorReciclaje() {
        usuarios = new ArrayList<>();
        recompensas = new ArrayList<>();
        retoSemanal = new Reto("Recicla 20 botellas esta semana", 20, 50);

        // Añadimos algunas recompensas de ejemplo
        recompensas.add(new Recompensa("Café gratis", 100));
        recompensas.add(new Recompensa("Descuento librería", 150));
        recompensas.add(new Recompensa("Donación a plantación de árboles", 200));
    }

    public Usuario registrarUsuario(String nombre) {
        Usuario u = new Usuario(nombre);
        usuarios.add(u);
        return u;
    }

    public void mostrarRanking() {
        usuarios.sort((a, b) -> b.getPuntos() - a.getPuntos());
        System.out.println("\n🏆 Ranking de usuarios:");
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " - " + u.getPuntos() + " puntos");
        }
    }

    public Reto getRetoSemanal() {
        return retoSemanal;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    // Mostrar todas las recompensas disponibles
    public void mostrarRecompensas() {
        System.out.println("\n Recompensas disponibles:");
        for (Recompensa recompensa : recompensas) {
            System.out.println("- " + recompensa.getNombre() + " (Puntos necesarios: " + recompensa.getCostoPuntos() + ")");
        }
    }

    // Canjear recompensa
    public boolean canjearRecompensa(Usuario usuario, String nombreRecompensa) {
        for (Recompensa recompensa : recompensas) {
            if (recompensa.getNombre().equalsIgnoreCase(nombreRecompensa)) {
                if (recompensa.canjear(usuario.getPuntos())) {
                    usuario.restarPuntos(recompensa.getCostoPuntos());
                    System.out.println("¡Has canjeado la recompensa: " + recompensa.getNombre() + "!");
                    return true;
                } else {
                    System.out.println("No tienes suficientes puntos para canjear esta recompensa.");
                    return false;
                }
            }
        }
        System.out.println("Recompensa no encontrada.");
        return false;
    }
}