import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<VehiculoParticular> coleccionParticulares= new ArrayList<>();
    static ArrayList<VehiculoCarga> coleccionCarga= new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {mostrarMenu();}
     static void mostrarMenu(){
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("===== TALLER MECANICO =====");
            System.out.println("1. Regristrar vehiculos");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            String opt =sc.nextLine();
            switch (opt) {
                case "1":
                    registroVehiculo();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    mostrar_menu=false;
                    break;
                default:
                    System.out.println("Error, opción no disponible");
                    System.out.println("Vuelva a intentar");
                    break;
            }
        }
        static public void registroVehiculo(){
            System.out.println("---- VEHICULO ----");
            System.out.println("1. PARTICULAR");
            System.out.println("2. CARGA");
            System.out.println("Elija una opción: ");
            String optVe =sc.next();
            switch (optVe) {
                case "1":  
                 registroVehiculoParticular();
                    break;
                case "2":
                 registroVehiculoCarga();
                    break;   
                default:
                    System.out.println("Error, opción no disponible");
                    System.out.println("Vuelva a intentar");
                    break;
            }
        }
        
     }
     static public void registroVehiculoParticular(){
            System.out.println("Registrar Patente: ");
            String patente =sc.next();
            System.out.println("Registrar Marca: ");
            String marca =sc.next();
            System.out.println("Revisiones pendientes: ");
            int revisionesPendientes = Integer.parseInt(sc.nextLine());
            System.out.println("Numero de pasajeros: ");
            int numPasajeros = Integer.parseInt(sc.nextLine());
            VehiculoParticular vehPar = new VehiculoParticular(patente,marca,revisionesPendientes,numPasajeros);
            if (coleccionParticulares.add(vehPar)) {
                System.out.println("Agregado Exitosamente");         
            }else{
                System.err.println("Error, no se agrego nada");
            }
    }
    static public void registroVehiculoCarga(){
            System.out.println("Registrar Patente: ");
            String patente =sc.next();
            System.out.println("Registrar Marca: ");
            String marca =sc.next();
            System.out.println("Revisiones pendientes: ");
            int revisionesPendientes = Integer.parseInt(sc.nextLine());
            System.out.println("Peso maximo de carga: ");
            int pesoMaxCarga = Integer.parseInt(sc.nextLine());
            VehiculoCarga vehCar = new VehiculoCarga(patente,marca,revisionesPendientes,pesoMaxCarga);
            if (coleccionCarga.add(vehCar)) {
                System.out.println("Agregado Exitosamente");         
            }else{
                System.err.println("Error, no se agrego nada");
            }
    }
}

