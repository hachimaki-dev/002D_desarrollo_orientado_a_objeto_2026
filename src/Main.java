import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mostrarMenu();

    }

    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Vehiculo>vehiculos = new ArrayList<>();

    static int cantidadParticuares = 0;
    static int cantidadCarga = 0;

    static void mostrarMenu() {
        boolean mostrarMenu = true;

        while (mostrarMenu) {
            System.out.println("=== TALLER MECANICO ===");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revisión");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. salir");
            System.out.println("Seleccione una opcion: ");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    registrarVehiculo();
                    break;

                case "2":
                    listarVehiculo();
                    break;

                case "3":
                    buscarVehiculoPatente();
                    break;

                case "4":
                    realizarRevision();
                    break;

                case "5":
                    resumenVehiculos();
                    break;

                case "6":
                    System.out.println("Programa Finalizado.");
                    mostrarMenu = false;
                    break;

                case "7":
                    break;


                default:
                    System.out.println("2Opción inválida, intente de nuevo." );
                    break;
            }

        }

    }

    static void registrarVehiculo(){
        boolean mostar_subMenu = true;
        while (mostar_subMenu) {
            System.out.println("--- Tipo de vehiculo ---");
            System.out.println("1. Particular");
            System.out.println("2. Carga");
            System.out.println("3. Volver");
            System.out.println("Seleccione: ");

            String opcion_submenu = sc.nextLine();

            switch (opcion_submenu) {
                case "1":
                case "2":
                    System.out.println("Patente: ");
                    String patente = sc.nextLine();

                    System.out.println("Marca: ");
                    String marca = sc.nextLine();

                    try {
                        System.out.println("Revisiones Pendiente:");
                        int revisiones = Integer.parseInt(sc.nextLine());

                        if (revisiones < 0) {
                            System.out.println("Error: Las revisiones pendientes deben ser mayor a 0");
                        }else if (opcion_submenu.equals("1")) {
                            System.out.println("Número de pasajeros");
                            int pasajeros = Integer.parseInt(sc.nextLine());
                            if (pasajeros <= 0) {
                                System.out.println("Error: debe ser un númeor positivo.");
                            }else{
                                vehiculos.add(new VehiculoParticular(patente, marca, revisiones, pasajeros));
                                cantidadParticuares ++;
                                System.out.println("[OK] Vehiculo particular registrado.");
                            }
                        }else{
                            System.out.println("Peso máximo de carga: ");
                            int peso = Integer.parseInt(sc.nextLine());
                            if (peso <= 0) {
                                System.out.println("Error: el peso debe ser un número positivo.");
                            }else{
                                vehiculos.add(new VehiculoCarga(patente, marca, revisiones, peso));
                                cantidadCarga ++;
                                System.out.println("[OK] Vehiculo de carga registrado.");
                            }
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Error: Debe ingresar un número válido.");
                    }
                mostar_subMenu = false;
                break;    

                case "3":
                    mostar_subMenu = false;
            
                default:
                    break;
            }
        }
    }



    static void listarVehiculo(){
      if (vehiculos.isEmpty()) {
        System.out.println("No hay vehiculos registrados.");
      }else{
        System.out.println("--- VEHICULOS REGISTRADOS ---");
        for (Vehiculo vehiculo : vehiculos){
            System.out.println(vehiculo.mostrarInfo());
        }
      }
    }


    static void  buscarVehiculoPatente(){
      if (vehiculos.isEmpty()) {
        System.out.println("No hay vehiculos registrados.");
      }else {
        System.out.println("Ingrese texto a buscar: ");
        String patenteBuscada = sc.nextLine();
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().contains(patenteBuscada)) {
                System.out.println(vehiculo.mostrarInfo());
            }
        }
      }
    }


    static void realizarRevision(){
      if (vehiculos.isEmpty()) {
        System.out.println("No hay vehiculos registrados.");
      }else{
        System.out.println("--- REALIZAR REVISION ---");
        for ( int i = 0; i < vehiculos.size(); i++){
            Vehiculo vehiculo = vehiculos.get(i);
            System.out.println("[" + (i + 1 ) + "]" + vehiculo.getPatente() + "-" + vehiculo.getMarca() + "(Pendientes: " + vehiculo.getRevisionesPendientes());
        }
      }
      try {
        System.out.println("Ingrese número de vehiculo: ");
        int numero = Integer.parseInt(sc.nextLine());
        if ((numero < 1) || numero > vehiculos.size()) {
            System.out.println("Error: El número del vehículo no existe.");
        }else{
            Vehiculo vehiculoSeleccionado = vehiculos.get(numero - 1);
            if (vehiculoSeleccionado.getRevisionesPendientes() < 1) {
                System.out.println("Error: El vehículo no tiene revsiones pendientes.");
            }else{
                vehiculoSeleccionado.setRevisionesPendientes(vehiculoSeleccionado.getRevisionesPendientes() - 1);
                System.out.println("Revisión Realizada");
                System.out.println("Vehículo: " + vehiculoSeleccionado.getPatente() + "-" + vehiculoSeleccionado.getMarca());
                System.out.println("Costo: " + vehiculoSeleccionado.calcularCostoRevision());
                System.out.println("Revisiones pendientes: " + vehiculoSeleccionado.getRevisionesPendientes());
            }
        }
      }catch (NumberFormatException e){
        System.out.println("Error: Debe ingresar un número válido.");
      }
        
    }


    static void resumenVehiculos(){
       int total = 0;
       for (Vehiculo vehiculo: vehiculos){
        total = total + vehiculo.calcularCostoRevision() * vehiculo.getRevisionesPendientes();
        System.out.println("--- RESUMEN VEHICULOS ---");
        System.out.println("Vehiculos particulares: " + cantidadParticuares);
        System.out.println("Vehiculos de carga: " + cantidadCarga);
       }
    }
    
    
    
    
    
    
    
}
