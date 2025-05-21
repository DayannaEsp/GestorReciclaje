import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorReciclaje gestor = new GestorReciclaje();
        int opcionInicio, tipo, cantidad, puntosGanados = 0;
        String nombre, articulo = "", nuevoNombre;

        Usuario usuario = null;

        while (usuario == null) {
            System.out.println("¿Deseas (1) Iniciar sesión o (2) Registrarte?");
            opcionInicio = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Ingresa tu nombre: ");
            nombre = teclado.nextLine();

            if (opcionInicio == 1) {
                usuario = gestor.buscarUsuario(nombre);
                if (usuario == null) {
                    System.out.println("Usuario no encontrado. Prueba registrarte.");
                }
            } else if (opcionInicio == 2) {
                usuario = gestor.registrarUsuario(nombre);
                System.out.println("¡Usuario registrado con éxito!");
            }
        }

        int opcion;
        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Reciclar");
            System.out.println("2. Ver estado del usuario");
            System.out.println("3. Ver ranking");
            System.out.println("4. Ver reto semanal");
            System.out.println("5. Ver recompensas");
            System.out.println("6. Canjear recompensa");
            System.out.println("7. Cambiar de usuario");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("¿Qué artículo deseas reciclar?");
                    System.out.println("1. Botella plástica");
                    System.out.println("2. Papel");
                    System.out.println("3. Cartón");
                    System.out.println("4. Otro (no reciclable)");
                    System.out.print("Opción: ");
                    tipo = teclado.nextInt();
                    teclado.nextLine();

                    if (tipo == 1) {
                        articulo = "botella";
                        System.out.println("Selecciona el tamaño de la botella:");
                        System.out.println("a. Pequeña (1 punto)");
                        System.out.println("b. Mediana (2 puntos)");
                        System.out.println("c. Grande (3 puntos)");
                        System.out.print("Tamaño: ");
                        String tam = teclado.nextLine();

                        System.out.print("¿Cuántas reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();

                        switch (tam.toLowerCase()) {
                            case "a": puntosGanados = 1; break;
                            case "b": puntosGanados = 2; break;
                            case "c": puntosGanados = 3; break;
                            default:
                                System.out.println("Tamaño inválido. Se asignará 1 punto por defecto");
                                puntosGanados = 1;
                        }
                    } else if (tipo == 2) {
                        articulo = "papel";
                        puntosGanados = 1;
                        System.out.print("¿Cuántos reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();
                    } else if (tipo == 3) {
                        articulo = "cartón";
                        puntosGanados = 2;
                        System.out.print("¿Cuántos reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();
                    } else {
                        articulo = "otro";
                        puntosGanados = -2;
                        cantidad = 1;
                        System.out.println("Ese artículo no es reciclable. Pierdes 2 puntos.");
                    }

                    Reto reto = gestor.getRetoSemanal();
                    usuario.reciclar(articulo, cantidad, puntosGanados, reto);
                    break;

                case 2:
                    usuario.mostrarEstado();
                    break;

                case 3:
                    gestor.mostrarRanking();
                    break;

                case 4:
                    Reto retoSemanal = gestor.getRetoSemanal();
                    System.out.println("Reto semanal: " + retoSemanal.getDescripcion());
                    System.out.println("Progreso: " + retoSemanal.getProgreso() + "/" + retoSemanal.getObjetivo());
                    if (retoSemanal.completado()) {
                        System.out.println("Reto completado");
                    }
                    break;

                case 5:
                    gestor.mostrarRecompensas();
                    break;

                case 6:
                    gestor.mostrarRecompensas();
                    System.out.print("¿Qué recompensa deseas canjear?: ");
                    String recompensa = teclado.nextLine();
                    gestor.canjearRecompensa(usuario, recompensa);
                    break;

                case 7:
                    usuario = null;
                    while (usuario == null) {
                        System.out.println("¿Deseas (1) Iniciar sesión o (2) Registrarte?");
                        int tipoSesion = teclado.nextInt();
                        teclado.nextLine();
                        System.out.print("Nombre de usuario: ");
                        nuevoNombre = teclado.nextLine();
                        if (tipoSesion == 1) {
                            usuario = gestor.buscarUsuario(nuevoNombre);
                            if (usuario == null) {
                                System.out.println("Usuario no encontrado.");
                            }
                        } else {
                            usuario = gestor.registrarUsuario(nuevoNombre);
                            System.out.println("Nuevo usuario creado");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Gracias por reciclar");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 8);

    }
}