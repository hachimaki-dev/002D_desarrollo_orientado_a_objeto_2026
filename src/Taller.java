import java.security.DrbgParameters.Capability;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
    static ArrayList<VehiculoParticular> coleccion_VehivulosParticular = new ArrayList<>();
    static ArrayList<VehiculoCarga> coleccion_VehiculoCarga = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        mostrarMenu();
    }
    static void mostrarMenu(){
        boolean mostrarMenu = true;
        while (mostrarMenu) {
            System.out.println("=====TALLER MECANICO=====");
            System.out.println("1. registrar vehivulo");
            System.out.println("2. listar vehiculos");
            System.out.println("3. buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. salir");
            System.out.println("7. datos de pruebas");

            System.out.println("ingrese una opcion:");
            String opcionDelMenu = sc.nextLine();
            switch (opcionDelMenu) {
                case "1":
                    RegistrarVehiculos();
                    
                    break;
                case "2":
                    ListarVehiculo();
                    
                    break;
                case "3":
                    buscarVehiculo();
                    
                    break;
                case "4":
                    realizarRevision();
                    
                    break;
                case "5":
                    
                    break;
                case "6":
                    mostrarMenu = false;
                    
                    break;
                case "7":
                    datosdeprueba();
                    
                    break;
            
                default:
                    break;
            }
        }
    }
    static void RegistrarVehiculos(){
        boolean opcionSubMenu = true;
        while (opcionSubMenu) {
            System.out.println("====TIPO DE VEHICULO===");
            System.out.println("1. particular");
            System.out.println("2. Carga");
            System.out.println("3. salir");
            System.out.println("ingrese una opcion");
            String SubMenu = sc.nextLine();
            switch (SubMenu) {
                case "1":
                    System.out.println("=====VEHICULO PARTICULAR===");
                    System.out.println("ingrese patente del vehiculo:");
                    String patente = sc.nextLine();
                    System.out.println("marca del vehiculo:");
                    String marca = sc.nextLine();
                    try {
                        System.out.println("revisiones pendientes : ");
                        int revisiones = Integer.parseInt(sc.nextLine());
                        if (revisiones < 0 ) {
                            System.out.println("no puede ser numeros negativos");
                            return; 
                        }
                        System.out.println("numero de pasajeros:");
                        int numerosPasajeros = Integer.parseInt(sc.nextLine());
                        if (numerosPasajeros< 0) {
                            System.out.println("no puede ser numeros negativos");
                            return;
                        }
                        coleccion_VehivulosParticular.add(new VehiculoParticular(patente, marca, revisiones, numerosPasajeros));


                    } catch (NumberFormatException e) {
                        System.out.println("ingrese solo numeros");
                    }
                    
                    break;
                case "2":
                    System.out.println("=====VEHICULO CARGA===");
                    System.out.println("ingrese patente del vehiculo:");
                    String patentes = sc.nextLine();
                    System.out.println("marca del vehiculo:");
                    String marcas = sc.nextLine();
                    try {
                        System.out.println("revisiones pendientes : ");
                        int revisiones = Integer.parseInt(sc.nextLine());
                        if (revisiones <= 0 ) {
                            System.out.println("no puede ser numeros negativos");
                            return; 
                        }
                        System.out.println("numero de carga maxima en kilogramos ::");
                        int Carga = Integer.parseInt(sc.nextLine());
                        if (Carga<= 0) {
                            System.out.println("no puede ser numeros negativos");
                            return;
                        }
                        coleccion_VehiculoCarga.add(new VehiculoCarga(patentes, marcas, revisiones, Carga));


                    } catch (NumberFormatException e) {
                        System.out.println("ingrese solo numeros");
                    }
                    
                    break;
                case "3":
                    opcionSubMenu = false;
                    break;
            
                default:
                    break;
            }
        }
    }
    static void ListarVehiculo(){
        System.out.println("====INVENTARIO=====");
        System.out.println("vehiculos particular");
        for (VehiculoParticular vehiculoParticular : coleccion_VehivulosParticular) {
            System.out.println(vehiculoParticular.mostrarInfo());            
        }
        System.out.println("vehiculo de Carga");
        for (VehiculoCarga vehiculoCarga : coleccion_VehiculoCarga) {
            System.out.println(vehiculoCarga.mostrarInfo());
        }
    }
    static void datosdeprueba(){
        coleccion_VehivulosParticular.add(new VehiculoParticular("DR2023", "TOYOTA", 6, 4));
         coleccion_VehivulosParticular.add(new VehiculoParticular("DR3451", "SUZUKI", 3, 4));
        coleccion_VehiculoCarga.add(new VehiculoCarga("FG3456", "VOLVO", 10, 5000));
    }
    static void buscarVehiculo(){
        System.out.println("ingrese patente del vehiculo");
        String patenteaBuscar = sc.nextLine().toUpperCase();
        for (VehiculoCarga vehiculoCarga : coleccion_VehiculoCarga) {
            if (vehiculoCarga.getpatente().contains(patenteaBuscar)) {
                System.out.println(vehiculoCarga.mostrarInfo());
            }

            
        }
        for (VehiculoParticular vehiculoParticular : coleccion_VehivulosParticular) {
            if (vehiculoParticular.getpatente().contains(patenteaBuscar)) {
                System.out.println(vehiculoParticular.mostrarInfo());
            }
        }
    }
    static void realizarRevision(){
        if (coleccion_VehivulosParticular.isEmpty()|| coleccion_VehiculoCarga.isEmpty()) {
            System.out.println("INVENTARIO VACIO");

        }
        boolean revision = true;
        while (revision) {
            System.out.println("=====TIPO DE VEHIUCULO====");
            System.out.println("1. particular");
            System.out.println("2. carga");
            System.out.println("3. salir");
            System.out.println("ingrese una opcion:");
            String opcionrevisar = sc.nextLine();
            switch (opcionrevisar) {
                case "1":
                    for (int i = 0; i < coleccion_VehivulosParticular.size(); i++) {
                        VehiculoParticular v = coleccion_VehivulosParticular.get(i);
                    }
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
            
                default:
                    break;
            }
        }
    }



}
