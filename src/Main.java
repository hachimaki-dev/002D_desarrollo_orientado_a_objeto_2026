// Paradigma: Programación Orientada a Objetos (POO)
//
// Características principales:
// La POO está caracterizada por funcionar en base a un sistema de clases y objetos, donde una clase corresponde a una categoría (animal, auto, alumno),
// y un objeto corresponde a una instancia particular de esa clase (miPerro, miAuto, selenaFigueroa).
//
// Diferencias con la programación funcional:
// 1. En POO, cada clase es tratada como un tipo de dato nuevo, a diferencia de la programación funcional donde solo se usan los tipos de datos primitivos (int, float, string, etc.)
// 2. La POO evita el acceso indebido a los datos de un programa mediante las palabras clave *public*, *protected* y *private*, evitando que cualquier parte del código pueda
// editar el valor de una variable y asegurándose de que el programador cree validaciones para cambiar un valor.

package src;

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
                case "1":
                    registrarVehiculo();
                    break;

                case "2":
                    listarVehiculos();
                    break;

                case "3":
                    buscarVehiculo();
                    break;

                case "4":
                    realizarRevision();
                    break;

                case "5":
                    resumenVehiculos();
                    break;

                case "6":
                    flag = false;
                    break;

                default:
                    System.out.println("ERROR: Debe ingresar una opción válida.");
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
        System.out.println("Seleccione una opción:");
    }

    static void registrarVehiculo() {
        boolean flagSubmenu = true;
        while (flagSubmenu) {
            System.out.println("=== REGISTRO DE VEHÍCULOS ===");
            System.out.println("1. Registrar vehículo particular");
            System.out.println("2. Registrar vehículo de carga");
            System.out.println("3. Volver al menú");
            System.out.println("Ingrese una opción: ");
            String eleccionUsuario = sc.nextLine();

            String patente;
            String marca;
            int revisionesPendientes;

            switch (eleccionUsuario) {
                case "1":
                    // Patente
                    System.out.println("Ingrese la patente del vehículo");
                    patente = sc.nextLine();

                    // Marca
                    System.out.println("Ingrese la marca del vehículo");
                    marca = sc.nextLine();

                    // Revisiones
                    try {
                        System.out.println("Ingrese el número de revisiones pendientes: ");
                        int revisiones = Integer.parseInt(sc.nextLine());

                        if (revisiones < 0) {
                            System.out.println("ERROR: Debe ingresar un número mayor o igual a 0.");
                            continue;
                        } else {
                            revisionesPendientes = revisiones;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Debe ingresar un número.");
                        continue;
                    }

                    // Número de pasajeros
                    int numPasajeros;
                    try {
                        System.out.println("Ingrese el número de pasajeros del vehículo: ");
                        int num = Integer.parseInt(sc.nextLine());

                        if (num <= 0) {
                            System.out.println("ERROR: Debe ingresar un número positivo.");
                            continue;
                        } else {
                            numPasajeros = num;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Debe ingresar un número.");
                        continue;
                    }

                    // Creación de vehículo particular y adición a ArrayList
                    VehiculoParticular vehiculoParticular = new VehiculoParticular(patente, marca, revisionesPendientes,
                            numPasajeros);
                    listaVehiculos.add(vehiculoParticular);
                    System.out.println("=== VEHÍCULO PARTICULAR REGISTRADO EXITOSAMENTE ===");
                    flagSubmenu = false;
                    break;

                case "2":
                    // Patente
                    System.out.println("Ingrese la patente del vehículo");
                    patente = sc.nextLine();

                    // Marca
                    System.out.println("Ingrese la marca del vehículo");
                    marca = sc.nextLine();

                    // Revisiones
                    try {
                        System.out.println("Ingrese el número de revisiones pendientes: ");
                        int revisiones = Integer.parseInt(sc.nextLine());

                        if (revisiones < 0) {
                            System.out.println("ERROR: Debe ingresar un número mayor o igual a 0.");
                            continue;
                        } else {
                            revisionesPendientes = revisiones;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Debe ingresar un número.");
                        continue;
                    }

                    // Número de pasajeros
                    int pesoMaxCarga;
                    try {
                        System.out.println(
                                "Ingrese el peso máximo de carga en kilogramos (número entero, sin decimales): ");
                        int peso = Integer.parseInt(sc.nextLine());

                        if (peso <= 0) {
                            System.out.println("ERROR: Debe ingresar un número positivo.");
                            continue;
                        } else {
                            pesoMaxCarga = peso;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Debe ingresar un número.");
                        continue;
                    }

                    // Creación de vehículo carga y adición a ArrayList
                    VehiculoCarga vehiculoCarga = new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga);
                    listaVehiculos.add(vehiculoCarga);
                    System.out.println("=== VEHÍCULO DE CARGA REGISTRADO EXITOSAMENTE ===");
                    flagSubmenu = false;
                    break;

                case "3":
                    flagSubmenu = false;
                    break;

                default:
                    System.out.println("ERROR: Debe ingresar una opción válida.");
                    break;
            }
        }
    }

    static void listarVehiculos() {
        System.out.println("=== LISTA DE VEHÍCULOS ===");
        if (listaVehiculos.size() <= 0) {
            System.out.println("No hay vehículos registrados actualmente.");
        } else {
            for (Vehiculo vehiculo : listaVehiculos) {
                System.out.println(vehiculo.mostrarInfo());
            }
        }
    }

    static void buscarVehiculo() {
        System.out.println("=== BÚSQUEDA DE VEHÍCULOS ===");
        System.out.println("Ingrese una búsqueda (no necesita ser la patente entera): ");
        String patenteABuscar = sc.nextLine();
        boolean hayResultados = false;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().toLowerCase().contains(patenteABuscar)) {
                System.out.println(vehiculo.mostrarInfo());
                hayResultados = true;
            }
        }

        if (hayResultados == false) {
            System.out.println("No se encontraron patentes que coincidan con la búsqueda.");
        }
    }

    static void realizarRevision() {
        System.out.println("=== REVISIÓN DE VEHÍCULOS ===");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println("[" + i + "] " + listaVehiculos.get(i).getPatente() + "Revisiones pendientes: "
                    + listaVehiculos.get(i).getRevisionesPendientes());
        }

        System.out.println("Ingrese el índice del vehículo a revisar: ");
        try {
            int indiceARevisar = Integer.parseInt(sc.nextLine());
            if (indiceARevisar < 0 || indiceARevisar > (listaVehiculos.size() - 1)) {
                System.out.println("ERROR: Debe ingresar un índice válido.");
            } else if (listaVehiculos.get(indiceARevisar).getRevisionesPendientes() <= 0) {
                System.out.println("ERROR: Este vehículo no tiene revisiones pendientes.");
            } else {
                int revisiones = listaVehiculos.get(indiceARevisar).getRevisionesPendientes();
                listaVehiculos.get(indiceARevisar).setRevisionesPendientes(revisiones - 1);

                System.out.println("=== REVISIÓN REALIZADA EXITOSAMENTE ===");
                System.out.println("Patente: " + listaVehiculos.get(indiceARevisar).getPatente());
                System.out.println("Costo: " + listaVehiculos.get(indiceARevisar).getMarca());
                System.out.println("Costo de revisión: $" + listaVehiculos.get(indiceARevisar).calcularCostoRevision());
                System.out.println("Revisiones pendientes restantes: "
                        + listaVehiculos.get(indiceARevisar).getRevisionesPendientes());
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Debe ingresar un número.");
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

        System.out.println("Vehículos particulares: " + vehiculosParticulares);
        System.out.println("Vehículos de carga: " + vehiculosCarga);
        System.out.println("Total de vehículos registrados: " + (vehiculosParticulares + vehiculosCarga));
        System.out.println("Ingresos proyectados: $" + ingresosProyectados);
    }

    static void cargarDatosDePrueba() {
        VehiculoParticular vehiculo1 = new VehiculoParticular("XS-YY-94", "Toyota", 2, 5);
        VehiculoCarga vehiculo2 = new VehiculoCarga("MS-OO-54", "Chevrolet", 2, 200);

        listaVehiculos.add(vehiculo1);
        listaVehiculos.add(vehiculo2);
    }
}
