import java.util.Scanner;
import java.util.ArrayList;

public class main {

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion_menu = 0;
        do{
            System.out.println("====TALLER MECANICO====");
            System.out.println("1. Registrar Vehiculo: ");
            System.out.println("2. Listar Vehiculos ");
            System.out.println("3. Buscar vehiculo por patente ");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir ");
            System.out.println("Seleccione una opción:  ");
        }
        try{
            opcion_menu = Integer.parseInt(scanner.nextLine());
             switch (opcion_menu) {
            case 1:
                registraVehiculo();
                break;
            case 2:
                listarVehiculos();
                break;
            case 3:
                buscarPatente();
                break;
            
            case 4:
                realizarRevision();
                break;
            case 5:
                mostrarResumen()
                break;

            default:
                throw new AssertionError();
        }   
    }
        }
    
     private static void registraVehiculo(){
            System.out.println("---Tipo de vehiculo-----");
            System.out.println("1. Particular ");
            System.out.println("2. Particular");
            System.out.println("Seleccione: ");

            try{
                int tipo = Integer.parseInt(scanner.nextLine());
                if(tipo != 1 && tipo != 2 ){
                    System.out.println("Erro tipo invalido");
                    return;
                }
                System.out.println("Ingrese patente: ");
                String patente = scanner.nextLine().trim();
                
                System.out.println("Ingrese la marca del vehiculo: ");
                String marca = scanner.nextLine().trim();

                System.out.println("Revisiones pendientes: ");
                int pendientes = Integer.parseInt(scanner.nextLine());
                if (pendientes < 0) {
                    System.out.println("Error debe ser 0 o mayor a 0");
                    return;
                }
                if (tipo == 1) {
                    System.out.println("Numero de pasajeros: ");
                    int pasajeros = Integer.parseInt(scanner.nextLine());
                    if (pasajeros <=0){
                        System.out.println("Error debe ser mayor a 0");
                        return;
                    }
                    vehiculos.add(new VehiculoParticular(patente, marca, pendientes, pasajeros));
                    System.out.println("Vehiculo registrado con exito");
                }
            } catch(NumberFormatException e){
                System.out.println("Error");
            }
        private static void listarVehiculos(){
            System.out.println("Vehiculos registrados");
            if(vehiculo.isEmpty){
                System.out.println("No hay vehiculos registrados");
            }
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + vehiculos.get(i).mostrarInfo());
            }

        }

        private static void buscarPatente(){
            System.out.println("Buscar vehiculo: ");
            if(vehiculos.isEmpty){
                System.out.println("No HAY VEHICULOS REGISTRADOS.");
                return;
            }
        }
        for (int i = 0; < vehiculos.size(); ni ++){
            System.out.println("(" + (i + 1) + vehiculos.get(i).mostrarInfo());
        }
        private static void buscarPatente(){
            System.out.println("Buscar vehiculo: ");
            if(vehiculos.isEmpty){
                System.out.println("No hay vehiculos registrados");
                return;
            }
        }
        System.out.println("Ingresa texto a buscar: ");
        String texto = scanner.nextLine().trim().tolowerCase();

        boolean encontrado= false;
        System.out.println("resultados: ");
        for(Vehiculo v : vehiculos){
            if(v.getPatente().contains(texto)){
                System.out.println(mostrarInfo());
                encontrado=true;
            }


        }


    

    }
}


