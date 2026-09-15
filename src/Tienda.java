import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    static ArrayList<ProductoFisico> coleccion_juegos_fisicos = new ArrayList<>();

    static ArrayList<ProductoDigital> coleccion_juegos_digitales = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar inventario");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Vender producto");
            System.out.println("5. Resumen del inventario");
            System.out.println("6. Salir");
            System.out.println("7. Agregar datos de prueba");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    registrarProducto();
                    break;

                case "2":
                    listarInventario();
                    break;

                case "3":
                    buscarProductoPorNombre();
                    break;

                case "4":

                    break;

                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    agregarDatosDePrueba();

                default:
                    break;
            }

        }
    }

    static public void registrarProducto() {
        System.out.println("******INGRESO DE JUEGOS A LA PLATAFORMA*****");
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Producto físico");
            System.out.println("2. Producto digital");
            System.out.println("3. Volver al menú");

            System.out.println("Escoja una opción");

            String opcion_registrar_juego = sc.nextLine();

            switch (opcion_registrar_juego) {
                case "1":
                    registrarProductoFisico();
                    break;
                case "2":
                    registrarProductoDigital();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;

                default:
                    break;
            }
        }
    }

    static public void registrarProductoFisico() {
        System.out.println("Ingrese el nombre del juego");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el precio base del juego");
        int precioBase = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el stock del juego");
        int stock = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese costo de envio del juego");
        int costoEnvio = Integer.parseInt(sc.nextLine());

        ProductoFisico juego = new ProductoFisico(nombre, precioBase, stock, costoEnvio);

        if (coleccion_juegos_fisicos.add(juego)) {
            System.out.println("Juego agregado");
        } else {
            System.err.println("No se pudo agregar :C");
        }
    }

    static public void registrarProductoDigital() {
        System.out.println("Ingrese el nombre del juego");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el precio base del juego");
        int precioBase = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el stock del juego");
        int stock = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese descueto del juego");
        int descuento = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la plataforma del juego");
        String plataforma = sc.nextLine();

        ProductoDigital juego = new ProductoDigital(nombre, precioBase, stock, descuento, plataforma);

        if (coleccion_juegos_digitales.add(juego)) {
            System.out.println("Juego agregado");
        } else {
            System.err.println("No se pudo agregar :C");
        }
    }

    static public void listarInventario() {
        System.out.println("****INVENTARIO DE JUEGOS******");

        System.out.println("****INVENTARIO DE JUEGOS Físicos******");

        for (ProductoFisico juego_fisico : coleccion_juegos_fisicos) {
            System.out.println(juego_fisico.mostrarInfo());
            ;
        }

        System.out.println("****INVENTARIO DE JUEGOS DIGITAL******");
        for (ProductoDigital juego_digital : coleccion_juegos_digitales) {
            System.out.println(juego_digital.mostrarInfo());
        }

    }

    static void agregarDatosDePrueba() {
        System.out.println("Agregando juegos fisicos");

        coleccion_juegos_fisicos.add(new ProductoFisico("Pokémon Perla", 27000, 20, 3000));

        coleccion_juegos_fisicos.add(new ProductoFisico("Pokémon Diamante", 27000, 14, 3000));

        coleccion_juegos_fisicos.add(new ProductoFisico("GTA V", 32000, 26, 3000));

        coleccion_juegos_fisicos.add(new ProductoFisico("Majoras Mask", 150000, 2, 3000));

        coleccion_juegos_fisicos.add(new ProductoFisico("PayDay2", 6000, 6, 3000));

        coleccion_juegos_digitales.add(new ProductoDigital("Halo", 9000, 20, 45, "PC"));

        coleccion_juegos_digitales.add(new ProductoDigital("Balatro", 12000, 46, 5, "PC"));

        System.out.println("********DATOS DE PRUEBA CARGADOS******");

    }


    static void buscarProductoPorNombre(){
        System.out.println("Ingrese nombre del juego: ");
        String nombre_juego =  sc.nextLine();

        for(ProductoFisico juego_fisico : coleccion_juegos_fisicos){
            if (juego_fisico.getNombre().contains(nombre_juego)) {
                System.out.println(juego_fisico.mostrarInfo());
            }
        }

        for(ProductoDigital juego_digital : coleccion_juegos_digitales){
            if (juego_digital.getNombre().contains(nombre_juego)) {
                System.out.println(juego_digital.mostrarInfo());
            }
        }
    }
}
