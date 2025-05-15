import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorReciclaje gestor = new GestorReciclaje();
        int cantidad, opcion;
        String tipo, recompensaElegida, nombre;


        System.out.print("Ingresa tu nombre para registrarte: ");
        nombre = teclado.nextLine();
        Usuario usuario = gestor.registrarUsuario(nombre);

        do {
            System.out.println("--- Menú de opciones ---");
            System.out.println("1. Reciclar");
            System.out.println("2. Ver estado del usuario");
            System.out.println("3. Ver ranking");
            System.out.println("4. Ver reto semanal");
            System.out.println("5. Ver recompensas");
            System.out.println("6. Canjear recompensa");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("¿Qué reciclaste? (botella, papel, plástico): ");
                    tipo = teclado.nextLine().toLowerCase();
                    System.out.print("¿Cuántos reciclaste?: ");
                    cantidad = teclado.nextInt();
                    teclado.nextLine();
                    usuario.reciclar(tipo, cantidad);

                }
                case 2 -> {
                    usuario.mostrarEstado();

                }
                case 3 -> {
                    gestor.mostrarRanking();

                }
                case 4 -> {
                    Reto reto = gestor.getRetoSemanal();
                    System.out.println("Reto semanal: " + reto.getDescripcion());
                    System.out.println("Progreso: " + reto.getProgreso() + "/" + reto.getObjetivo());

                }
                case 5 -> {
                    gestor.mostrarRecompensas();

                }
                case 6 -> {
                    System.out.print("¿Qué recompensa deseas canjear? ");
                    System.out.println("1.Café gratis");
                    System.out.println("2.Descuento librería");
                    System.out.println("3.Donación a plantación de árboles");
                    recompensaElegida = teclado.nextLine();
                    gestor.canjearRecompensa(usuario, recompensaElegida);

                }
                case 7 -> {
                    System.out.println("Gracias por usar la app de reciclaje");

                }

            }

        } while (opcion != 7);
    }
}