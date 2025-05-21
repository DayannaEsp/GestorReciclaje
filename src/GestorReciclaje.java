import java.util.*;

public class GestorReciclaje {
    private List<Usuario> usuarios;
    private List<Recompensa> recompensas;
    private Reto retoSemanal;
    private List<Reto> retosDisponibles;

    public GestorReciclaje() {
        usuarios = new ArrayList<>();
        recompensas = new ArrayList<>();

        recompensas.add(new Recompensa("Descuento en tienda ecológica", 50));
        recompensas.add(new Recompensa("Cupón para cine sostenible", 30));
        recompensas.add(new Recompensa("Bolsa reutilizable", 20));

        retosDisponibles = new ArrayList<>();
        retosDisponibles.add(new Reto("Recicla 10 objetos válidos esta semana", 10, 20));
        retosDisponibles.add(new Reto("Recicla 5 botellas grandes", 5, 15));
        retosDisponibles.add(new Reto("Recicla 8 papeles", 8, 12));
        retosDisponibles.add(new Reto("Evita reciclar objetos no válidos por 3 turnos", 3, 10));
        retosDisponibles.add(new Reto("Recicla 15 objetos de cualquier tipo", 15, 25));

        retoSemanal = generarRetoAleatorio();
    }

    private Reto generarRetoAleatorio() {
        Random random = new Random();
        return retosDisponibles.get(random.nextInt(retosDisponibles.size()));
    }

    public Usuario registrarUsuario(String nombre) {
        Usuario usuario = new Usuario(nombre);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    public Reto getRetoSemanal() {
        return retoSemanal;
    }

    public void mostrarRanking() {
        usuarios.sort((a, b) -> b.getPuntos() - a.getPuntos());
        System.out.println("\n--- Ranking de usuarios ---");
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + ": " + u.getPuntos() + " puntos");
        }
    }

    public void mostrarRecompensas() {
        System.out.println("\n--- Recompensas disponibles ---");
        for (Recompensa r : recompensas) {
            System.out.println(r.getNombre() + " - " + r.getCosto() + " puntos");
        }
    }

    public void canjearRecompensa(Usuario usuario, String nombreRecompensa) {
        for (Recompensa r : recompensas) {
            if (r.getNombre().equalsIgnoreCase(nombreRecompensa)) {
                if (usuario.getPuntos() >= r.getCosto()) {
                    usuario.restarPuntos(r.getCosto());
                    System.out.println("Recompensa '" + r.getNombre() + "' canjeada con éxito");
                } else {
                    System.out.println("No tienes suficientes puntos para esta recompensa.");
                }
                return;
            }
        }
        System.out.println("Recompensa no encontrada.");
    }
}
