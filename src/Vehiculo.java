
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Vehiculo {
   private String patente;
   private String marca;
   private int revision_pendiente;

   // #1:Usan diferente tipo de tipado java ocupa tipado estatico y pyton ocupa
   // tipado dinamico
   // #2:La forma en la que interpretan el codigo java es mas hibrido mientras que
   // pyton es mas interpretativo
   Vehiculo(String patente, String marca, int revision_pendiente) {
      this.patente = patente;
      this.marca = marca;
      this.revision_pendiente = revision_pendiente;

   }

   public String getpatente() {
      return this.patente;
   }

   public String getmarca() {
      return this.marca;
   }

   public int getrevisionP() {
      return this.revision_pendiente;
   }

   public void setRevisionP(int revision_pendiente) {
      this.revision_pendiente = revision_pendiente;
   }

   public abstract int calcular_costo_de_revision();

   public String mostrarInfo() {
      return "Patente: " + this.patente + "Marca: " + this.marca + "Revisiones pendientes: " + this.revision_pendiente
            + "Costo de revisiones: " + calcular_costo_de_revision();
   }

   public static class vehiculo {
      private static ArrayList<Vehiculo> lista = new ArrayList<>();
      private static Scanner scanner = new Scanner(System.in);

      public static void main(String[] args) {

         boolean ejecutando = true;
         while (ejecutando) {
            menu();
            System.out.println("selecciona una opcion: ");
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
               case "1":
                  registrar_vehiculo();
                  break;
               case "2":
                  Listar_vehiculos();
                  break;
               case "3":
                  Buscar_vehiculo_por_patente();
                  break;
               case "4":
                  Realizar_revision();
                  break;
               case "5":
                  Resumen_de_vehiculos();
                  break;
               case "6":
                  System.out.println("vuelva pronto");
                  ejecutando = false;
                  break;
            }
            System.out.println();
         }
      }

      private static void menu() {
         System.out.println("= TALLER MECANICO =");
         System.out.println("1. Registrar vehiculo");
         System.out.println("2. Listar vehiculos");
         System.out.println("3. Buscar vehiculo por patente");
         System.out.println("4. Realizar revision");
         System.out.println("5. Resumen de vehiculos");
         System.out.println("6. Salir");
      }

      private static void registrar_vehiculo() {
         System.out.println("---- Registrar Vehiculo ----");
         System.out.println("1.Vehiculo particular");
         System.out.println("2.Vehiculo de carga");
         System.out.print("Seleccione el tipo de vehiculo: ");
         String opcion2 = scanner.nextLine().trim();
         if (!opcion2.equals("1") && !opcion2.equals("2")) {
            System.out.print("ERROR");
            return;
         }
         try {
            System.out.print("Patente: ");
            String patente = scanner.nextLine().trim();
            if (patente.isEmpty()) {
               System.out.println("ERROR");
               return;
            }
            System.out.print("Marca: ");
            String marca = scanner.nextLine().trim();
            if (marca.isEmpty()) {
               System.out.print("ERROR");
               return;
            }
            System.out.print("Revisiones pendientes: ");
            int revisiones = Integer.parseInt(scanner.nextLine().trim());
            if (revisiones < 0) {
               System.out.print("ERROR");
               return;
            }
            if (opcion2.equals("1")) {
               System.out.print("numero de pasajeros: ");
               int NumeroP = Integer.parseInt(scanner.nextLine().trim());
               if (NumeroP < 0) {
                  System.out.print("ERROR");
                  return;
               }
               V_particular newParticular = new V_particular(patente, marca, revisiones, NumeroP);
               lista.add(newParticular);
            }
            if (opcion2.equals("2")) {
               System.out.print("tamaño de carga: ");
               int PesoMax = Integer.parseInt(scanner.nextLine().trim());
               if (PesoMax < 0) {
                  System.out.print("ERROR");
                  return;
               }
               V_Carga newCarga = new V_Carga(patente, marca, revisiones, PesoMax);
               lista.add(newCarga);
            }
         } catch (NumberFormatException e) {
            System.out.print("ERROR: ");
         }
      }

      private static void Listar_vehiculos() {
         System.out.println("--- Vehiculos registrados ---");
         if (lista.isEmpty()) {
            System.out.print("NO hay ningun vehiculo en la lista");
            return;
         }
         for (int i = 0; i < lista.size(); i++) {
            Vehiculo a = lista.get(i);
            System.out.println("//" + (i + 1) + "// " + a.mostrarInfo());
         }
         System.out.println("Total de vehiculos registrados: " + lista.size());
      }

      private static void Buscar_vehiculo_por_patente() {
         System.out.print("--lista de patentes--");
         if (lista.isEmpty()) {
            System.out.print("NO hay ningun vehiculo en la lista");
            return;
         }

         System.out.print("Ingrese la patente que busca: ");
         String buscar = scanner.nextLine().trim().toUpperCase();
         if (buscar.isEmpty()) {
            System.out.print("ERROR: No puede estar vacio");
            return;
         }
         int coincidencias = 0;
         System.out.println("Patente encontradas:");
         for (Vehiculo a : lista) {
            if (a.getpatente().toUpperCase().contains(buscar)) {
               System.out.println(" --" + a.mostrarInfo());
               coincidencias++;
            }
         }
         if (coincidencias == 0) {
            System.out.println("Patente NO encontradas:");
         } else {
            System.out.println("Se Econtraron:" + coincidencias + " coincidencias");
         }
      }

      private static void Realizar_revision() {
         System.out.println("--- Realizar revision ---");
         if (lista.isEmpty()) {
            System.out.print("ERROR: NO hay ningun vehiculos en la lista");
            return;
         }
         for (int i = 0; i < lista.size(); i++) {
            Vehiculo a = lista.get(i);
            System.out.println("patente: " + a.getpatente() +
                  "marca: " + a.getmarca() +
                  "Precio:  " + a.calcular_costo_de_revision());
         }
      }

      private static void Resumen_de_vehiculos() {
         System.out.print("--Resumen de vehiculos--");
         if (lista.isEmpty()) {
            System.out.print("NO hay ningun vehiculo en la lista");
            return;
         }
         int total_V_particular = 0;
         int total_V_carga = 0;
         long ingresos = 0;
         for (Vehiculo a : lista) {
            if (a instanceof V_particular) {
               total_V_particular++;
            } else if (a instanceof V_Carga) {
               total_V_carga++;
            }
            ingresos += (long) a.calcular_costo_de_revision() * lista.size();
         }

         System.out.println("Total de Vehiculos: " + lista.size());
         System.out.println("Total de vehiculos de carga: " + total_V_carga);
         System.out.println("Total de vehiculos particular: " + total_V_particular);
         System.out.println("ingresos proyectados:" + ingresos);

      }
   }
}
