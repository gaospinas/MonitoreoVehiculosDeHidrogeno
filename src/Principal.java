import java.util.Scanner;

public class Principal {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static User userActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Gestionar Perfil (solo si está logueado)");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    iniciarSesion(scanner);
                    break;
                case 3:
                    if (userActual != null) {
                        gestionarPerfil(scanner);
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Registrar un nuevo usuario
    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese un nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        User nuevoUser = new User(username, password, email, nombre);
        if (usuarioDAO.registrarUsuario(nuevoUser)) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Error al registrar el usuario.");
        }
    }

    // Iniciar sesión
    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        User user = usuarioDAO.iniciarSesion(username, password);
        if (user != null) {
            userActual = user;
            System.out.println("Inicio de sesión exitoso. Bienvenido " + user.getNombre());
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    // Gestionar perfil del usuario actual
    private static void gestionarPerfil(Scanner scanner) {
        System.out.println("\n--- Gestión de Perfil ---");
        System.out.println("Nombre: " + userActual.getNombre());
        System.out.println("Email: " + userActual.getEmail());

        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Contraseña");
        System.out.println("2. Email");
        System.out.println("3. Nombre");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese su nueva contraseña: ");
                String nuevaPassword = scanner.nextLine();
                userActual.setPassword(nuevaPassword);
                break;
            case 2:
                System.out.print("Ingrese su nuevo email: ");
                String nuevoEmail = scanner.nextLine();
                userActual.setEmail(nuevoEmail);
                break;
            case 3:
                System.out.print("Ingrese su nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                userActual.setNombre(nuevoNombre);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        // Actualizar en la base de datos
        if (usuarioDAO.actualizarUsuario(userActual)) {
            System.out.println("Perfil actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar el perfil.");
        }
    }
}
