import java.util.ArrayList;
import java.util.Scanner;

/* diferencia python y java es que en java todo debe estar dentro de clases mientras que en python
el codigo puede funcionar asi todo suelto, ademas java posee un tipado mas estricto q python  */

public class main {

    public static void public(String[] args) {
        ArrayList<vehiculo> listaVehiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (salir)
            System.out.println("----- TALLER MECANICO -----");
            System.out.println("1. registro de vehiculos");
            System.out.println("2. listar vehiculos");
            System.out.println("3. buscar vehiculos por patente");
            System.out.println("4. realizar revision");
            System.out.println("5. resumen de vehiculos");
            System.out.println("6. salir");
            System.out.print("Seleccione una opcion: ");

            String inputopcion = scanner.nextLine();
            int opcion;

            try {
                opcion = Integer.parseInt(inputopcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: ingresa un numero valido ");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarvehiculo(scanner, listaVehiculos);
                    break;
                case 2:
                    listarvehiculos(listaVehiculos);
                    break;
                case 3:
                    buscarvehiculo(scanner, listaVehiculos);
                    break;
                case 4:
                    realizarrevision(scanner, listaVehiculos);
                    break;
                case 5:
                    mostrarresumen(listaVehiculos);
                    break;
                case 6:
                    salir = true;
                    System.out.println("El programa ha finalizado");
                    break;
                default:
                    System.out.println("Opcion invalida, intentalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

private static void registrarvehiculo(Scanner scanner, ArrayList<vehiculo> lista) {
        System.out.println("- tipo de vehiculo -");
        System.out.println("1: particular");
        System.out.println("2: carga ");
        System.out.println("seleccione: ");

        String tipoInput = scanner.nextLine();
        int tipo;
        try {
            tipo = Integer.parseInt(tipoInput);
            if (tipo != 1 && tipo != 2) {
                System.out.println("tipo de vehiculo incorrecto");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error: debes ingresar un numero valido");
            return; 


        }
        
        System.out.print("patente: ");
        String patente = scanner.nextLine();
        System.out.print("marca: ");
        String marca = scanner.nextLine();

        int pendientes;
        try {
            System.out.print("revisiones pendientes: ");
            pendientes = Integer.parseInt(scanner.nextLine());
            if (pendientes < 0) {
                System.out.println("error: las revisiones no pueden ser negativas");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("error: debes ingresar un numero valido");
            return;
        }  

        if (tipo == 1) {
            try {
                System.out.print("numero de pasajeros: ");
                int pasajeros = Integer.parseInt(scanner.nextLine());
                if (pasajeros <= 0) {
                    System.out.println("error: el numero de pasajeros debe ser positivo");
                    return;
                }
                lista.add(new vehiculoparticular(patente, marca, pendientes, pasajeros));
                System.out.println("vehiculo particular registrado correctamente");
            } catch (NumberFormatException e) {
                System.out.println("error: debe ingresar un numero valido");
            }
        } else {
            try {
                System.out.print("peso maximo carga (en kg): ");
                int carga_maxima = Integer.parseInt(scanner.nextLine());
                if (carga_maxima <= 0);
                    System.out.println("error: el peso debe ser un entero positivo");
                    return;
            }
            lista.add(new vehiculocarga(patente, marca, pendientes, pendientes));
            System.out.println("vehiculo de carga registrado correctamente");
        } catch (NumberFormatException e) {
            System.out.println(" error: debe ser un numero valido");
        }
    }
}    

/* todo error */