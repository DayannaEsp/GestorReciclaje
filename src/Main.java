import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorReciclaje gestor = new GestorReciclaje();
        int opcionInicio, tipo, cantidad = 0, puntosGanados = 0, caneca, recompensa;
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
                    System.out.println("4. Servilletas");
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
                        System.out.println("¿En que caneca va ese material?");
                        System.out.println("1. Amarillo");
                        System.out.println("2. Azul");
                        System.out.println("3. Verde");
                        System.out.println("4. Gris");
                        System.out.println("Elije una opción: ");
                        caneca = teclado.nextInt();
                        teclado.nextLine();

                        if(caneca !=1){
                            System.out.println("Incorrecto. Las botellas plasticas van en la caneca azul. Pierdes 2 puntos por cada botella");
                            puntosGanados = -2;
                        }

                    } else if (tipo == 2) {
                        articulo = "papel";
                        puntosGanados = 1;
                        System.out.print("¿Cuántos reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("¿En que caneca va ese material?");
                        System.out.println("1. Amarillo");
                        System.out.println("2. Azul");
                        System.out.println("3. Verde");
                        System.out.println("4. Gris");
                        System.out.println("Elije una opción: ");
                        caneca = teclado.nextInt();
                        teclado.nextLine();

                        if(caneca !=2){
                            System.out.println("Incorrecto. El papel va en la caneca azul. Pierdes 2 puntos por cada papel");
                            puntosGanados = -2;
                        }

                    } else if (tipo == 3) {
                        articulo = "cartón";
                        puntosGanados = 2;
                        System.out.print("¿Cuántos reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("¿En que caneca va ese material?");
                        System.out.println("1. Amarillo");
                        System.out.println("2. Azul");
                        System.out.println("3. Verde");
                        System.out.println("4. Gris");
                        System.out.println("Elije una opción: ");
                        caneca = teclado.nextInt();
                        teclado.nextLine();

                        if(caneca !=2){
                            System.out.println("Incorrecto. El cartón va en la caneca azul. Pierdes 2 puntos por cada cartón");
                            puntosGanados = -2;
                        }

                    } else if (tipo ==4) {
                        articulo = "servilletas";
                        System.out.print("¿Cuántos reciclaste?: ");
                        cantidad = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("¿En que caneca va ese material?");
                        System.out.println("1. Amarillo");
                        System.out.println("2. Azul");
                        System.out.println("3. Verde");
                        System.out.println("4. Gris");
                        System.out.println("Elije una opción: ");
                        caneca = teclado.nextInt();
                        teclado.nextLine();

                        if(caneca == 4){
                            System.out.println("Correcto. Las servilletas van en la caneca gris, pero al ser un material no reciclable no se te dara ningun punto.");
                            puntosGanados=0;
                        }else if(caneca !=4){
                            System.out.println("Incorrecto. Las servilletas van en la caneca gris, además no son reciclables. Pierdes 5 puntos por cada servilleta");
                            puntosGanados=-5;
                        }
                    }

                    Reto reto = gestor.getRetoSemanal();
                    usuario.reciclar(articulo, cantidad, puntosGanados);
                    break;

                case 2:
                    usuario.mostrarEstado();
                    break;

                case 3:
                    gestor.mostrarRanking();
                    break;

                case 4:
                    Reto retoUsuario = usuario.getRetoAsignado();
                    System.out.println("Reto semanal: " + retoUsuario.getDescripcion());
                    System.out.println("Progreso: " + retoUsuario.getProgreso() + "/" + retoUsuario.getObjetivo());
                    if (retoUsuario.completado()) {
                        System.out.println("Reto completado");
                    }
                    break;

                case 5:
                    gestor.mostrarRecompensas();
                    break;

                case 6:
                    gestor.mostrarRecompensas();
                    System.out.print("¿Qué recompensa deseas canjear?: ");
                    recompensa = teclado.nextInt();
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