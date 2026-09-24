import java.util.ArrayList;
import java.util.Scanner;

/* la diferencia entre python y java es que python es mas estricto en varios aspectos, incluso en el tipeado, python es mas suelto y sus codigos no dependen de clases padres ni de otros archivos, como ahora que para que funcione este menu
el programa debe estar dentro de una carpetita "source" junto a los demas archivos*/

public class main {
    public static void main(String[] args) {
        ArrayList<vehiculo> listaVehiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) { 
            System.out.println("- TALLER MECANICO -");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            String inputOpcion = scanner.nextLine();
            int opcion;

            try {
                opcion = Integer.parseInt(inputOpcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner, listaVehiculos);
                    break;
                case 6:
                    salir = true;
                    System.out.println("programa finalizado, cerrando...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente."); 
                    break;
            }
        }
        scanner.close();
    }

    private static void registrarVehiculo(Scanner scanner, ArrayList<vehiculo> lista) {
        System.out.println("\n--- Tipo de vehiculo ---");
        System.out.println("1. Particular");
        System.out.println("2. Carga");
        System.out.print("Seleccione: ");
        
        String tipoInput = scanner.nextLine();
        int tipo;
        try {
            tipo = Integer.parseInt(tipoInput);
            if (tipo != 1 && tipo != 2) {
                System.out.println("Error: Tipo de vehiculo invalido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero valido.");
            return;
        }

        System.out.print("Patente: ");
        String patente = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        int revisiones_pendientes;
        try {
            System.out.print("Revisiones revisiones_pendientes: ");
            revisiones_pendientes = Integer.parseInt(scanner.nextLine());
            if (revisiones_pendientes < 0) {
                System.out.println("Error: Las revisiones no pueden ser negativas.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero valido.");
            return;
        }

        if (tipo == 1) {
            try {
                System.out.print("Numero de pasajeros: ");
                int pasajeros = Integer.parseInt(scanner.nextLine());
                if (pasajeros <= 0) {
                    System.out.println("Error: El numero de pasajeros debe ser positivo."); 
                    return;
                }
                lista.add(new vehiculoparticular(patente, marca, revisiones_pendientes, pasajeros));
                System.out.println(" vehiculo particular registrado.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
            }
        } else {
            try {
                System.out.print("carga_maxima maximo de carga (kg): ");
                int carga_maxima = Integer.parseInt(scanner.nextLine());
                if (carga_maxima <= 0) {
                    System.out.println("Error: El carga_maxima debe ser un entero positivo.");
                }
                lista.add(new vehiculocarga(patente, marca, revisiones_pendientes, carga_maxima));
                System.out.println(" vehiculo de carga registrado.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
            }
        }
    }
}

