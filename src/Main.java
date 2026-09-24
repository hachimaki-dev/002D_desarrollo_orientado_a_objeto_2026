import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehiculo> autos = new ArrayList<>();
    static ArrayList<VehiculoParticular> autosParticulares = new ArrayList<>();
    static ArrayList<VehiculoCarga> autosCargueros = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("=== TALLER MECANICO ===");
                System.out.println("1. Registrar vehículos");
                System.out.println("2. Listar vehículos");
                System.out.println("3. Buscar vehículo por patente");
                System.out.println("4. Realizar revisión");
                System.out.println("5. Resumen de vehículos");
                System.out.println("6. Salir");
                System.out.print("Elige una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());
                try {
                    if (opcion < 1 || opcion > 6) {
                        System.out.println("Opcion invalida, por favor seleccione una opcion del 1 al 6.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Opcion invalida, por favor seleccione una opcion con numeros enteros.");
                }

                switch (opcion) {
                    case 1:
                        agregarVehiculos();
                        break;
                    case 2:
                        listarVehiculos();
                        break;
                    case 3:
                        buscarVehiculoPorPatente();
                        break;
                    case 4:
                        realizarRevision();
                        break;
                    case 5:
                        realizarRevision();
                        break;
                    case 6:
                        System.out.println("Muchas gracias por utilizar el sistema.");
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error, ingrese una opcion valida. Del 1 al 6 en numeros enteros.");
            }
        }
    }

    static void agregarVehiculos() {
        try {
            System.out.println("¿Que tipo de vhículo vas a registrar?");
            System.out.println("1. Vehículo Particular.");
            System.out.println("2. Vehículo de carga.");
            System.out.print("Elige tu opción: ");
            int tipoVehículo = Integer.parseInt(scanner.nextLine());

            if (tipoVehículo < 1 || tipoVehículo > 2) {
                System.out.println("Opcion invalida, ingresa un tipo de vehículo valido.");
            }

            if (tipoVehículo == 1) {
                try {
                    System.out.print("Ingrese la capacidad de pasajeros del vehículo:");
                    int capacidad = Integer.parseInt(scanner.nextLine());
                    if (capacidad <= 0) {
                        System.out.println("La capacidad del vehículo debe ser mayor a 0.");
                        return;
                    }
                    System.out.print("Ingrese la patente del vehiculo: ");
                    String patente = scanner.nextLine();
                    System.out.print("Ingrese la marca del vehiculo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de revisiones pendientes:");
                    int revisiones = Integer.parseInt(scanner.nextLine());
                    if (revisiones < 0) {
                        System.out.println("No puedes tener revisiones negativas.");
                        return;
                    } else {
                        VehiculoParticular particular = new VehiculoParticular(patente, marca, revisiones, capacidad);
                        autosParticulares.add(particular);
                        autos.add(particular);

                    }
                } catch (IllegalArgumentException e) {
                    System.out
                            .println("Error, capacidad no valida, ingrese una capacidad a través de numeros enteros.");
                }
            } else if (tipoVehículo == 2) {
                try {
                    System.out.print("Ingrese la capacidad de peso del vehículo:");
                    int peso = Integer.parseInt(scanner.nextLine());

                    if (peso <= 0) {
                        System.out.println("La capacidad del vehículo debe ser mayor a 0.");
                    }
                    System.out.print("Ingrese la patente del vehiculo: ");
                    String patente = scanner.nextLine();
                    System.out.print("Ingrese la marca del vehiculo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de revisiones pendientes: ");
                    int revisiones = Integer.parseInt(scanner.nextLine());
                    if (revisiones < 0) {
                        System.out.println("No puedes tener revisiones negativas.");
                    } else {
                        VehiculoCarga carga = new VehiculoCarga(patente, marca, revisiones, peso);
                        autosCargueros.add(carga);
                        autos.add(carga);
                    }
                } catch (IllegalArgumentException e) {
                    System.out
                            .println("Error, capacidad no valida, ingrese una capacidad a través de numeros enteros.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Opcion invalida, utilice numeros enteros para identificar el tipo de vehículo.");
        }

    }

    static void listarVehiculos() {
        if (autos.size() == 0) {
            System.out.println("No hay vehiculos.");
            return;
        }
        for (int i = 0; i < autos.size(); i++) {
            System.out.println(autos.get(i).mostrarInfo());
        }
    }

    static void buscarVehiculoPorPatente() {
        if (autos.size() == 0) {
            System.out.println("No hay vehiculos.");
            return;
        }
        System.out.print("Ingrese la patente del vehiculo: ");
        String preguntarPatente = scanner.nextLine().toUpperCase();
        if (preguntarPatente == null || preguntarPatente.isEmpty()) {
            System.out.println("Vehiculo no encontrado, ingrese una nueva patente. ");
            for (int i = 0; i < autos.size(); i++) {
                if (autos.get(i).getPatente().toUpperCase().contains(preguntarPatente)) {
                    System.out.println(autos.get(i).mostrarInfo());
                    break;
                }
            }
        }
    }

    static void realizarRevision() {
        if (autos.size() == 0) {
            System.out.println("No hay vehiculos.");
            return;
        }
        boolean hayRevisionesPendientes = false;
        for (int i = 0; i < autos.size(); i++) {
            if (autos.get(i).getRevisionesPendientes() > 0) {
                hayRevisionesPendientes = true;
                break;
            }
            if (!hayRevisionesPendientes) {
                System.out.println("No hay vehiculos por revisar. ");
                return;
            }
        }
        for (int i = 0; i < autos.size(); i++) {
            System.out.println((i + 1) + " Revisiones pendientes: " + autos.get(i).getRevisionesPendientes()
                    + " Costo de revision: " + autos.get(i).calcularCostoRevision());
        }
        int revisar;
        while (true) {
            try {
                System.out.println("Elige el auto que quieres revisar: ");
                revisar = Integer.parseInt(scanner.nextLine());
                revisar -= 1;
                if (revisar < 0 || revisar > autos.size() - 1) {
                    System.out.println("Dato invalido. Debes elegir un vehiculo. ");
                    return;
                } else {
                    if (autos.get(revisar).getRevisionesPendientes() > 0) {
                        break;
                    } else {
                        System.out.println("Este auto no tiene revisiones pendientes. ");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Dato invalido. En este apartado solo se ingresan numeros.");
            }
        }

        autos.get(revisar).reducirRevisionesPendientes();
        System.out.println("Revision realizada con exito.");
    }

    static void resumenDeVehiculos() {
        if (autos.size() == 0) {
            System.out.println("No hay vehiculos.");
            return;
        }
        for (int i = 0; i < autosParticulares.size(); i++) {
            System.out.println("Autos particulares: " + autosParticulares.get(i).mostrarInfo() + " Costo de revision: "
                    + autosParticulares.get(i).calcularCostoRevision());
        }
        for (int i = 0; i < autosCargueros.size(); i++) {
            System.out.println("Autos de carga: " + autosCargueros.get(i).mostrarInfo() + " Costo de revision: "
                    + autosCargueros.get(i).calcularCostoRevision());
        }

        int costoP = 0;
        int costoC = 0;

        for (int i = 0; i < autosParticulares.size(); i++) {
            costoP += autosParticulares.get(i).calcularCostoRevision() * autos.get(i).getRevisionesPendientes();
        }
        for (int i = 0; i < autosCargueros.size(); i++) {
            costoC += autosCargueros.get(i).calcularCostoRevision() * autos.get(i).getRevisionesPendientes();
        }

        System.out.println("Costo total de los vehiculos particulares: " + costoP);
        System.out.println("Costo total de los vehiculos cargueros: " + costoC);
    }
}
// La diferencia principal que note entre java y python es principalmente en la exigencia de java, que es muy deforme y lo odie mucho.