import java.util.ArrayList;
import java.util.Scanner;

/* diferencia python y java es que en java todo debe estar dentro de clases mientras que en python
el codigo puede funcionar asi todo suelto, ademas java posee un tipado mas estricto q python  */

public class main {

      public static void public(String[] args) {
        ArrayList<vehiculo> listaVehiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (salir)
            System.out.println("----- TALLER MECANICO -----");
            System.out.println("1. registro de vehiculos");
            System.out.println("2. listar vehiculos");
            System.out.println("3. buscar vehiculos por patente");
            System.out.println("4. realizar revision");
            System.out.println("5. resumen de vehiculos");
            System.out.println("6. salir");
            System.out.print("Seleccione una opcion: ");

            String inputopcion = scanner.nextLine();
            int opcion;

            try {
                opcion = Integer.parseInt(inputopcion);
            } catch (NumberFormatException e) {
                System.out.println("Error; ");
                continue;
            }

            switch (opcion) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }

       
}

/* falto tiempo :(  */