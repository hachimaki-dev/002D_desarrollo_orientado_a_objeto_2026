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
            default:
                break;
        }
    }
     //OPCION 1 MENU
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
                        mostrarMenu=false;
                        break;
                    default:
                        break;
                }
            }
        }

        static void registrarParticular(){
            try{
                System.out.println("Patente: ");
                String patente = sc.nextLine();
                System.out.println("Marca: ");
                String marca = sc.nextLine();
                System.out.println("Revisiones pendientes: ");
                int revisionesPendientes = Integer.parseInt(sc.nextLine());
                System.out.println("Numero de pasajeros: ");
                int numPasajeros = Integer.parseInt(sc.nextLine());

                if (revisionesPendientes < 0){
                    System.out.println("El número de revisiones no puede ser negativo.");
                    return;
                }
                if (numPasajeros <= 0){
                    System.out.println("El numero de pasajeros debe ser positivo.");
                    return;
                }
                vehiculos_particulares.add(new VehiculoParticular(patente, marca, revisionesPendientes, numPasajeros));
                System.out.println("[OK] Vehiculo particular registrado.");                
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero válido.");
            }
        }

        static void registrarCarga(){
            try {
                System.out.println("Patente: ");
                String patente = sc.nextLine();
                System.out.println("Marca: ");
                String marxca = sc.nextLine();
                System.out.println("Revisiones pendientes: ");
                int revisionesPendientes = Integer.parseInt(sc.nextLine());
                System.out.println("Peso maximo de carga (kg): ");
                int pesoMaxCarga = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero válido.");
            }
        }

        //LISTAR VEHICULO MENU
        static void listarVehiculos(){
            if(vehiculos_particulares.isEmpty()& vehiculos_cargas.isEmpty());
            System.out.println("Vehiculo particular no registrado.");
            return;
            System.out.println("Vehiculo Registrado");
            int i = 1;
            for(VehiculoParticular v: vehiculos_particulares){
                System.out.println(("["+ i + "]" + mostrarInfo));
                i++;
            }
            for(VehiculosCargas v: vehiculos_cargas){
                System.out.println(("["+ i + "]" + mostrarInfo)); 
                i++;
            }
            
        }

        //BUSCAR MENU
        static void buscarVehiculo(){
            System.out.println("Ingrese texto a buscar: ");
            String busqueda = sc.nextLine().toLowerCase();
            boolean encontrado = false;
            System.out.println("Resultados: ");
            for (VehiculoParticular v: vehiculos_particulares){
                if (v.getpatente().contains(busqueda)){
                    System.out.println(v.mostrarInfo());
                    encontrado=true;
                }
            }
        }

        //REVISION MENU
        static void revision(){
            if(vehiculos_particulares.isEmpty()&vehiculos_cargas.isEmpty()){
                System.out.println("No se encontró ninguna revisión.")
                return;
            }
            System.out.println("Realizar Revision");
            int i = 1;
            for(vehiculos_particulares v: vehiculos_particulares){
                System.out.println("["+ i +"]"+ v.getpatente()+ "-"+v.getmarca);
            }
        }
        
        }

//se intento hehe