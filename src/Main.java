
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        mostrarMenu();
    }
    public static void mostrarMenu() {
        while(true){
        System.out.println("=== TALLER MECANICO");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Listar vehiculos");
        System.out.println("3. Buscar vehiculo por patente");
        System.out.println("4. Realizar revision");
        System.out.println("5. Resumen de vehiculos");
        System.out.println("6. Salir");
        System.out.println("Seleccione una opcion: ");
        }
        int opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                registrarVehiculo();
                }

        }

        public static void registrarVehiculo(){
            System.out.println("=== Registrar vehiculo ===");
            System.out.println("Seleccione el tipo de vehiculo a registrar: ");
            System.out.println("1. Vehiculo particular");
            System.out.println("2. Vehiculo de carga");
            int tipo = Integer.parseInt(sc.nextLine());
            if (tipo == 1) {
                System.out.println("Patente: ");
                String patente = sc.nextLine();
                System.out.println("Marca: ");
                String marca = sc.nextLine();
                int revision = Integer.parseInt(sc.nextLine());
                System.out.println("Numero de pasajeros: ");
                String numeroPasajeros = sc.nextLine();
                vehiculos.add(new VehiculoParticular(String patente, marca, revision, numeroPasajeros));


        }


        
    }
}

