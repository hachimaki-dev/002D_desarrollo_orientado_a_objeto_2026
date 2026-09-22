import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        while (true) 
        { 
            try
            {
                System.out.println("=== TALLER MECANICO ===");
                System.out.println("1. Registrar vehículos");
                System.out.println("2. Listar vehículos");
                System.out.println("3. Buscar vehículo por patente");
                System.out.println("4. Realizar revisión");
                System.out.println("5. Resumen de vehículos");
                System.out.println("6. Salir"); 
                System.out.print("Elige una opción: "); 
                int opcion = Integer.parseInt(scanner.nextLine());
                try
                {
                    if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6)
                    {
                        System.out.println("Opcion invalida, por favor seleccione una opcion del 1 al 6.");
                    } 
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Opcion invalida, por favor seleccione una opcion con numeros enteros.");
                }

                switch (opcion) 
                {
                    case 1:
                    try
                    {
                        System.out.println("¿Que tipo de vhículo vas a registrar?");
                        System.out.println("1. Vehículo Particular.");
                        System.out.println("2. Vehículo de carga.");
                        System.out.print("Elige tu opción: ");
                        int tipoVehículo = Integer.parseInt(scanner.nextLine());
                        
                        
                            if (tipoVehículo != 1 && tipoVehículo != 2)
                            {
                                System.out.println("Opcion invalida, ingresa un tipo de vehículo valido.");
                            }

                        if (tipoVehículo == 1)
                        {
                            ArrayList<String>particular = new ArrayList<>();
                            try
                            {
                            System.out.print("Ingrese la capacidad de pasajeros del vehículo:");
                            int capacidad = Integer.parseInt(scanner.nextLine());
                            System.out.print("Ingrese la cantidad de revisiones pendientes:");
                            int revisiones = Integer.parseInt(scanner.nextLine());
                            if (capacidad <= 0)
                            {
                                System.out.println("La capacidad del vehículo debe ser mayor a 0.");
                            }
                            if (revisiones < 0)
                            {
                                System.out.println("No puedes tener revisiones negativas.");
                            }
                            else
                            {
                                particular.add("Capacidad:"+capacidad);
                                particular.add("Revisiones pendientes"+revisiones);
                            }
                            }
                            catch (IllegalArgumentException e)
                            {
                                System.out.println("Error, capacidad no valida, ingrese una capacidad a través de numeros enteros.");
                            }
                        }
                        else if (tipoVehículo == 2)
                        {
                            try
                            {
                            System.out.print("Ingrese la capacidad de peso del vehículo:");
                            int peso = Integer.parseInt(scanner.nextLine());
                            System.out.print("Ingrese la cantidad de revisiones pendientes:");
                            int revisiones = Integer.parseInt(scanner.nextLine());
                            if (peso <= 0)
                            {
                                System.out.println("La capacidad del vehículo debe ser mayor a 0.");
                            }
                            if (revisiones < 0)
                            {
                                System.out.println("No puedes tener revisiones negativas.");
                            }
                            else
                            {
                                ArrayList<String>carga = new ArrayList<>();
                                carga.add("Capacidad de peso:"+peso);
                                carga.add("Revisiones pendientes:"+ revisiones);
                            }
                            }
                            catch (IllegalArgumentException e)
                            {
                                System.out.println("Error, capacidad no valida, ingrese una capacidad a través de numeros enteros.");
                            }
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Opcion invalida, utilice numeros enteros para identificar el tipo de vehículo.");
                    }


                        break;
                    default:
                        throw new AssertionError();
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Error, ingrese una opcion valida. Del 1 al 6 en numeros enteros.");
            }
        }
    }
}
