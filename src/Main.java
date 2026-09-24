//R1: Comentarios de paradigma
// - Que paradigma de programacion se esta usando y sus caracteristicas
//principales.
//Este programa usa el paradigma orientado a objetos (POO), en poo el codigo se organiza en clases que 
//representan entidades del mundo real, encapsulando datos (atributos) y comportamientos (metodos) en una misma unidad
// - Al menos 2 diferencias concretas entre poo y python funcional
//Java es un lenguaje compilado (como que vee todo el codigo de una), todo debe estar organizado dentro del un metodo 
//"class" y un metodo main, en python el programa se ejecuta linea por linea
//en java cada variable debe especificar su tipo de dato y este no puede cambiar, en python no se declaran con tipo y
//si pueden cambiar
//profe una buena nota porfa :c

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    public static void main(String[] args) {
        mostrarMenu();
    }
    static void mostrarMenu(){
        System.out.println("=== BIENVENIDO ===");
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("--- TALLER MECANICO ---");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.println("7. Precargar datos de prueba");
            System.out.println("--- Seleccione una opcion: ---" );
            String opcion_usuario = sc.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarVehiculo();
                    break;
                case "2":
                    listarVehiculos();
                    break;
                case "3":
                    buscarPorPatente();
                    break;
                case "4":
                    realizarRevision();
                    break;
                case "5":
                    resumenVehiculos();
                    
                    break;
                case "6":
                    System.out.println("Finalizando ...");
                    System.out.println("Hasta pronto. :)");
                    mostrar_menu = false;
                    
                    break;
                case "7":
                    datosPrueba();
                    break;
            
                default:
                    System.err.println("Ingrese una opcion valida (!)");
                    break;
            }





        }
    }
    static void registrarVehiculo(){
        System.out.println("===REGISTRO DE VEHICULOS===");
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("//opciones");
            System.out.println("1. Vehiculo particular");
            System.out.println("2. Vehiculo carga");
            System.out.println("3. Volver");
            String opcion_usuario = sc.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarVehiculoParticular();
                    
                    break;
                case "2":
                    registrarVehiculoCarga();
                    
                    break;
                case "3":
                    System.out.println("Volviendo ...");
                    mostrar_menu = false;
                    break;
                default:
                    System.err.println("Ingrese una opcion valida (!)");
                    break;
            }
            
        }
    }
    static void registrarVehiculoParticular(){
        System.out.println("Vehiculo particular ...");
        String patente = " ";
        while (patente.trim().isEmpty()) {
        System.out.println("Ingrese la patente del vehiculo: ");
        patente = sc.nextLine();
        if (patente.trim().isEmpty()){
            System.err.println("La patente no puede estar vacia (!)");
        }
       }
        String marca = " ";
        while (marca.trim().isEmpty()) {
        System.out.println("Ingrese la marca del vehiculo: ");
        marca = sc.nextLine();
        if (marca.trim().isEmpty()){
            System.err.println("La marca no puede estar vacia (!)");
        }
       }
        
        boolean verificado = false;
        int revisiones_pendientes = 0;
        int numero_pasajeros = 0;
        while (!verificado) {
            try{
                System.out.println("Ingrese las revisiones pendientes: ");
                revisiones_pendientes = Integer.parseInt(sc.nextLine());
                if(revisiones_pendientes >= 0){
                   verificado = true;
                } else {
                    System.out.println("Ingrese un numero mayor o igual 0 (!)");
                }
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un numero entero (!)");
            }
        }
        verificado = false;
        while (!verificado) {
            try{
                System.out.println("Ingrese el numero de pasajeros: ");
                numero_pasajeros = Integer.parseInt(sc.nextLine());
                if (numero_pasajeros > 0){
                     verificado = true;
                } else {
                    System.err.println("Ingrese un numero mayor a 0 (!)");
                }
               
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un numero entero (!)");
            }
        }
        VehiculoParticular vp = new VehiculoParticular(patente, marca, revisiones_pendientes, numero_pasajeros);
        listaVehiculos.add(vp);

    }

    static void registrarVehiculoCarga(){
        System.out.println("Vehiculo de carga ...");
        String patente = " ";
        while (patente.trim().isEmpty()) {
        System.out.println("Ingrese la patente del vehiculo: ");
        patente = sc.nextLine();
        if (patente.trim().isEmpty()){
            System.err.println("La patente no puede estar vacia (!)");
        }
       }
        String marca = " ";
        while (marca.trim().isEmpty()) {
        System.out.println("Ingrese la marca del vehiculo: ");
        marca = sc.nextLine();
        if (marca.trim().isEmpty()){
            System.err.println("La marca no puede estar vacia (!)");
        }
       }
        boolean verificado = false;
        int revisiones_pendientes = 0;
        int peso_max = 0;
        while (!verificado) {
            try{
                System.out.println("Ingrese las revisiones pendientes: ");
                revisiones_pendientes = Integer.parseInt(sc.nextLine());
                if (revisiones_pendientes >= 0){
                    verificado = true;
                } else {
                    System.err.println("Ingrese un numero mayor o igual a 0 (!)");
                }
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un numero entero (!)");
            }
        }
        verificado = false;
        while (!verificado) {
            try{
                System.out.println("Ingrese el peso maximo de carga: ");
                peso_max = Integer.parseInt(sc.nextLine());
                if (peso_max > 0) {
                    verificado = true;
                } else {
                    System.err.println("Ingrese un numero mayor a 0 (!)");
                }
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un numero entero (!)");
            }
        }
        VehiculoCarga vc = new VehiculoCarga(patente, marca, revisiones_pendientes, peso_max);
        listaVehiculos.add(vc);

    }
    static void listarVehiculos(){
        if (listaVehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados (!)");
            return;
        }
        System.out.println("=== LISTA DE VEHICULOS ===");
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.mostrarInfo());
            
        }
    }
    static void datosPrueba(){
        System.out.println("===PRECARGANDO DATOS DE PRUEBA===");
        System.out.println("-----------------------------------------------");
        VehiculoParticular vp = new VehiculoParticular("123456", "toyota", 7, 4);
        VehiculoParticular vp1 = new VehiculoParticular("654321", "subaru", 5,2);
        VehiculoParticular vp2 = new VehiculoParticular("123654", "suzuki", 3, 6);
        listaVehiculos.add(vp);
        listaVehiculos.add(vp1);
        listaVehiculos.add(vp2);
        VehiculoCarga vc = new VehiculoCarga("098765", "mercedes", 0, 1000);
        VehiculoCarga vc1 = new VehiculoCarga("095465", "toyota", 4, 500);
        VehiculoCarga vc2 = new VehiculoCarga("0384654", "mitsubishi", 7, 2500);
        listaVehiculos.add(vc);
        listaVehiculos.add(vc1);
        listaVehiculos.add(vc2);
        System.out.println("DATOS DE PRUEBA CARGADOS");
        System.out.println("-----------------------------------------------");
    }
    static void buscarPorPatente(){
        if (listaVehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados (!)");
            return;
        }

        System.out.println("Buscar por patente");
        System.out.println("Ingrese la patente a buscar: ");
        String patente_a_buscar = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        for (Vehiculo v : listaVehiculos) {
            if (v.getPatente().toLowerCase().contains(patente_a_buscar)){
                System.out.println(v.mostrarInfo());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay vehiculos registrados con esa patente (?)");
        }
        
    }
    static void realizarRevision(){
        if (listaVehiculos.isEmpty()){
            System.err.println("No hay vehiculos registrados (!)");
            return;
        }
        System.out.println("=== VEHICULOS ===");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo v = listaVehiculos.get(i);
            System.out.println("Vehiculo numero: " + "[" + (i + 1)+ "]"+ " " + "Patente. " + v.getPatente() + " " + "Marca. " + v.getMarca() + " " + "Revisiones pendientes: " + v.getRevisionesPendientes());
        }
        try {
            System.out.println("Ingrese el numero del vehiculo: ");
            int opcion_vehiculo = Integer.parseInt(sc.nextLine());
            int index = opcion_vehiculo -1;
            if (index < 0 || index >= listaVehiculos.size()){
                System.err.println("El numero ingresado no existe (!)");
                return;
            }
            Vehiculo v_seleccionado = listaVehiculos.get(index);

            if (v_seleccionado.getRevisionesPendientes() <= 0){
                System.err.println("El vehiculo no tiene revisiones pendientes (!)");
                return;
            }
            int nuevas_pendientes = v_seleccionado.getRevisionesPendientes()-1;
            v_seleccionado.setRevisionesPendientes(nuevas_pendientes);
            System.out.println("---REVISION REALIZADA CON EXITO---");
            System.out.println("Vehiculo: " + v_seleccionado.getPatente() + " " + "Marca: " + v_seleccionado.getMarca());
            System.out.println("Costo de revision: " + v_seleccionado.calcularCostoRevision());
            System.out.println("Nueva cantidad de revisones pendientes: " + v_seleccionado.getRevisionesPendientes());
            

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor entero (!)");
            }
    }
    static void resumenVehiculos(){
        if (listaVehiculos.isEmpty()){
            System.err.println("No hay vehiculos registrados (!)");
            return;
        }
        System.out.println("===RESUMEN DE VEHICULOS===");
        int total_vehiculos = listaVehiculos.size();
        int particulartes = 0;
        int carga = 0;
        long ingresos_proyectados = 0;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof VehiculoParticular){
                particulartes ++;
            } else if (vehiculo instanceof VehiculoCarga){
                carga++;
            }
            ingresos_proyectados += (long) vehiculo.calcularCostoRevision() * vehiculo.getRevisionesPendientes();
            
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total de vehiculos registrados: " + total_vehiculos);
        System.out.println("Total e vehiculos particulares: " + particulartes);
        System.out.println("Total de vehiculos de carga " + carga);
        System.out.println("Ingresos protectados: " + ingresos_proyectados);
        System.out.println("----------------------------------------------");
    }
}
