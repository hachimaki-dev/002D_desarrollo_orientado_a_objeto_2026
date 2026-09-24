import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
        El paradigma de programación que se está usando es Programación Orientada a Objetos (POO).
        La programación orientada a objetos destaca en poder tratar e interpretar las clases o scripts como objetos de la vida real con sus propios datos y funciones.
    */

    /*
        --- Diferencias de tipado y declaración de variables ---

        JAVA:
        Es de tipado estático, es decir, se debe especificar el tipo de dato de cada variable antes de usarla, y una vez declarado el tipo ya no se puede cambiar.

        PYTHON:
        Es de tipado dinámico, es decir, no se necesita especificar el tipo de dato de las variables. Al momento de crear una variable y darle valor, Python detecta
        automáticamente el tipo de dato en tiempo de ejecución.

        --- Diferencias de ciclo de ejecución ---

        JAVA:
        Es un lenguaje compilado. Antes de ejecutar un script, el código debe pasar por un proceso de compilación, esto también ayuda a verificar que no hayan errores
        antes de ejecutar el programa.

        PYTHON:
        Es un lenguaje interpretado. El código se lee y ejecuta línea por línea, por lo que es menos seguro, ya que no podrá avisar de errores que puedan ocurrir
        a nivel de ejecución, a diferencia de Java.
    */

    static Scanner sc = new Scanner(System.in);

    static ArrayList<VehiculoParticular> vehiculosParticulares = new ArrayList<>();
    static ArrayList<VehiculoCarga> vehiculosCargas = new ArrayList<>();
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();


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
            System.out.println("3. Buscar vehículo por patente.");
            System.out.println("4. Realizar revisión.");
            System.out.println("5. Resumen de vehículos.");
            System.out.println("6. Salir.");

            int opcion = MisTryCatches.tryCatchInt("Seleccione una opción: ");

            switch (opcion)
            {
                case 1 :
                    System.out.println("");
                    registrarVehiculo();
                    System.out.println("");
                    break;
                case 2 :
                    System.out.println("");
                    listarVehiculos();
                    System.out.println("");
                    break;
                case 3 :
                    System.out.println("");
                    buscarVehiculoPorPatente();
                    System.out.println("");
                    break;
                case 4 :
                    System.out.println("");
                    realizarRevision();
                    System.out.println("");
                    break;
                case 5 :
                    System.out.println("");
                    resumenDeVehiculos();
                    System.out.println("");
                    break;
                case 6 :
                    System.out.println("\nPrograma finalizado.");
                    ejecutarPrograma = false;
                    break;
                /*case 7 :
                    System.out.println("");
                    agregarVehiculos();
                    System.out.println("");
                    break;*/
                default :
                    System.out.println("\nIngrese un número válido (entre 1 y 6).\n");
                    break;
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
            opcion = MisTryCatches.tryCatchInt("Seleccione: ");

            if (opcion >= 1 && opcion <= 2)
            {
                break;
            }
            else 
            {
                System.out.println("\nError. Ingrese un número válido (entre 1 y 2)\n");
            }
        }

        String patente = pedirString("\nPatente: ");
        String marca = pedirString("Marca: ");
        int revisionesPendientes = MisTryCatches.tryCatchIntPositivo("Revisiones pendientes: ");

        switch (opcion)
        {
            case 1 :
                int numeroDePasajeros = MisTryCatches.tryCatchIntPositivoMayorQueCero("Número de pasajeros: ");

                VehiculoParticular vParticular = new VehiculoParticular(patente, marca, revisionesPendientes, numeroDePasajeros);
                vehiculosParticulares.add(vParticular);
                vehiculos.add(vParticular);

                System.out.println("[OK] Vehículo particular registrado.");
                break;
            case 2 :
                int pesoMaxCarga = MisTryCatches.tryCatchIntPositivoMayorQueCero("Peso máximo de carga (kg): ");

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
            return;
        }

        for (int i = 0; i < vehiculos.size(); i++)
        {
            System.out.println("[" + (i+1) + "] " + vehiculos.get(i).mostrarInfo());
        }
    }

    //
    // 3
    //
    static void buscarVehiculoPorPatente()
    {
        System.out.println("--- BUSCAR VEHÍCULO ---");

        if (vehiculos.size() == 0)
        {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        String patenteBuscada;

        while (true)
        {
            System.out.print("Ingrese la patente del vehículo que quiere buscar: ");
            patenteBuscada = sc.nextLine();

            if (patenteBuscada.isBlank())
            {
                System.out.println("\nDebe ingresar un texto que no esté vacío.\n");
            }
            else
            {
                break;
            }
        }
        
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

        if (vehiculos.size() == 0)
        {
            System.out.println("No hay vehículos registrados.");
            return;
        }

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

        int numeroVehiculo = MisTryCatches.tryCatchNumeroVehiculo("Ingrese número de vehículo: ", vehiculos);

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
            String stringDevuelto = sc.nextLine();

            return stringDevuelto;
        }
    }

   /*  static void agregarVehiculos()
    {
        VehiculoParticular vp1 = new VehiculoParticular("25YSJO", "Motorola", 5, 4);
        VehiculoParticular vp2 = new VehiculoParticular("09JGQT", "Yaris", 0, 1);

        VehiculoCarga vc1 = new VehiculoCarga("YTOP10", "Yaris", 2, 50);
        VehiculoCarga vc2 = new VehiculoCarga("10TOPY", "Mitsubishi", 0, 10);

        vehiculosParticulares.add(vp1);
        vehiculosParticulares.add(vp2);

        vehiculosCargas.add(vc1);
        vehiculosCargas.add(vc2);



        vehiculos.add(vp1);
        vehiculos.add(vp2);

        vehiculos.add(vc1);
        vehiculos.add(vc2);
    }*/
}
