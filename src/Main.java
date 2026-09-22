import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<VehiculoParticular> vehiculosParticulares = new ArrayList<>();
    static ArrayList<VehiculoCarga> vehiculosCargas = new ArrayList<>();
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    static String mensajeErrorNegativos = "Error. Ingrese un valor numérico mayor o igual a 0.";

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu()
    {
        boolean ejecutarPrograma = true;

        while (ejecutarPrograma)
        {
            System.out.println("=== TALLER MECÁNICO ===");
            System.out.println("1. Registrar vehículo.");
            System.out.println("2. Listar vehículos.");
            System.out.println("3. Buscar vehíhulo por patente.");
            System.out.println("4. Realizar revisión.");
            System.out.println("5. Resumen de vehículos.");
            System.out.println("6. Salir.");

            int opcion = MisTryCatches.tryCatchInt("Seleccione una opción: ", "Error. Ingrese un valor numérico entre 1 y 6.");

            switch (opcion)
            {
                case 1 :
                    registrarVehiculo();
                    break;
                case 2 :
                    listarVehiculos();
                    break;
                case 3 :
                    buscarVehiculoPorPatente();
                    break;
                case 4 :
                    realizarRevision();
                    break;
                case 5 :
                    resumenDeVehiculos();
                    break;
                case 6 :
                    System.out.println("Programa finalizado.");
                    ejecutarPrograma = false;
                    break;
                default :
                    System.out.println("Ingrese un número válido (entre 1 y 6).");
            }
        }
    }

    //
    // 1
    //
    static void registrarVehiculo()
    {
        System.out.println("--- Tipo de vehículo ---");
        System.out.println("1. Particular");
        System.out.println("2. Carga");

        int opcion;

        while (true)
        {
            opcion = MisTryCatches.tryCatchInt("Seleccione: ", "Error. Ingrese un valor numérico entre 1 y 2.");

            if (opcion >= 1 && opcion <= 2)
            {
                break;
            }
            else 
            {
                System.out.println("Error. Ingrese un número válido (entre 1 y 2)");
            }
        }

        String patente = pedirString("Patente: ");
        String marca = pedirString("Marca: ");
        int revisionesPendientes = MisTryCatches.tryCatchIntPositivo("Revisiones pendientes: ", mensajeErrorNegativos);

        switch (opcion)
        {
            case 1 :
                int numeroDePasajeros = MisTryCatches.tryCatchIntPositivoMayorQueCero("Número de pasajeros: ", mensajeErrorNegativos);

                VehiculoParticular vParticular = new VehiculoParticular(patente, marca, revisionesPendientes, numeroDePasajeros);
                vehiculosParticulares.add(vParticular);
                vehiculos.add(vParticular);

                System.out.println("[OK] Vehículo particular registrado.");
                break;
            case 2 :
                int pesoMaxCarga = MisTryCatches.tryCatchIntPositivoMayorQueCero("Peso máximo de carga (kg): ", mensajeErrorNegativos);

                VehiculoCarga vCarga = new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga);
                vehiculosCargas.add(vCarga);
                vehiculos.add(vCarga);
                
                System.out.println("[OK] Vehículo de carga registrado.");
                break;
        }
    }

    //
    // 2
    //
    static void listarVehiculos()
    {
        System.out.println("--- VEHÍCULOS REGISTRADOS ---");

        if (vehiculos.size() == 0)
        {
            System.out.println("No hay vehículos registrados.");
        }
        else
        {
            for (int i = 0; i < vehiculos.size(); i++)
            {
                System.out.println("[" + (i+1) + "] " + vehiculos.get(i).mostrarInfo());
            }
        }
    }

    //
    // 3
    //
    static void buscarVehiculoPorPatente()
    {
        System.out.println("--- BUSCAR VEHÍCULO ---");

        System.out.print("Ingrese la patente del vehículo que quiere buscar: ");
        String patenteBuscada = sc.nextLine();
        
        ArrayList<Vehiculo> vehiculosBuscados = new ArrayList<>();

        for (Vehiculo v : vehiculos)
        {
            if (v.getPatente().toLowerCase().contains(patenteBuscada.toLowerCase()))
            {
                vehiculosBuscados.add(v);
            }
        }

        if (vehiculosBuscados.size() == 0)
        {
            System.out.println("No hay vehículos que contengan el texto '" + patenteBuscada + "' en su patente.");
            return;
        }

        System.out.println("Resultados:");

        for (Vehiculo v : vehiculosBuscados)
        {
            System.out.println(v.mostrarInfo());
        }
    }

    //
    // 4
    //
    static void realizarRevision()
    {
        System.out.println("--- REALIZAR REVISIÓN ---");

        int contadorRevisados = 0;

        for (int i = 0; i < vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getRevisionesPendientes() == 0)
            {
                contadorRevisados++;
                continue;
            }

            System.out.println("[" + (i+1) + "] " + vehiculos.get(i).getPatente() + " - " + vehiculos.get(i).getMarca() + " (Pendientes: " + vehiculos.get(i).getRevisionesPendientes() + ")");
        }

        if (contadorRevisados == vehiculos.size())
        {
            System.out.println("No hay revisiones pendientes.");
            return;
        }

        int numeroVehiculo;

        while (true)
        {
            numeroVehiculo = MisTryCatches.tryCatchIntPositivo("Ingrese número de vehículo: ", mensajeErrorNegativos);

            try 
            {
                if (vehiculos.get(numeroVehiculo-1).getRevisionesPendientes() == 0)
                {
                    System.out.println("Ese vehículo no tiene revisiones pendientes.");
                }
                else
                {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Error. Debe ingresar el número de un vehículo que se mostró anteriormente.");
            }
        }

        Vehiculo vehiculoRevisado = vehiculos.get(numeroVehiculo-1);
        vehiculoRevisado.setRevisionesPendientes(vehiculoRevisado.getRevisionesPendientes() - 1);
        
        System.out.println("Revisión realizada.");

        System.out.println("Vehículo: " + vehiculoRevisado.getPatente() + " - " + vehiculoRevisado.getMarca());
        System.out.println("Costo de la revisión: $" + vehiculoRevisado.calcularCostoRevision());
        System.out.println("Revisiones pendientes: " + vehiculoRevisado.getRevisionesPendientes());
    }

    //
    // 5
    //
    static void resumenDeVehiculos()
    {
        System.out.println("--- RESUMEN DE VEHÍCULOS ---");

        System.out.println("Total de vehículos: " + vehiculos.size());
        System.out.println("Vehículos particulares: " + vehiculosParticulares.size());
        System.out.println("Vehículos de carga: " + vehiculosCargas.size());

        int costoTotal = 0;

        for (Vehiculo v : vehiculos)
        {
            costoTotal += (v.calcularCostoRevision() * v.getRevisionesPendientes());
        }

        System.out.println("Ingresos proyectados: $" + costoTotal);
    }


    static String pedirString(String mensaje)
    {
        while (true)
        {
            System.out.print(mensaje);
            String patente = sc.nextLine();

            return patente;
        }
    }
}
