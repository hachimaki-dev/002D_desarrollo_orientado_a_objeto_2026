import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<VehiculoParticular>vehiculos_particulares=new ArrayList<>();
    static ArrayList<VehiculoCarga>vehiculos_cargas=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }
    static void mostrarMenu(){
        System.out.println("===TALLER MECANICO==="); //R5

        System.out.println("1. Registrar vehiculo"); //R6
        System.out.println("2. Listar vehiculos"); //R7
        System.out.println("3. Buscar vehiculo por patente"); //R8
        System.out.println("4. Realizar revision"); //R9
        System.out.println("5. Resumen de vehiculos"); //R10
        System.out.println("6. Salir");
        System.out.println("");
        System.out.println("Seleccione una opcion: _");
        
        String opcion_menu = sc.nextLine();
        switch (opcion_menu) {
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
                salir();
                break;
            case "7":
                precargarDatos();
                break;
        
            default:
                break;
        }

        static void registrarVehiculo(){
            boolean mostrarMenu=true;

            while(mostrarMenu){
                System.out.println("--- Tipo de vehiculo ---");
                System.out.println("1. Particular");
                System.out.println("2. Carga");
                System.out.println("");
                System.out.println("Seleccione");

                String opcion_registrar_vehiculo=sc.nextLine();

                switch (opcion_registrar_vehiculo) {
                    case "1":
                        registrarParticular();
                        break;
                    case "2":
                        registrarCarga();
                        break;
                
                    default:
                        break;
                }
            }
        }
        }
    }

