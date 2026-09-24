/* El paradigma que se esta usando es la de orienta a objetos y una mezcla entre la funcional , su caracteristica principal es que con este metodo se puede ordenar el codigo y hacerlo mas legible para el resto de programadores , una de las diferencias es que este lenguaje es compilado , quiere decir este se comunica directamente con la CPU sin pasar por un intermediario como Python , la otra diferencia es que el tipado del codigo es fuerte , que quiere decir que el lenguaje necesita que le digas que tipo de dato es , que metodo estas usando y que clase estas usando para seguir  */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            mostrarMenu();
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    registrarVehiculo();
                    break;
                case "2":
                    listarVehiculo();
                    break;
                case "3":
                    buscarPatente();
                    break;
                case "4":
                    realizarRevision();
                    break;
                case "5":
                    resumenVehiculo();
                    break;
                case "6":
                    System.out.println("Hasta luego.");
                    flag = false; // Se apaga la bandera para salir del menú
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n-- TALLER MECANICO --");
        System.out.println("1 . Registrar vehiculo");
        System.out.println("2 . Listar vehiculos");
        System.out.println("3 . Buscar vehiculo por patente");
        System.out.println("4 . Realizar revision");
        System.out.println("5 . Resumen de vehiculos");
        System.out.println("6 . Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static void registrarVehiculo() {
        try {
            System.out.println("\n--- Registrar vehiculo ---");
            System.out.println("1 . Particular");
            System.out.println("2 . Carga");
            System.out.print("Escoja una opcion: ");
            String opcionTipo = sc.nextLine();

            if (!opcionTipo.equals("1") && !opcionTipo.equals("2")) {
                System.out.println("Tipo inválido.");
                return;
            }

            System.out.print("Patente: ");
            String patente = sc.nextLine();

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Revisiones pendientes: ");
            int revisiones = Integer.parseInt(sc.nextLine());

            if (opcionTipo.equals("1")) {
                System.out.print("Numero de pasajeros: ");
                int pasajeros = Integer.parseInt(sc.nextLine());
                
                VehiculoParticular vp = new VehiculoParticular(patente, marca, revisiones, pasajeros);
                listaVehiculos.add(vp);
                System.out.println("Vehículo Particular registrado con éxito.");

            } else if (opcionTipo.equals("2")) {
                System.out.print("Peso maximo de carga (kg): ");
                int peso = Integer.parseInt(sc.nextLine());

                VehiculoCarga vc = new VehiculoCarga(patente, marca, revisiones, peso);
                listaVehiculos.add(vc);
                System.out.println("Vehículo de Carga registrado con éxito.");
            }
        } catch (Exception e) {
            System.out.println("Error: Ingresó un dato inválido. Intente nuevamente.");
        }
    }

    public static void listarVehiculo() {
        System.out.println("\n--- LISTA DE VEHICULOS ---");
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaVehiculos.get(i).toString());
        }
    }

    // 3. BUSCAR POR PATENTE
    public static void buscarPatente() {
        System.out.println("\n--- BUSCAR POR PATENTE ---");
        System.out.print("Ingrese texto a buscar: ");
        String buscar = sc.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Vehiculo v : listaVehiculos) {
            if (v.getPatente().toLowerCase().contains(buscar)) {
                System.out.println(v.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    public static void realizarRevision() {
        try {
            System.out.println("\n--- REALIZAR REVISION ---");
            listarVehiculo();

            if (listaVehiculos.isEmpty()) return;

            System.out.print("Seleccione numero de vehiculo: ");
            int pos = Integer.parseInt(sc.nextLine()) - 1;

            if (pos >= 0 && pos < listaVehiculos.size()) {
                Vehiculo v = listaVehiculos.get(pos);

                if (v.getRevisionesPendientes() > 0) {
                    v.setRevisionesPendientes(v.getRevisionesPendientes() - 1);
                    System.out.println("Revisión realizada a " + v.getPatente());
                    System.out.println("Costo: $" + v.calcularCostoRevision());
                    System.out.println("Pendientes restantes: " + v.getRevisionesPendientes());
                } else {
                    System.out.println("Este vehículo no tiene revisiones pendientes.");
                }
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número válido.");
        }
    }

    public static void resumenVehiculo() {
        System.out.println("\n--- RESUMEN DE VEHICULOS ---");
        int cantParticulares = 0;
        int cantCarga = 0;
        int ingresosProyectados = 0;

        for (Vehiculo v : listaVehiculos) {
            if (v instanceof VehiculoParticular) {
                cantParticulares++;
            } else if (v instanceof VehiculoCarga) {
                cantCarga++;
            }
            ingresosProyectados += (v.calcularCostoRevision() * v.getRevisionesPendientes());
        }

        System.out.println("Total de vehículos: " + listaVehiculos.size());
        System.out.println("Vehículos Particulares: " + cantParticulares);
        System.out.println("Vehículos de Carga: " + cantCarga);
        System.out.println("Ingresos Proyectados: $" + ingresosProyectados);
    }
}