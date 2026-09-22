import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mostrarMenu();

    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<VehiculoParticular>lista_vehiculos_particulares = new ArrayList<>();
    static ArrayList<VehiculoCarga>lista_vehiculos_carga = new ArrayList<>();

    static void mostrarMenu() {
        boolean mostrarMenu = true;

        while (mostrarMenu) {
            System.out.println("=== TALLER MECANICO ===");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2.Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revisión");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6.. salir");
            System.out.println("7. prueba");
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
                    mostrarMenu = false;
                    break;

                case "7":
                    break;


                default:
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
                    System.out.println("Patente: ");
                    String patente = sc.nextLine();

                    System.out.println("Marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Revisiones pendientes: ");
                    String revisiones = sc.nextLine();

                    System.out.println("Número de pasajeros: ");
                    String pasajeros = sc.nextLine();

                    lista_vehiculos_particulares.add(new VehiculoParticular(patente, marca, 0, 0));
                    break;

                case "2":
                    break;

                case "3":
                    mostar_subMenu = false;
            
                default:
                    break;
            }
        }
    }



    static void listarVehiculo(){
        for (VehiculoParticular vehiculoParticular : lista_vehiculos_particulares){
            System.out.println(vehiculoParticular.mostrarInfo());
        }

        for (VehiculoCarga vehiculoCarga : lista_vehiculos_carga){
            System.out.println(vehiculoCarga.mostrarInfo());
        }
    }


    static void  buscarVehiculoPatente(){
        String patente_buscada = sc.nextLine();
        for (VehiculoParticular vehiculoParticular : lista_vehiculos_particulares){
            if (vehiculoParticular.getPatente().contains(patente_buscada)) {
                System.out.println(vehiculoParticular.mostrarInfo());
            }
        }

        for (VehiculoCarga vehiculoCarga : lista_vehiculos_carga){
            if (vehiculoCarga.getPatente().contains(patente_buscada)) {
                System.out.println(vehiculoCarga.mostrarInfo());
            }
        }
    }


    static void realizarRevision(){
        for (int i = 0; i < lista_vehiculos_particulares.size(); i++){
            VehiculoParticular vehiculo = lista_vehiculos_particulares.get(i);
            System.out.println((i + 1) + vehiculo.getPatente() + vehiculo.getRevisionesPendientes());
            
            vehiculo.setRevisionesPendientes(vehiculo.getRevisionesPendientes() - 1); 
            int comprobante = vehiculo.calcularCostoRevision() * 1;

        }
        
    }


    static void resumenVehiculos(){
        for (VehiculoParticular vehiculos : lista_vehiculos_particulares){
            System.out.println(lista_vehiculos_particulares.size());
        }
    }
    
    
    
    
    
    
    
}
