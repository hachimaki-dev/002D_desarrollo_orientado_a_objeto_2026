import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> coleccion_vehiculos = new ArrayList<>();
    static ArrayList<VehiculoParticular> coleccion_particulares = new ArrayList<>();
    static ArrayList<VehiculoCarga> coleccion_carga = new ArrayList<>();
    

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
                    buscarPatente();
                    break;
                case 4:
                    realizarRevision();
                    break;
                case 5:
                    resumenVehiculos();
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
            if(vehiculo.getPatente().toLowerCase().contains(patente_buscada)){
                System.out.println("Se ha encontrado: " + vehiculo.mostrarInfo());
                encontrado = true;
            }
            }

            if(!encontrado){
                System.err.println("No se ha encontrado la patente escrita.");
                break;
            }
                
            }





        }

        }

        
    static void realizarRevision(){
        if(coleccion_vehiculos.isEmpty()){
            System.err.println("No se han encontrado vehiculos registrados.");
        }
        else{
            System.out.println("Vehiculos encontrados: ");
            int contador = 0;
            for (Vehiculo vehiculo : coleccion_vehiculos) {
                System.out.println((contador + 1) + "- " + vehiculo.mostrarInfo());
                contador++;

                if(vehiculo.getRevisionesPendientes() <= 0){
                    System.out.println("El vehiculo seleccionado no cuenta con revisiones pendientes.");
                }
            }
            
                while(true){
                    try {
                        System.out.print("Ingresa el indice a buscar: ");
                        int indice = Integer.parseInt(sc.nextLine());

                        if(indice <= 0 || indice > coleccion_vehiculos.size() - 1){
                            System.err.println("Ingresa un indice disponible en la lista");
                        }
                        else{
                            for (Vehiculo vehiculo : coleccion_vehiculos) {
                                if(vehiculo.getRevisionesPendientes() <= 0){
                                System.err.println("El vehiculo seleccionado no dispone de revisiones pendientes");
                                }
                                else{
                                    System.out.println("Perdón profe le falle no puedo más, debo ir al baño.");
                                }
                                
                            }



                            

                        }
                        
                    } catch (Exception e) {
                        System.err.println("Ingresa el indice como un número ENTERO valido.");
                        // TODO: handle exception
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
                        registrarVehiculoCarga();
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

    static void resumenVehiculos(){
        if(coleccion_vehiculos.isEmpty()){
            System.err.println("No hay ningún vehiculo registrado.");
        }
        else{
            int contador_total = 0;
            int contador_carga = 0;
            int contador_particulares = 0;
            int ingresos_proyectados = 0;

            for (Vehiculo vehiculo : coleccion_vehiculos) {
                contador_total++;
                if(vehiculo instanceof VehiculoParticular){
                    contador_particulares++;
                    ingresos_proyectados += (vehiculo.calcularCostoRevision());
                }
                if(vehiculo instanceof VehiculoCarga){
                    contador_carga++;
                    ingresos_proyectados += (vehiculo.calcularCostoRevision());
                }
            }

            System.out.println("Total vehiculos: " + contador_total );
            System.out.println("Vehiculos particulares: " + contador_particulares);
            System.out.println("Vehiculos de carga: " + contador_carga);
            System.out.println("Ingresos proyectados: " + ingresos_proyectados);

        }
    }

    static void registrarVehiculoParticular(){
        System.out.print("Ingresa la patente: ");
        String patente = pedirPatente();
        System.out.print("Ingresa la marca: ");
        String marca = pedirMarca();
        System.out.print("Ingresa el número de pasajeros: ");
        int cantidad_pasajeros = pedirNumeroPasajeros();
        System.out.print("Ingresa la cantidad de revisiones pendientes: ");
        int revisiones = pedirRevisionesPendientes();
        VehiculoParticular vehiculo = new VehiculoParticular(patente, marca, cantidad_pasajeros, revisiones);
        coleccion_particulares.add(vehiculo);
        coleccion_vehiculos.add(vehiculo);

    }

    static void registrarVehiculoCarga(){
        System.out.print("Ingresa la patente: ");
        String patente = pedirPatente();
        System.out.print("Ingresa la marca: ");
        String marca = pedirMarca();
        System.out.print("Ingresa el peso máximo que puede cargar el vehiculo: ");
        int peso_carga = pedirMaxPesoCarga();
        System.out.print("Ingresa la cantidad de revisiones pendientes: ");
        int revisiones = pedirRevisionesPendientes();
        
        VehiculoCarga vehiculo = new VehiculoCarga(patente, marca, peso_carga, revisiones);
        coleccion_carga.add(vehiculo);
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
        coleccion_carga.add(vehiculo);
        coleccion_vehiculos.add(vehiculo2);
        coleccion_carga.add(vehiculo2);
        coleccion_vehiculos.add(vehiculo3);
        coleccion_particulares.add(vehiculo3);
    }
}