import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Patron Singleton
public class Credenciales2 {
    private String nombre;
    private String cargo;
    private String rut;

    private Credenciales2(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cargo: " + cargo + " | RUT: " + rut;
    }

    public static class CredencialManager {
        private static CredencialManager instance;
        private final List<Credenciales2> listaCredenciales = new ArrayList<>();
        private final Credenciales2 plantilla = new Credenciales2("Plantilla", "Cargo Base", "RUT Base");

        private CredencialManager() {}

        // Método para obtener la instancia única
        public static CredencialManager getInstance() {
            if (instance == null) {
                instance = new CredencialManager();
            }
            return instance;
        }
        public void agregarCredencial(String nombre, String cargo, String rut) {
            Credenciales2 nuevaCredencial = new Credenciales2(nombre, cargo, rut);
            listaCredenciales.add(nuevaCredencial);
            System.out.println("Credencial agregada exitosamente.");
        }

        public void mostrarCredenciales() {
            if (listaCredenciales.isEmpty()) {
                System.out.println("No hay credenciales generadas.");
            } else {
                System.out.println("\nCredenciales generadas:");
                for (Credenciales2 c : listaCredenciales) {
                    System.out.println(c);
                }
            }
        }

        public Credenciales2 clonarPlantilla() {
            return new Credenciales2(plantilla.nombre, plantilla.cargo, plantilla.rut);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CredencialManager manager = CredencialManager.getInstance();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar nueva credencial");
            System.out.println("2. Ver credenciales generadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Ingrese el RUT: ");
                    String rut = scanner.nextLine();

                    manager.agregarCredencial(nombre, cargo, rut);
                    break;

                case 2:
                    manager.mostrarCredenciales();
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
