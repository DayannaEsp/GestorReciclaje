import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int puntos;
    private Reto retoAsignado;
    private String nivel;
    private List<String> historialReciclaje;

    public Usuario(String nombre, Reto retoGlobal) {
        this.nombre = nombre;
        this.puntos = 0;
        this.retoAsignado = new Reto(
                retoGlobal.getDescripcion(),
                retoGlobal.getObjetivo(),
                retoGlobal.getRecompensa(),
                retoGlobal.getTipoObjetivo()
        );
        this.nivel = "Reciclador Novato";
        this.historialReciclaje = new ArrayList<>();

    }

    public void reciclar(String tipo, int cantidad, int puntosPorUnidad) {
        int total = cantidad * puntosPorUnidad;
        puntos += total;
        retoAsignado.registrarReciclaje(tipo.toLowerCase(), cantidad);


        if (retoAsignado.completado()) {
            System.out.println("Feliciadades. Completaste el reto y ganaste " + retoAsignado.getRecompensa() + " puntos extra.");
            puntos += retoAsignado.getRecompensa();
        }

        System.out.println("Ganaste " + total + " puntos por reciclar " + cantidad + " " + tipo + "(s).");

        historialReciclaje.add(cantidad + "x" + tipo);
        actualizarNivel();
    }

    private void actualizarNivel(){
        if(puntos>=20000) {
            nivel="Maestro Verde";
        }else if (puntos>=10500) {
            nivel="Reciclador Intermedio";
        }else{
            nivel="Reciclador Novato";
        }
    }


    public void mostrarEstado() {
        System.out.println("Usuario: " + nombre);
        System.out.println("Puntos: " + puntos);
        System.out.println("Nivel: " + nivel);
        System.out.println("Historial: " + historialReciclaje);
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

    public Reto getRetoAsignado() {
        return retoAsignado;
    }
}
