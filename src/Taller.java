
import java.util.ArrayList;
import java.util.Scanner;

public class Taller {

    static ArrayList<VehiculoParticular> ListaVehiculosParticulares = new ArrayList<>();
    static ArrayList<VehiculoCarga> ListaVehiculosCargas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bienvenido al Taller Mecanico");
        boolean MostrarMenu = true;

        while (MostrarMenu) {
            System.out.println("********TALLER MECANICO********");
            System.out.println("1. Registrar Vehiculo");
            System.out.println("2. Listar Vehiculo");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar Revisión");
            System.out.println("5. Resumen Vehiculos");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opción");

            String opcion_usuario = sc.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarvehiculo();
                    break;

                case "2":
                    ListarVehiculos();
                    break;

                case "3":
                    BuscarVehiculoPorPatente();
                    break;

                case "4":
                    RealizarRevision();
                    break;

                case "5":
                    ResumenVehiculos();
                    break;

                case "6":
                    System.out.println("Muchas gracias por su visita C:");
                    MostrarMenu = false;
                    break;

                case "7":
                    AgregarDatos();
                    break;

                default:
                    System.out.println("Ingrese una opción válida :(");
                    break;
            }
        }

    }
    static void ResumenVehiculos(){
        System.out.println("Resumen de vehiculos");
        int contador1 = 1;
        int total_VehiculoParticular = 0;
        for (VehiculoParticular vehiculoParticular : ListaVehiculosParticulares) {
            contador1 += 1;
            total_VehiculoParticular = vehiculoParticular.calcularCostoRevision() * vehiculoParticular.getRevisionesPendientes();
        }
        System.out.println("TOTAL VEHICULOS DE CARGA: " + contador1);
        int contador0 = 1;
        int total_VehiculoCarga = 0;
        for (VehiculoCarga vehiculoCarga : ListaVehiculosCargas) {
            contador0 += 1;
            total_VehiculoCarga = vehiculoCarga.calcularCostoRevision() * vehiculoCarga.getRevisionesPendientes();
        }
        System.out.println("TOTAL VEHICULOS DE CARGA: " + contador0);

        int TOTAL = total_VehiculoCarga + total_VehiculoParticular;

        System.out.println("TOTAL DE VENTAS: $" + TOTAL);
    }
    static void RealizarRevision() {

        boolean revision = true;

        while (revision) {
            System.out.println("¿A qué tipo de vehiculo desea realizar la revisión?");
            System.out.println("1. Vehiculos Particulares");
            System.out.println("2. Vehiculos de Carga");
            System.out.println("3. Salir");

            String Opcion = sc.nextLine();

            switch (Opcion) {
                case "1":
                    RevisionVehiculoParticular();
                    break;

                case "2":
                    RevisionVehiculoCarga();
                    break;

                case "3":
                    revision = false;
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }

    }

    static void RevisionVehiculoParticular() {
        if (ListaVehiculosParticulares.isEmpty()) {
            System.out.println("No hay vehiculos particulares registrados");
        } else {
            int contador = 1;
            for (VehiculoParticular vehiculoP : ListaVehiculosParticulares) {
                System.out.println(contador + ". La patente del vehiculo es: " + vehiculoP.getPatente()
                        + ". La marca del vehiculo es: " + vehiculoP.getMarca() + ". El costo de revisión es de: $"
                        + vehiculoP.calcularCostoRevision() + ". Sus revisiones pendientes son: " + vehiculoP.getRevisionesPendientes());
                contador += 1;
            }

            System.out.println("¿A qué vehiculo deseas realizar la revisión?");

            int VEHICULO = Integer.parseInt(sc.nextLine());

            VEHICULO -= 1;

            if (ListaVehiculosParticulares.get(VEHICULO).getRevisionesPendientes() > 0) {
                ListaVehiculosParticulares.get(VEHICULO).setRevisionesPendientes(VEHICULO);
                System.out.println("PATENTE: " + ListaVehiculosParticulares.get(VEHICULO).getPatente() + ". MARCA: " + ListaVehiculosParticulares.get(VEHICULO).getMarca() + ". TOTAL DE REVISIÓN: $" + ListaVehiculosParticulares.get(VEHICULO).calcularCostoRevision());
            } else{
                ListaVehiculosParticulares.get(VEHICULO).setRevisionesPendientes(VEHICULO);
            }

            
            
            

        }
    }

    static void RevisionVehiculoCarga() {
        if (ListaVehiculosCargas.isEmpty()) {
            System.out.println("No hay vehiculos de carga registrados");
        } else {
            int contador = 1;
            for (VehiculoCarga vehiculoC : ListaVehiculosCargas) {
                System.out.println(contador + ". La patente del vehiculo es: " + vehiculoC.getPatente()
                        + ". La marca del vehiculo es: " + vehiculoC.getMarca() + ". El costo de revisión es de: $"
                        + vehiculoC.calcularCostoRevision() + ". Sus revisiones pendientes son: " + vehiculoC.getRevisionesPendientes());
                contador += 1;
            }

            System.out.println("¿A qué vehiculo deseas realizar la revisión?");

            int VEHICULO = Integer.parseInt(sc.nextLine());

            VEHICULO -= 1;
            if (ListaVehiculosCargas.get(VEHICULO).getRevisionesPendientes() > 0) {
                System.out.println("PATENTE: " + ListaVehiculosCargas.get(VEHICULO).getPatente() + ". MARCA: " + ListaVehiculosCargas.get(VEHICULO).getMarca() + ". TOTAL DE REVISIÓN: $" + ListaVehiculosCargas.get(VEHICULO).calcularCostoRevision());
            } else{
                ListaVehiculosCargas.get(VEHICULO).setRevisionesPendientes(VEHICULO);
            }

            

            

        }

    }

    static void BuscarVehiculoPorPatente() {
        System.out.println("Ingrese la patente que desea buscar");
        String patente = sc.nextLine();
        System.out.println("VEHICULOS PARTICULARES:");
        for (VehiculoParticular vehiculoParticular : ListaVehiculosParticulares) {
            if (vehiculoParticular.getPatente().toLowerCase().contains(patente.toLowerCase())) {
                System.out.println(vehiculoParticular.mostrarInfo());
            }
        }

        System.out.println("VEHICULOS DE CARGA:");
        for (VehiculoCarga vehiculoCarga : ListaVehiculosCargas) {
            if (vehiculoCarga.getPatente().toLowerCase().contains(patente.toLowerCase())) {
                System.out.println(vehiculoCarga.mostrarInfo());
            }
        }
    }

    static void ListarVehiculos() {
        if (ListaVehiculosParticulares.isEmpty()) {
            System.out.println("No hay vehiculos particulares registrados");
        } else {
            System.out.println("LISTA VEHICULOS PARTICULARES:");
            for (VehiculoParticular vehiculo : ListaVehiculosParticulares) {
                System.out.println(vehiculo.mostrarInfo());
            }
        }

        if (ListaVehiculosCargas.isEmpty()) {
            System.out.println("No hay vehiculos de carga registrados");
        } else {
            System.out.println("LISTA VEHICULOS DE CARGA:");
            for (VehiculoCarga vehiculo : ListaVehiculosCargas) {
                System.out.println(vehiculo.mostrarInfo());
            }
        }
    }

    static void registrarvehiculo() {
        System.out.println("Bienvenido al registro de Vehiculos");
        boolean mostrar_registro = true;

        while (mostrar_registro) {
            System.out.println("¿Qué tipo de vehiculo desea registrar?");
            System.out.println("1. Vehiculo Particular");
            System.out.println("2. Vehiculo de Carga");
            System.out.println("3. Salir");
            System.out.println("ELIGA UNA OPCIÓN");

            String opcion_usuario = sc.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarvehiculoparticular();
                    break;

                case "2":
                    registrarvehiculocarga();
                    break;

                case "3":
                    System.out.println("Saliendo del registro!");
                    mostrar_registro = false;
                    break;

                default:
                    System.out.println("Ingrese una opción válida :(");
                    break;
            }
        }

    }

    static void registrarvehiculocarga() {
        boolean Registro = false;

        while (!Registro) {
            try {
                
                System.out.println("Ingrese la patente de su vehiculo");

                String patente = sc.nextLine();

                System.out.println("Ingrese la marca de su vehiculo");

                String marca = sc.nextLine();

                System.out.println("Ingrese las revisiones de su vehiculo");

                int revisiones = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese el peso máximo de su vehiculo");

                int peso = Integer.parseInt(sc.nextLine());

                ListaVehiculosCargas.add(new VehiculoCarga(patente, marca, revisiones, peso));

                Registro = true;

            } catch (NumberFormatException e) {
                System.out.println("Ingreso un caracter Invalido :(");
            }

        }
    }

    static void registrarvehiculoparticular() {

        boolean Registro = false;

        while (!Registro) {
            try {
                System.out.println("Ingrese la patente de su vehiculo");

                String patente = sc.nextLine();

                System.out.println("Ingrese la marca de su vehiculo");

                String marca = sc.nextLine();

                System.out.println("Ingrese las revisiones de su vehiculo");

                int revisiones = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese la cantidad de pasajeros de su vehiculo");

                int pasajeros = Integer.parseInt(sc.nextLine());

                ListaVehiculosParticulares.add(new VehiculoParticular(patente, marca, revisiones, pasajeros));

                Registro = true;

            } catch (NumberFormatException e) {
                System.out.println("Ingreso un caracter Invalido :(");
            }

        }
    }

    static void AgregarDatos() {
        System.out.println("****************************************************");
        System.out.println("*************INSERTANDO DATOS DE PRUEBA*************");
        System.out.println("****************************************************");

        ListaVehiculosCargas.add(new VehiculoCarga("DXLB21", "HYUNDAI", 0, 34));
        ListaVehiculosCargas.add(new VehiculoCarga("SCVK61", "MG", 5, 21));
        ListaVehiculosCargas.add(new VehiculoCarga("MCHG93", "NISSAN", 2, 57));
        ListaVehiculosCargas.add(new VehiculoCarga("ASLD32", "BMW", 87, 23));

        ListaVehiculosParticulares.add(new VehiculoParticular("ASJH34", "SUZUKI", 0, 12));
        ListaVehiculosParticulares.add(new VehiculoParticular("ASXC23", "TOYOTA", 1, 20));
        ListaVehiculosParticulares.add(new VehiculoParticular("BNAS21", "MG", 4, 2));
        ListaVehiculosParticulares.add(new VehiculoParticular("NMCB01", "MERCEDES", 23, 10));

    }
}
