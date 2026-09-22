import java.util.Scanner;
import java.util.ArrayList;

public class main {


        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("====TALLER MECANICO====");
        System.out.println("1. Registrar Vehiculo: ");
        System.out.println("2. Listar Vehiculos ");
        System.out.println("3. Buscar vehiculo por patente ");
        System.out.println("4. Realizar revision");
        System.out.println("5. Resumen de vehiculos");
        System.out.println("6. Salir ");
        System.out.println("Seleccione una opción:  ");
        
        String opcion_menu = sc.nextLine();
        
        
        switch (opcion_menu) {
            case "1":
                registraVehiculo();
                break;
            case "2":
                
                break;
            case "3":
                
                break;
            
            case "4":
                
                break;
            case "5":
                
                break;

            default:
                throw new AssertionError();
        }
        
    }
    
    static void registraVehiculo(){
        System.out.println("---Tipo de vehiculo-----");
        System.out.println("1. Particular ");
        System.out.println("2. Particular");
        System.out.println("Seleccione: ");

        int tipoVehiculo = sc.integerparseInt(sc.nextLine);
           
        System.out.println("Ingrese patente: ");
        int patente = sc.integerparseInt(sc.nextLine);
    
    }


    

    }


