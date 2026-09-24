import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Vehiculo> coleccion= new ArrayList<>();
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
                    listarVehiculo();
                    break;
                case "3":
                     buscarVehiculo();
                    break;
                case "4":
                    realizarRevision();
                    break;
                case "5":
                    resumenVehiculo();
                    break;                 
                case "6":
                    mostrar_menu=false;
                    break;
                default:
                    System.out.println("Error, opción no disponible");
                    System.out.println("Vuelva a intentar");
                    break;
            }}
        }
        static public void registroVehiculo(){
            System.out.println("---- VEHICULO ----");
            System.out.println("1. PARTICULAR");
            System.out.println("2. CARGA");
            System.out.println("Elija una opción: ");
            String optVe =sc.next();{
                if(optVe.equals("1")){
                    System.out.println("Patente: ");
                    String patente = sc.nextLine();
                    System.out.println("Marca: ");
                    String marca = sc.nextLine();
                    System.out.println("Revisiones Pendientes: ");
                    int revisionesPendientes=Integer.parseInt(sc.nextLine());
                    System.out.println("numero Pasajeros");
                    int numPasajeros = Integer.parseInt(sc.nextLine());
                    coleccion.add(new VehiculoParticular(patente, marca, revisionesPendientes, numPasajeros));
                }else if(optVe.equals("2")){
                    System.out.println("Patente: ");
                    String patente = sc.nextLine();
                    System.out.println("Marca: ");
                    String marca = sc.nextLine();
                    System.out.println("Revisiones Pendientes: ");
                    int revisionesPendientes=Integer.parseInt(sc.nextLine());
                    System.out.println("peso Maximo Carga:");
                    int pesoMaxCarga = Integer.parseInt(sc.nextLine());
                    coleccion.add(new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga));

                }else{
                    System.out.println("Opción invalida");
                }
        }
        
     }
     static void listarVehiculo(){
        if(coleccion.isEmpty()){
            System.out.println("Resultados: "+coleccion.isEmpty()); 
     }else{
        System.out.println("Sin Resultados: ");
     }}
     static void buscarVehiculo(){
        System.out.println("Ingresar patente: ");
        String buscar = sc.nextLine().toLowerCase();
        for(Vehiculo v : coleccion){
            if(v.getPatente().toLowerCase().contains(buscar)){
                System.out.println("Vehiculo encontrado: "+v.mostrarInfo());
            }
        }
     }
     static void realizarRevision(){
        

     }
     static void resumenVehiculo(){

     }
    }


