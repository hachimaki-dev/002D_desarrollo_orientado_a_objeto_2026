import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> inventario = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion:");

            String opcionTexto = sc.nextLine();

            switch (opcionTexto) {
                case "1":
                    registrarVehiculo();
                    break;

                case "2":
                    listarVehiculos();
                    break;

                case "3":
                    buscarVehiculos();
                    break;

                case "4":
                    realizarRevision();
                    break;

                case "5":
                    mostrarResumen();
                    break;

                case "6":
                    salir = true;
                    mostrarMensaje("Programa Finalizado.");
                    break;

                default:
                    mostrarMensaje("Esa opcion no existe.", "ERROR");
            }

        }
        sc.close();
    }

    static void registrarVehiculo() {
        System.out.println("--- Tipo de Vehiculo ---");
        System.out.println("1. Vehiculo Particular");
        System.out.println("2. Vehiculo Carga");
        System.out.println("Seleccione:");

        try {
            int tipo = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Patente");
            String patente = sc.nextLine();

            System.out.print("Marca");
            String marca = sc.nextLine();

            System.out.print("Revisiones pendientes:");
            int revisionesPendientes = Integer.parseInt(sc.nextLine().trim());

            if (revisionesPendientes < 0) {
                mostrarMensaje("Las revisiones pendientes deben ser >= 0", "ERROR");
                return;
            }

            if (tipo == 1) {
                System.out.print("Numero de pasajeros:");
                int numPasajeros = Integer.parseInt(sc.nextLine().trim());

                if (numPasajeros <= 0) {
                    mostrarMensaje("El numero de pasajeros debe ser positivo", "ERROR");
                    return;
                }

                if (inventario.add(new VehiculoParticular(patente, marca, revisionesPendientes, numPasajeros))) {
                    mostrarMensaje("Vehiculo Particular registrado", "OK");

                }

            } else if (tipo == 2) {
                System.out.print("Peso maximo de carga (Kg):");
                int pesoMaxCarga = Integer.parseInt(sc.nextLine().trim());

                if (pesoMaxCarga <= 0) {
                    mostrarMensaje("El peso maximo de carga dee ser positivo", "ERROR");
                    return;
                }

                if (inventario.add(new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga))) {
                    mostrarMensaje("Vehiculo de carga registrado", "OK");
                }

            } else {
                mostrarMensaje("Tipo de vehiculo invalido.", "ERROR");

            }
        } catch (NumberFormatException e) {
            mostrarMensaje("Debe ingresar un numero valido", "ERROR");

        }

    }

    static void listarVehiculos() {
        System.out.println("--- Vehiculos Registrados ---");
        if (inventario.isEmpty()) {
            mostrarMensaje("No hay vehiculos registrados", "ERROR");
            return;
        }
        int i = 1;
        for (Vehiculo v : inventario){
            System.out.println("[" + i + "]" + v.mostrarInfo());
            i ++;
        }
    }

    static void buscarVehiculos() {
        System.out.println("--- Buscar Vehiculo ---");
        System.out.print("Ingrese texto a buscar:");
        String texto = sc.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        System.out.println("Resultados:");
        for (Vehiculo v : inventario) {
            if (v.getPatente().toLowerCase().contains(texto)) {
                System.out.println(" " + v.mostrarInfo());
                encontrado = true;
            }
        }

        if (!encontrado) {
            mostrarMensaje("No se encontraron coincidencias.", "Info");
        }

    }

    static void realizarRevision() {
        System.out.println("--- Realizar Revision ---");
        if (inventario.isEmpty()) {
            mostrarMensaje("No hay vehiculos registrados.", "Info");
            return;
        }

        for (int i = 0; i < inventario.size(); i++) {
            Vehiculo v = inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + v.getPatente() + "-" + v.getMarca() + "Pendientes:"
                    + v.getRevisionesPendientes() + "]");
        }

        try {
            System.out.print("Ingrese numero de vehiculo:");
            int numero = Integer.parseInt(sc.nextLine().trim());

            if (numero < 1 || numero > inventario.size()) {
                mostrarMensaje("Numero de vehiculo fuera de rango.", "ERROR");
                return;
            }

            Vehiculo v = inventario.get(numero - 1);

            if (v.getRevisionesPendientes() <= 0) {
                mostrarMensaje("Este vehiculo no tiene revisiones pendientes", "ERROR");
                return;

            }

            v.setRevisionesPendientes(v.getRevisionesPendientes() - 1);
            System.out.println("Revision realizada");
            System.out.println("Vehiculo:" + v.getPatente() + "-" + v.getMarca());
            System.out.println("Coste de la revision: $" + v.calcularCostoRevision());
            System.out.println("Revisiones pendientes:" + v.getRevisionesPendientes());

        } catch (NumberFormatException e) {
            mostrarMensaje("Debe ingresar un numero valido", "ERROR");

        }

    }

    static void mostrarResumen(){
        System.out.println("--- Resumen de Vehiculos ---");
        int totalparticulares = 0;
        int totalcarga = 0;
        long ingresosProyectados = 0;

        for (Vehiculo v : inventario){
            if(v instanceof VehiculoParticular){
                totalparticulares ++;
            } else if (v instanceof VehiculoCarga){
                totalcarga ++;
            }
            ingresosProyectados += (long) v.calcularCostoRevision() * v.getRevisionesPendientes();
        }

        System.out.println("Total vehiculos" + inventario.size());
        System.out.println("Vehiculos particulares:" + totalparticulares);
        System.out.println("Vehiculos de carga:" + totalcarga);
        System.out.println("Vehiculos proyectados:" + ingresosProyectados);


    }

    static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    static void mostrarMensaje(String mensaje, String tipo) {
        System.out.println("[" + tipo + "]" + mensaje);
    }
}
