import java.util.ArrayList;

import java.util.Scanner;



public class main {

  private static Scanner scanner = new Scanner(System.in);

  private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();



  public static void main(String[] args) {

    boolean salir = false;



    while (!salir) {

      System.out.println("\n--- TALLER MECANICO ---");

      System.out.println("1. Registrar vehiculo");

      System.out.println("2. Listar vehiculos");

      System.out.println("3. Buscar vehiculo por patente");

      System.out.println("4. Realizar revision");

      System.out.println("5. Resumen de vehiculos");

      System.out.println("6. Salir");

      System.out.print("Seleccione una opcion: ");



      int opcion = leerEntero();



      switch (opcion) {

        case 1:

          registrarVehiculo();

          break;

        case 2:

          listarVehiculos();

          break;

        case 3:

          buscarVehiculo();

          break;

        case 4:

          realizarRevision();

          break;

        case 5:

          resumenVehiculos();

          break;

        case 6:

          salir = true;

          System.out.println("Programa finalizado.");

          break;

        default:

          System.out.println("Error: Opcion no valida. Intente nuevamente.");

      }

    }

  }



  // Método auxiliar para leer enteros con protección try-catch (R11)

  private static int leerEntero() {

    while (true) {

      try {

        String entrada = scanner.nextLine().trim();

        return Integer.parseInt(entrada);

      } catch (NumberFormatException e) {

        System.out.print("Error: Debe ingresar un numero valido: ");

      }

    }

  }



  // R6: Registrar vehículo

  private static void registrarVehiculo() {

    System.out.println("\n--- Tipo de vehiculo ---");

    System.out.println("1. Particular");

    System.out.println("2. Carga");

    System.out.print("Seleccione: ");

    int tipo = leerEntero();



    if (tipo != 1 && tipo != 2) {

      System.out.println("Error: Tipo de vehiculo invalido.");

      return;

    }



    System.out.print("Patente: ");

    String patente = scanner.nextLine().trim();



    System.out.print("Marca: ");

    String marca = scanner.nextLine().trim();



    int pendientes = -1;

    while (pendientes < 0) {

      System.out.print("Revisiones pendientes: ");

      pendientes = leerEntero();

      if (pendientes < 0) {

        System.out.println("El numero de revisiones debe ser mayor o igual a 0.");

      }

    }



    if (tipo == 1) {

      int pasajeros = 0;

      while (pasajeros <= 0) {

        System.out.print("Numero de pasajeros: ");

        pasajeros = leerEntero();

        if (pasajeros <= 0) {

          System.out.println("El numero de pasajeros debe ser un entero positivo.");

        }

      }

        VehiculoParticular vp = new VehiculoParticular(patente, marca, pendientes, pasajeros);

      listaVehiculos.add(vp);

      System.out.println("[OK] Vehiculo particular registrado.");



    } else {

      int pesoCarga = 0;

      while (pesoCarga <= 0) {

        System.out.print("Peso maximo de carga (kg): ");

        pesoCarga = leerEntero();

        if (pesoCarga <= 0) {

          System.out.println("El peso maximo debe ser un entero positivo.");

        }

      }

      VehiculoCarga vc = new VehiculoCarga(patente, marca, pendientes, pesoCarga);

      listaVehiculos.add(vc);

      System.out.println("[OK] Vehiculo de carga registrado.");

    }

  }



  // R7: Listar vehículos (Polimorfismo)

  private static void listarVehiculos() {

    System.out.println("\nVEHICULOS REGISTRADOS");

    if (listaVehiculos.isEmpty()) {

      System.out.println("No hay vehiculos registrados.");

      return;

    }



    for (int i = 0; i < listaVehiculos.size(); i++) {

      System.out.println("[" + (i + 1) + "] " + listaVehiculos.get(i).mostrarInfo());

    }

  }



  // R8: Buscar vehículo por patente

  private static void buscarVehiculo() {

    System.out.println("\nBUSCAR VEHICULO");

    if (listaVehiculos.isEmpty()) {

      System.out.println("No hay vehiculos registrados para buscar.");

      return;

    }



    System.out.print("Ingrese texto a buscar: ");

    String busqueda = scanner.nextLine().trim().toLowerCase();



    boolean encontrado = false;

    System.out.println("Resultados:");

    for (Vehiculo v : listaVehiculos) {

      if (v.getPatente().toLowerCase().contains(busqueda)) {

        System.out.println(v.mostrarInfo());

        encontrado = true;

      }

    }



    if (!encontrado) {

      System.out.println("No se encontraron coincidencias para: " + busqueda);

    }

  }



  // R9: Realizar revisión

  private static void realizarRevision() {

    System.out.println("\nREALIZAR REVISION");

    if (listaVehiculos.isEmpty()) {

      System.out.println("No hay vehiculos registrados.");

      return;

    }



    for (int i = 0; i < listaVehiculos.size(); i++) {

      Vehiculo v = listaVehiculos.get(i);

      System.out.println("[" + (i + 1) + "] " + v.getPatente() + " " + v.getMarca() +

                " (Pendientes: " + v.getRevisionesPendientes() + ")");

    }



    System.out.print("Ingrese numero de vehiculo: ");

    int indice = leerEntero() - 1;



    if (indice < 0 || indice >= listaVehiculos.size()) {

      System.out.println("Error: El vehiculo seleccionado no existe.");

      return;

    }



    Vehiculo seleccionado = listaVehiculos.get(indice);



    if (seleccionado.getRevisionesPendientes() <= 0) {

      System.out.println("Error: El vehiculo no tiene revisiones pendientes.");

      return;

    }



    // Descontar una revisión

    seleccionado.setRevisionesPendientes(seleccionado.getRevisionesPendientes() - 1);



    System.out.println("\nRevision realizada.");

    System.out.println("Vehiculo: " + seleccionado.getPatente() + " " + seleccionado.getMarca());

    System.out.println("Costo de la revision: $" + seleccionado.CalcularCostoRevision());

    System.out.println("Revisiones pendientes: " + seleccionado.getRevisionesPendientes());

  }



  // R10: Resumen de vehículos

  private static void resumenVehiculos() {

    System.out.println("\nRESUMEN DE VEHICULOS");



    int totalVehiculos = listaVehiculos.size();

    int particulares = 0;

    int carga = 0;

    int ingresosProyectados = 0;



    for (Vehiculo v : listaVehiculos) {

      if (v instanceof VehiculoParticular) {

        particulares++;

      } else if (v instanceof VehiculoCarga) {

        carga++;

      }



      ingresosProyectados += v.CalcularCostoRevision() * v.getRevisionesPendientes();

    }



    System.out.println("Total de vehiculos: " + totalVehiculos);

    System.out.println("Vehiculos particulares: " + particulares);

    System.out.println("Vehiculos de carga: " + carga);

    System.out.println("Ingresos proyectados: $" + ingresosProyectados);

  }

}