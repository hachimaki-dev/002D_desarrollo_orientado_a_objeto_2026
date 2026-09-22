/* El paradigma que se esta usando es la de orienta a objetos y una mezcla entre la funcional , su caracteristica principal es que con este metodo se puede ordenar el codigo y hacerlo mas legible para el resto de programadores , una de las diferencias es que este lenguaje es compilado , quiere decir este se comunica directamente con la CPU sin pasar por un intermediario como Python , la otra diferencia es que el tipado del codigo es fuerte , que quiere decir que el lenguaje necesita que le digas que tipo de dato es , que metodo estas usando y que clase estas usando para seguir  */

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            mostrarMenu();
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    registrarVehiculo();
                    break;
                case "2":
                    listarVehiculo();
                    break;
                case "3":
                    buscarPatente();
                    break;
                case "4":
                    realizarRevision();
                    break;
                case "5":
                    resumenVehiculo();
                    break;
                case "6":
                    System.out.println("Hasta luego");
                    break;
                default:
                    break;
            }
        }
    }
    public static void mostrarMenu(){
        System.out.println("-- Taller mecanico -- ");
        System.out.println("1 . Registrar vehiculo");
        System.out.println("2 . Listar vehiculos ");
        System.out.println("3 . Buscar vehiculo por patente");
        System.out.println("4 . Realizar revision");
        System.out.println("5 .Resumen de vehiculos");
        System.out.println("6 . Salir");
    }
    public static void registrarVehiculo(){
        System.out.println("Registrando vehiculo");
        System.out.println("Escoja una opcion :");
        System.out.println("1 . Particular");
        System.out.println("2 . Carga");
        String opciontipoVehiculo = sc.nextLine();
        if (opciontipoVehiculo.equals("2")) {
            String patente = sc.nextLine();
            
        }else if (opciontipoVehiculo.equals("2")) {
            
        }
        
    }
    public static void listarVehiculo(){
        System.out.println("hola 2");
    }
    public static void buscarPatente(){
        System.out.println("hola 3");
    }
    public static void realizarRevision(){
        System.out.println("hola 4");
    }
    public static void resumenVehiculo(){
        System.out.println("hola 5");
    }
}
