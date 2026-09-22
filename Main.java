import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> coleccion_vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
        
    }
    
    static void mostrarMenu(){
        boolean menu_activo = true;
        while(menu_activo){
            System.out.println("=== TALLER MECANICO ===");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculo");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revisión");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.println("7. Agregar datos de prueba");
            System.out.print("Ingresa la opción elegida: ");
            try {
int opcion_elegida = Integer.parseInt(sc.nextLine());

            switch (opcion_elegida) {
                case 1:
                    elegirVehiculo();
                    break;

                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    System.out.println("3");
                    buscarPatente();
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema, hasta pronto!");
                    menu_activo = false;
                    break;
                case 7:
                    datosPrueba();
                    System.out.println("Se han ingresado exitosamente los datos de testeo!");
                    break;
            
                default:
                    System.err.println("Ingresa una de las 7 opciones disponibles!");
                    break;
            }
                
            } catch (Exception e) {
                System.err.println("ingresa SOLAMENTE un número ENTERO valido.");
                // TODO: handle exception
            }
            


        }
        
    }

    static void listarVehiculos(){
        if(coleccion_vehiculos.isEmpty()){
            System.err.println("No se puede acceder, la coleccion se encuentra actualmente vacia.");
        }
        else{
            System.out.println("=== INVENTARIO DE VEHICULOS ===");
            System.out.println("SE HAN ENCONTRADO LOS SIGUIENTES VEHICULOS: ");
            for (Vehiculo vehiculo : coleccion_vehiculos) {
            System.out.println(vehiculo.mostrarInfo());
            }
    }

        
        
    }

    static void buscarVehiculo(){
        System.out.println("=== MENÚ DE BUSQUEDA ===");
        

    }

    static void buscarPatente(){
        if(coleccion_vehiculos.isEmpty()){
            System.out.println("No se puede acceder, no hay patentes ni vehiculos registrados.");
        }
        else{
        boolean encontrado = false;
        while(!encontrado){
            System.out.print("Ingrese la patente del vehiculo a buscar: ");
            String patente_buscada = sc.nextLine();
            for (Vehiculo vehiculo : coleccion_vehiculos) {
            if(patente_buscada.equalsIgnoreCase(vehiculo.getPatente())){
                System.out.println("Se ha encontrado: " + vehiculo.mostrarInfo());
                encontrado = true;
            }
            else{
                System.err.println("No se ha encontrado la patente escrita.");
            }
                
            }





        }

        }

        
    }

    static void elegirVehiculo(){
        boolean menu_activo = true;
        while (menu_activo) {
            try {
                System.out.println("=== SELECCION DE VEHICULO ===");
                System.out.println("1. Vehiculo particular");
                System.out.println("2. Vehiculo de carga");
                System.out.println("3. Volver atras");
                System.out.print("Ingresa tu elección: ");
                int opcion_usuario = Integer.parseInt(sc.nextLine()); 

                switch (opcion_usuario) {
                    case 1:
                        registrarVehiculoParticular();
                        break;
                    case 2:
                        break;
                    case 3:
                        menu_activo = false;
                        break;
                
                    default:
                        System.err.println("Ingresa una de las 3 opciones disponibles!");
                        break;
                }
                
            } catch (Exception e) {
                System.err.println("Ingresa un valor ENTERO valido.");
                // TODO: handle exception
            }
            
        }
    }

    static void registrarVehiculoParticular(){
        System.out.print("Ingresa el número de pasajeros: ");
        String patente = pedirPatente();
        String marca = pedirMarca();
        int cantidad_pasajeros = pedirNumeroPasajeros();
        int revisiones = pedirRevisionesPendientes();
        VehiculoParticular vehiculo = new VehiculoParticular(patente, marca, cantidad_pasajeros, revisiones);
        coleccion_vehiculos.add(vehiculo);

    }

    static void registrarVehiculoCarga(){
        System.out.println("Ingresa el peso máximo que puede cargar el vehiculo: ");
        String patente = pedirPatente();
        String marca = pedirMarca();
        int peso_carga = pedirMaxPesoCarga();
        int revisiones = pedirRevisionesPendientes();
        VehiculoCarga vehiculo = new VehiculoCarga(patente, marca, peso_carga, revisiones);
        coleccion_vehiculos.add(vehiculo);

    }

    static String pedirPatente(){
        while(true){
            String patente = sc.nextLine();
            if(patente.length() <= 0){
                System.err.println("La patente no puede estar vacia!");
            }   
            else{
                return patente;
            }
        }
    }

    static String pedirMarca(){
        while(true){
            String marca = sc.nextLine();
            if(marca.length() <= 0){
                System.err.println("El nombre de la marca no puede estar vacio!");
            }   
            else{
                return marca;
            }
        }
    }

    static int pedirNumeroPasajeros(){
        while(true){
            try {
                int num_pasajeros = Integer.parseInt(sc.nextLine());
                if (num_pasajeros < 0){
                    System.err.println("La cantidad de pasajeros no puede ser menor a 0.");
                }
                else{
                    return num_pasajeros;

                }
                }
             catch (Exception e) {
                System.err.println("Ingresa un valor ENTERO valido para los pasajeros!");
                // TODO: handle exception
            }
        }
    }

static int pedirMaxPesoCarga(){
        while(true){
            try {
                int peso = Integer.parseInt(sc.nextLine());
                if (peso < 0){
                    System.err.println("El peso que carga el vehiculo no puede ser menor a 0!");
                }
                else{
                    return peso;

                }
                }
             catch (Exception e) {
                System.err.println("El peso solo puede ser un ENTERO!");
                // TODO: handle exception
            }
        }
    }

        static int pedirRevisionesPendientes(){
        while(true){
            try {
                int rev_pendientes = Integer.parseInt(sc.nextLine());
                if (rev_pendientes < 0){
                    System.err.println("La cantidad de revisiones pendientes no puede ser menor a 0.");
                }
                else{
                    return rev_pendientes;

                }
                }
             catch (Exception e) {
                System.err.println("Ingresa un valor ENTERO valido para las revisiones pendientes!");
                // TODO: handle exception
            }

        }
}


    static void datosPrueba(){
        VehiculoCarga vehiculo = new VehiculoCarga("TM-48", "TOYOTA", 2, 100);
        VehiculoCarga vehiculo2 = new VehiculoCarga("TM-51", "HYUNDAI", 2, 120);
        VehiculoParticular vehiculo3 = new VehiculoParticular("TM-54", "MITSUBISHI", 2, 4);

        coleccion_vehiculos.add(vehiculo);
        coleccion_vehiculos.add(vehiculo2);
        coleccion_vehiculos.add(vehiculo3);
    }
}