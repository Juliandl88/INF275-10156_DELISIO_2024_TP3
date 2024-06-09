import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* Clase principal - Menú  */
/* Los datos de usuarios, alojamientos y reservas se guardan en distintos ArrayList */
public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Alojamiento> alojamientos = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opción;

        do {
            System.out.println("\nBienvenido al sistema de alojamientos Airbnb \n");
            System.out.println("Menú: \n");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Alojamiento");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Buscar Alojamiento por ID");
            System.out.println("5. Agregar Comentario a Alojamiento");
            System.out.println("6. Salir \n");
            System.out.print("Seleccione una opción:  ");
            
            opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    registrarAlojamiento(scanner);
                    break;
                case 3:
                    realizarReserva(scanner);
                    break;
                case 4:
                    buscarAlojamientoPorId(scanner);
                    break;
                case 5:
                    agregarComentario(scanner);
                    break;
                case 6:
                    System.out.println("\nMuchas gracias por usar los servicios de Airbnb");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
            }
        } while (opción != 6);

        scanner.close();
    }

    /* Método para registrar usuarios nuevos  */
    private static void registrarUsuario(Scanner scanner) {
        System.out.print("\nRegistro de Usuario ");
        System.out.print("\nIngrese ID: ");
        String id = scanner.next();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.next();

        Usuario usuario = new Usuario(id, nombre, correo, contraseña);
        usuarios.add(usuario);
        System.out.println("\nUsuario registrado exitosamente.");
    }

    /* Método para registrar alojamientos nuevos  */
    private static void registrarAlojamiento(Scanner scanner) {
        System.out.print("\nRegistro de Alojamiento\n ");
        scanner.nextLine(); // Consume la nueva línea pendiente
        System.out.print("\nIngrese ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese título: ");
        String título = scanner.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripción = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String dirección = scanner.nextLine();
        System.out.print("Ingrese precio por noche: ");
        double precioPorNoche = scanner.nextDouble();

        Alojamiento alojamiento = new Alojamiento(id, título, descripción, dirección, precioPorNoche);
        alojamientos.add(alojamiento);
        System.out.println("\nAlojamiento registrado exitosamente.");
    }

    /* Método para realizar reserva nuevos  */
    private static void realizarReserva(Scanner scanner) {
        System.out.print("\nRealizar reserva\n");
        scanner.nextLine(); // Consume la nueva línea pendiente
        System.out.print("\nIngrese ID de usuario: ");
        String idUsuario = scanner.nextLine();
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("\nUsuario no encontrado.");
            return;
        }

        System.out.print("Ingrese ID de alojamiento: ");
        String idAlojamiento = scanner.nextLine();
        Alojamiento alojamiento = buscarAlojamientoPorId(idAlojamiento);
        if (alojamiento == null) {
            System.out.println("\nAlojamiento no encontrado.");
            return;
        }

        System.out.print("Ingrese fecha de inicio (yyyy-MM-dd): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.print("Ingrese fecha de fin (yyyy-MM-dd): ");
        String fechaFinStr = scanner.nextLine();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = formatoFecha.parse(fechaInicioStr);
            Date fechaFin = formatoFecha.parse(fechaFinStr);

            Reserva reserva = new Reserva("1", usuario, alojamiento, fechaInicio, fechaFin);
            reservas.add(reserva);
            System.out.println("\nReserva realizada exitosamente.");
        } catch (ParseException e) {
            System.out.println("\nFormato de fecha incorrecto.");
        }
    }

    /* Método para buscar alojamientos por ID  */
    private static void buscarAlojamientoPorId(Scanner scanner) {
        System.out.print("\nBuscar Alojamiento por Identificación\n");
        scanner.nextLine(); // Consume la nueva línea pendiente
        System.out.print("\nIngrese ID de alojamiento: ");
        String idAlojamiento = scanner.nextLine();
        Alojamiento alojamiento = buscarAlojamientoPorId(idAlojamiento);
        if (alojamiento != null) {
            System.out.println("\nAlojamiento encontrado:\n");
            System.out.println("Título: " + alojamiento.getTítulo());
            System.out.println("Descripción: " + alojamiento.getDescripción());
            System.out.println("Dirección: " + alojamiento.getDirección());
            System.out.println("Precio por noche: " + alojamiento.getPrecioPorNoche());
        } else {
            System.out.println("\nAlojamiento no encontrado.");
        }
    }

    /* Método para registrar comentarios sobre alojamientos  */
    private static void agregarComentario(Scanner scanner) {
        
        scanner.nextLine(); // Consume la nueva línea pendiente
        System.out.print("\nComentá tu expreiencia en el alojamiento\n");
        System.out.print("\nIngrese ID de usuario: ");
        String idUsuario = scanner.nextLine();
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("\nUsuario no encontrado.");
            return;
        }

        System.out.print("\nIngrese ID de alojamiento: ");
        String idAlojamiento = scanner.nextLine();
        Alojamiento alojamiento = buscarAlojamientoPorId(idAlojamiento);
        if (alojamiento == null) {
            System.out.println("\nAlojamiento no encontrado.");
            return;
        }

        System.out.print("\nIngrese texto del comentario: ");
        String texto = scanner.nextLine();
        System.out.print("\nIngrese calificación (0-5): ");
        int calificación = scanner.nextInt();

        Comentario comentario = new Comentario("1", usuario, texto, calificación);
        alojamiento.agregarComentario(comentario);
        System.out.println("\nMuchas gracias por dejarnos tu comentario.");
    }

    private static Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    private static Alojamiento buscarAlojamientoPorId(String id) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getId().equals(id)) {
                return alojamiento;
            }
        }
        return null;
    }
}
