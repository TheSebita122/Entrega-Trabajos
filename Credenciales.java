import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Patron Prototype

public class Credenciales implements Cloneable {
    private String nombre;
    private String cargo;
    private String rut;

    public Credenciales(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public Credenciales clone() {
        try {
            return (Credenciales) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cargo: " + cargo + " | RUT: " + rut;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Credenciales> listaCredenciales = new ArrayList<>();
        Credenciales plantilla = new Credenciales("Plantilla", "Cargo Base", "RUT Base");

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
                Credenciales clon = plantilla.clone();
                    System.out.print("Ingrese el nombre: ");
                    clon.setNombre(scanner.nextLine());
                    System.out.print("Ingrese el cargo: ");
                    clon.setCargo(scanner.nextLine());
                    System.out.print("Ingrese el RUT: ");
                    clon.setRut(scanner.nextLine());

                    listaCredenciales.add(clon);
                    System.out.println("Credencial agregada exitosamente.");
                    break;

                case 2:
                    if (listaCredenciales.isEmpty()) {
                        System.out.println("No hay credenciales generadas.");
                    } else {
                        System.out.println("\nCredenciales generadas:");
                        for (Credenciales c : listaCredenciales) {
                            System.out.println(c);
                        }
                    }
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