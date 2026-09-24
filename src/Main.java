// Paradigma: Programación Orientada a Objetos (POO)
// Características: Funciona en base a clases (categorías como Vehiculo) y objetos (instancias particulares como miAuto).
// 
// Diferencias con Python funcional:
// 1. Tipado y Estructura: En Java cada clase es un tipo de dato estricto y el código debe vivir dentro de clases, a diferencia de los scripts funcionales de Python.
// 2. Encapsulamiento: Java usa modificadores (public, private) para proteger los datos, mientras que en Python el acceso suele ser más abierto por defecto.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;
        cargarDatosDePrueba();

        while (flag) {
            mostrarMenu();
            String eleccionUsuario = sc.nextLine();

            switch (eleccionUsuario) {
                case "1": registrarVehiculo(); break;
                case "2": listarVehiculos(); break;
                case "3": buscarVehiculo(); break;
                case "4": realizarRevision(); break;
                case "5": resumenVehiculos(); break;
                case "6": flag = false; break;
                default:
                    System.out.println("Debe ingresar una opción válida.");
                    break;
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("=== TALLER MECÁNICO ===");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Listar vehículos");
        System.out.println("3. Buscar vehículo por patente");
        System.out.println("4. Realizar revisión");
        System.out.println("5. Resumen de vehículos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static void registrarVehiculo() {
        boolean flagSubmenu = true;
        while (flagSubmenu) {
            System.out.println("=== REGISTRO DE VEHÍCULOS ===");
            System.out.println("1. Registrar vehículo particular");
            System.out.println("2. Registrar vehículo de carga");
            System.out.println("3. Volver al menú");
            System.out.print("Ingrese una opción: ");
            String eleccionUsuario = sc.nextLine();

            if (eleccionUsuario.equals("3")) {
                flagSubmenu = false;
                continue;
            }

            if (!eleccionUsuario.equals("1") && !eleccionUsuario.equals("2")) {
                System.out.println(" Tiene ingresar una opción válida.");
                continue;
            }

            System.out.print("Ingrese la patente del vehículo: ");
            String patente = sc.nextLine();
            System.out.print("Ingrese la marca del vehículo: ");
            String marca = sc.nextLine();
            int revisionesPendientes = 0;

            try {
                System.out.print("Ingrese el número de revisiones pendientes: ");
                int revisiones = Integer.parseInt(sc.nextLine());
                if (revisiones < 0) {
                    System.out.println(" Debe ingresar un número mayor o igual a 0.");
                    continue;
                }
                revisionesPendientes = revisiones;
            } catch (NumberFormatException e) {
                System.out.println(" Debe ingresar un número.");
                continue;
            }

            if (eleccionUsuario.equals("1")) {
                try {
                    System.out.print("Ingrese el número de pasajeros del vehículo: ");
                    int numPasajeros = Integer.parseInt(sc.nextLine());
                    if (numPasajeros <= 0) {
                        System.out.println(" Debe ingresar un número positivo.");
                        continue;
                    }
                    listaVehiculos.add(new VehiculoParticular(patente, marca, revisionesPendientes, numPasajeros));
                    System.out.println(" Vehículo particular registrado exitosamente.");
                    flagSubmenu = false;
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número.");
                }
            } else if (eleccionUsuario.equals("2")) {
                try {
                    System.out.print("Ingrese el peso máximo de carga en kg: ");
                    int pesoMaxCarga = Integer.parseInt(sc.nextLine());
                    if (pesoMaxCarga <= 0) {
                        System.out.println("Debe ingresar un número positivo.");
                        continue;
                    }
                    listaVehiculos.add(new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga));
                    System.out.println("Vehículo de carga registrado exitosamente.");
                    flagSubmenu = false;
                } catch (NumberFormatException e) {
                    System.out.println(" Debe ingresar un número.");
                }
            }
        }
    }

    static void listarVehiculos() {
        System.out.println("\n=== LISTA DE VEHÍCULOS ===");
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados actualmente.");
        } else {
            for (Vehiculo vehiculo : listaVehiculos) {
                System.out.println(vehiculo.mostrarInfo());
            }
        }
    }

    static void buscarVehiculo() {
        System.out.println("=== BÚSQUEDA DE VEHÍCULOS ===");
        System.out.print("Ingrese texto a buscar (patente): ");
        String patenteABuscar = sc.nextLine().toLowerCase();
        boolean hayResultados = false;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().toLowerCase().contains(patenteABuscar)) {
                System.out.println(vehiculo.mostrarInfo());
                hayResultados = true;
            }
        }

        if (!hayResultados) {
            System.out.println("No se encontraron patentes que coincidan con la búsqueda.");
        }
    }

    static void realizarRevision() {
    System.out.println("=== REVISIÓN DE VEHÍCULOS ===");
    if (listaVehiculos.isEmpty()) {
        System.out.println("No hay vehículos para revisar.");
        return;
    }

    for (int i = 0; i < listaVehiculos.size(); i++) {
        System.out.println("[" + i + "] " + listaVehiculos.get(i).getPatente() + " " + listaVehiculos.get(i).getMarca() + " (Pendientes: " + listaVehiculos.get(i).getRevisionesPendientes() + ")");
    }

    System.out.print("Ingrese el el numero de lista indicado del vehículo a revisar: ");
    try {
        int indice = Integer.parseInt(sc.nextLine());
        if (indice < 0 || indice >= listaVehiculos.size()) {
            System.out.println("Debe ingresar un numero de losta valido válido.");
        } else if (listaVehiculos.get(indice).getRevisionesPendientes() <= 0) {
            System.out.println("Este vehículo no tiene revisiones pendientes.");
        } else {
            
            
            int revisiones = listaVehiculos.get(indice).getRevisionesPendientes();
            listaVehiculos.get(indice).setRevisionesPendientes(revisiones - 1);

            System.out.println("Revisión realizada.");
            System.out.println("Vehículo: " + listaVehiculos.get(indice).getPatente() + " " + listaVehiculos.get(indice).getMarca());
            System.out.println("Costo de la revisión: $" + listaVehiculos.get(indice).calcularCostoRevision());
            System.out.println("Revisiones pendientes: " + listaVehiculos.get(indice).getRevisionesPendientes());
        }
    } catch (NumberFormatException e) {
        System.out.println("Debe ingresar un número válido.");
    }
}

    static void resumenVehiculos() {
        System.out.println("=== RESUMEN DE VEHÍCULOS ===");
        int vehiculosParticulares = 0;
        int vehiculosCarga = 0;
        int ingresosProyectados = 0;

        for (Vehiculo vehiculo : listaVehiculos) {
            ingresosProyectados += (vehiculo.calcularCostoRevision() * vehiculo.getRevisionesPendientes());
            if (vehiculo instanceof VehiculoParticular) {
                vehiculosParticulares++;
            } else if (vehiculo instanceof VehiculoCarga) {
                vehiculosCarga++;
            }
        }

        System.out.println("Total de vehículos registrados: " + listaVehiculos.size());
        System.out.println("Vehículos particulares: " + vehiculosParticulares);
        System.out.println("Vehículos de carga: " + vehiculosCarga);
        System.out.println("Ingresos proyectados: $" + ingresosProyectados);
    }

    static void cargarDatosDePrueba() {
        listaVehiculos.add(new VehiculoParticular("ABCD12", "Toyota", 2, 5));
        listaVehiculos.add(new VehiculoCarga("WXYZ99", "Volvo", 1, 3500));
    }
}