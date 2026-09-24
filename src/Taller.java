import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
    static ArrayList<VehiculoParticular> coleccionvehiculosparticular = new ArrayList<>();
    static ArrayList<VehiculoCarga> coleccionvehiculoscarga = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarMenu();
    }

    static void MostrarMenu() {
        boolean bucle_menu = true;
        System.out.println("=== TALLER MECANICO ===");
        while (bucle_menu) {
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revisión");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción: ");
            String opcion_usuario = sc.nextLine();
            switch (opcion_usuario) {
                case "1":
                    RegistrarVehiculo();
                    break;
                case "2":
                    ListarVehiculos();
                    break;
                case "3":
                    BuscarVehiculoPorPatente();
                    break;
                case "4":
                    RealizarRevision();
                    break;
                case "5":
                    ResumenDeVehiculos();
                    break;
                case "6":
                    bucle_menu = false;
                    break;
                default:
                    System.out.println("ERROR: Ingrese una opción del 1 al 6.");
                    break;
            }
        }
    }

    static void RegistrarVehiculo() {
        boolean bucle_menu = true;
        System.out.println(("--- Tipo de vehiculo ---"));
        while (bucle_menu) {
            System.out.println("1. Vehiculo Particular");
            System.out.println("2. Vehiculo Carga");
            System.out.println("3. Salir");
            System.out.println("Ingrese el tipo de vehiculo: ");
            String opcion_usuario = sc.nextLine();
            switch (opcion_usuario) {
                case "1":
                    RegistrarVehiculoParticular();
                    break;
                case "2":
                    RegistrarVehiculoCarga();
                    break;
                case "3":
                    bucle_menu = false;
                    break;
                default:
                    System.out.println("ERROR. Ingrese una opción del 1 al 3");
                    break;
            }
        }
    }

    static void RegistrarVehiculoParticular() {
        try {
            // PATENTE
            System.out.println("Patente: ");
            String patente = sc.nextLine();
            // MARCA
            System.out.println("Marca: ");
            String marca = sc.nextLine();
            // REVISIONES PENDIENTES
            System.out.println("Revisiones pendientes: ");
            int revisionesPendientes = Integer.parseInt(sc.nextLine());
            // NUMERO DE PASAJEROS
            System.out.println("Número de pasajeros: ");
            int numPasajeros = Integer.parseInt(sc.nextLine());
            // AGREGAR EL VEHICULO PARTICULAR A SU COLECCIÓN
            VehiculoParticular vehiculoParticular = new VehiculoParticular(patente, marca, revisionesPendientes,
                    numPasajeros);
            coleccionvehiculosparticular.add(vehiculoParticular);
        } catch (NumberFormatException e) {
            System.out.println("ERROR. Ingrese un número entero positivo mayor a 0");
        }

    }

    static void RegistrarVehiculoCarga() {
        try {
            // PATENTE
            System.out.println("Patente: ");
            String patente = sc.nextLine();
            // MARCA
            System.out.println("Marca: ");
            String marca = sc.nextLine();
            // REVISIONES PENDIENTES
            System.out.println("Revisiones pendientes: ");
            int revisionesPendientes = Integer.parseInt(sc.nextLine());
            // PESO MAXIMO DE CARGA
            System.out.println("Peso maximo de carga (kg): ");
            int pesoMaxCarga = Integer.parseInt(sc.nextLine());
            // AGREGAR EL VEHICULO CARGA A SU COLECCIÓN
            VehiculoCarga VehiculoCarga = new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga);
            coleccionvehiculoscarga.add(VehiculoCarga);
        } catch (NumberFormatException e) {
            System.out.println("ERROR. Ingrese un número enero positivo mayor a 0");
        }

    }

    static void ListarVehiculos() {
        if ((coleccionvehiculoscarga.isEmpty() && coleccionvehiculosparticular.isEmpty()) == true) {
            System.out.println(
                    "ERROR. Nuestra base de datos se encuentra vacía, ingrese datos con la 'OPCIÓN 1' para poder listarlos.");
        } else {
            for (VehiculoCarga vehiculoCarga : coleccionvehiculoscarga) {
                System.out.println(vehiculoCarga.mostrarInfo());
            }
            for (VehiculoParticular vehiculoParticular : coleccionvehiculosparticular) {
                System.out.println(vehiculoParticular.mostrarInfo());
            }
        }
    }

    static void BuscarVehiculoPorPatente() {
        if ((coleccionvehiculoscarga.isEmpty() && coleccionvehiculosparticular.isEmpty()) == true) {
            System.out.println(
                    "ERROR. Nuestra base de datos se encuentra vacía, ingrese datos con la 'OPCIÓN 1' para poder listarlos.");
        } else {
            System.out.println("Ingrese la patente del vehiculo: ");
            String patete_a_buscar = sc.nextLine();
            for (VehiculoCarga vehiculoCarga : coleccionvehiculoscarga) {
                if (vehiculoCarga.getPatente().contains(patete_a_buscar)) {
                    System.out.println(vehiculoCarga.mostrarInfo());
                }
            }
            for (VehiculoParticular vehiculoParticular : coleccionvehiculosparticular) {
                if (vehiculoParticular.getPatente().contains(patete_a_buscar)) {
                    System.out.println(vehiculoParticular.mostrarInfo());
                }
            }
        }
    }

    static void RealizarRevision() {
        int contador = 1;
        for (VehiculoCarga vehiculoCarga : coleccionvehiculoscarga) {
            System.out.println("[" + contador + "]" + vehiculoCarga.getPatente() + " | " + vehiculoCarga.getMarca());
            contador += 1;
        }
        for (VehiculoParticular vehiculoParticular : coleccionvehiculosparticular) {
            System.out.println("[" + contador + "]" + vehiculoParticular.getPatente() + " | " + vehiculoParticular.getMarca());
            contador += 1;
        }
        System.out.println("Ingrese la patente del vehiculo al que desea realizarle la revisión: ");
        String patete_a_buscar = sc.nextLine();
            for (VehiculoCarga vehiculoCarga : coleccionvehiculoscarga) {
                if (vehiculoCarga.getPatente().contains(patete_a_buscar)) {
                    int revisionesPendientes = vehiculoCarga.getRevisionesPendientes();
                    revisionesPendientes -= 1;
                    vehiculoCarga.setRevisionesPendientes(revisionesPendientes);
                }
            }
            for (VehiculoParticular vehiculoParticular : coleccionvehiculosparticular) {
                if (vehiculoParticular.getPatente().contains(patete_a_buscar)) {
                    int revisionesPendientes = vehiculoParticular.getRevisionesPendientes();
                    revisionesPendientes -= 1;
                    vehiculoParticular.setRevisionesPendientes(revisionesPendientes);
                }
            }
    }

    static void ResumenDeVehiculos() {
        if ((coleccionvehiculoscarga.isEmpty() && coleccionvehiculosparticular.isEmpty()) == true) {
            System.out.println(
                    "ERROR. Nuestra base de datos se encuentra vacía, ingrese datos con la 'OPCIÓN 1' para poder listarlos.");
        } else {
            int total_vehiculos = (coleccionvehiculosparticular.size() + coleccionvehiculoscarga.size());
            int total_vehiculos_particulares = coleccionvehiculosparticular.size();
            int total_vehiculos_de_carga = coleccionvehiculoscarga.size();
            int ingresos_proyectados = 0;
            for (VehiculoCarga vehiculoCarga : coleccionvehiculoscarga) {
                ingresos_proyectados += vehiculoCarga.calcularCostoRevision();
            }
            for (VehiculoParticular vehiculoParticular : coleccionvehiculosparticular) {
                ingresos_proyectados += vehiculoParticular.calcularCostoRevision();
            }
            System.out.println("Total vehiculos: " + total_vehiculos);
            System.out.println("Vehiculos particulares: " + total_vehiculos_particulares);
            System.out.println("Vehiculos de carga: " + total_vehiculos_de_carga);
            System.out.println("Ingresos proyectados: " + ingresos_proyectados);
        }
    }
}
