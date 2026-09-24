import java.util.ArrayList;
import java.util.Scanner;

public class MisTryCatches
{
   // static String mensajeNegativos = "Error. Ingrese un valor numérico mayor o igual a 0.";
    //static String mensajeNumero = "Error. Debe ingresar un valor numérico.";

    public static int tryCatchInt(String mensajeInput)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            try
            {
                System.out.print(mensajeInput);
                int numero = Integer.parseInt(sc.nextLine());
                
                return numero;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nError. Ingrese un valor numérico.\n");
            }
        }
    }

    public static int tryCatchIntPositivo(String mensajeInput)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            try
            {
                System.out.print(mensajeInput);
                int numero = Integer.parseInt(sc.nextLine());

                if (numero < 0)
                {
                    System.out.println("\nError. Ingrese un número igual o mayor a 0.\n");
                    continue;
                }

                return numero;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nError. Debe ingresar un valor numérico.\n");
            }
        }
    }

    public static int tryCatchIntPositivoMayorQueCero(String mensajeInput)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            try
            {
                System.out.print(mensajeInput);
                int numero = Integer.parseInt(sc.nextLine());

                if (numero < 1)
                {
                    System.out.println("\nError. Ingrese un número mayor a 0.\n");
                    continue;
                }

                return numero;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nError. Debe ingresar un valor numérico.\n");
            }
        }
    }

    public static int tryCatchNumeroVehiculo(String mensajeInput, ArrayList<Vehiculo> vehiculos)
    {
        while (true)
        {
            int numeroVehiculo = MisTryCatches.tryCatchIntPositivo(mensajeInput);

            try 
            {
                if (vehiculos.get(numeroVehiculo-1).getRevisionesPendientes() == 0)
                {
                    System.out.println("\nEse vehículo no tiene revisiones pendientes. Ingrese otro número:\n");
                }
                else
                {
                    return numeroVehiculo;
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("\nError. Debe ingresar el número de un vehículo que se mostró anteriormente.\n");
            }
        }
    }
}