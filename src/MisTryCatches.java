import java.util.Scanner;

public class MisTryCatches
{
    public static int tryCatchInt(String mensajeInput, String mensajeError)
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
                System.out.println(mensajeError);
            }
        }
    }

    public static int tryCatchIntPositivo(String mensajeInput, String mensajeError)
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
                    System.out.println("Error. Ingrese un valor positivo.");
                    continue;
                }

                return numero;
            }
            catch (NumberFormatException e)
            {
                System.out.println(mensajeError);
            }
        }
    }

    public static int tryCatchIntPositivoMayorQueCero(String mensajeInput, String mensajeError)
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
                    System.out.println("Error. Ingrese un valor mayor a 0.");
                    continue;
                }

                return numero;
            }
            catch (NumberFormatException e)
            {
                System.out.println(mensajeError);
            }
        }
    }
}