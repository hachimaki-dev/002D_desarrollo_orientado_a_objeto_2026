import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> inventario = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion:");

            String opcionTexto = sc.nextLine();

        
                

                switch (opcionTexto) {
                    case "1":
                        registrarVehiculo();
                        break;

                    case "2":
                        listarVehiculos();
                        break;

                    case "3":
                        buscarVehiculos();
                        break;

                    case "4":
                        realizarRevision();
                        break;

                    case "5":
                        mostrarResumen();
                        break;

                    case "6":
                        salir = true;
                        mostrarMensaje("Programa Finalizado.");
                        break;

                    default:
                        mostrarMensaje("Esa opcion no existe.", "ERROR");
                }

        }
        sc.close();
    }

    static void registrarVehiculo(){
        System.out.println("--- Tipo de Vehiculo ---");
        System.out.println("1. Vehiculo Particular");
        System.out.println("2. Vehiculo Carga");
        System.out.println("Seleccione:");

        try {
            int tipo = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Patente");
            String patente = sc.nextLine();

            System.out.print("Marca");
            String marca = sc.nextLine();

            System.out.print("Revisiones pendientes:");
            int revisionesPendientes = Integer.parseInt(sc.nextLine().trim());

            if(tipo == 1){
                System.out.print("Numero de pasajeros:");
                int numPasajeros = Integer.parseInt(sc.nextLine().trim());
                inventario.add(new VehiculoParticular(patente, marca, revisionesPendientes, numPasajeros));
                mostrarMensaje("Vehiculo Particular registrado", "OK");
            
            }else if (tipo == 2){
                System.out.print("Peso maximo de carga:");
                int pesoMaxCarga  = Integer.parseInt(sc.nextLine().trim());
                inventario.add(new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga));
                mostrarMensaje("Vehiculo de Carga registrado", "OK");

            }else{
                mostrarMensaje("Tipo de vehiculo invalido.", "ERROR");
            }

        }catch (NumberFormatException e) {
            mostrarMensaje("Debe ingresar un numero valido.", "ERROR");


        }
        
        




    }

    static void listarInventario(){
        System.out.println("--- Inventario ---");
        if (inventario.isEmpty()){
            mostrarMensaje("No hay productos registrados.", "INFO");
            return;
        }
        int i = i;
        for (Vehiculo p : inventario){
            System.out.println("[" + i + "]" + p.mostrarInfo());
            i++;

        }
    }

    static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    static void mostrarMensaje(String mensaje, String tipo) {
        System.out.println("[" + tipo + "]" + mensaje);
    }
}
