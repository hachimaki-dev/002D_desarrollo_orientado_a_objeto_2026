
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    el paradigma utilizado es el orientado a objetos de java. el cual se basa en agrupar datos como los atributos, y comportamientos como los metodos, en estructuras llamadas clases, creando instancias u objetos de estas, para interactuar en el programa.
    diferencias con un paradigma funciopnal : 1) estructura y estado. en POO el estado se guarda dentro de los objetos y se modifica mediante sus prpios metodos. en programacion funcional se prefiere funciones puras y datos inmutables, pasando el estado como argumentos sin modificar las variables originales.
    2) tipado y polimorfismo: java es de tipado estatico, requiriendo declarar los tipos de datos en compilacion. utiliza el polimorfismo basado en herencia, por ejemplo llamar calcularCostoRevision() sobre un tipó generico de Vehiculo y que se ejecute la version especifica de la clase hija como con VehiculoCarga y VehiculoParticular.
    */
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir){
            System.out.println("=== TALLER MECANICO");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo por patente");
            System.out.println("4. Realizar revision");
            System.out.println("5. Resumen de vehiculos");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");
            try{
                int opcion = Integer.parseInt(sc.nextLine());
                switch(opcion){
                    case 1: registrarVehiculo();
                    case 2: listarVehiculos();
                    case 3: buscarVehiculo();
                    case 4: realizarRevision();
                    case 5: mostrarResumen();
                    case 6: {
                        salir = true;
                        System.out.println("Programa finalizado.");
                    }
                    default: System.out.println("Debe ingresar un numero entero del 1 al 6.");
                } 
                catch(NumberFormatException e){
                    System.out.println("Ingrese un numero entero");
                }
            }
            sc.close();
    }
        }
        
    private static void registrarVehiculo(){
        System.out.println("Tipo de vehiculo");
            ystem.out.println("- 1. Vehiculo Particular");
            System.out.println("- 2. Vehiculo Carga");
            System.out.println("Seleccione una opcion: ");
            try{
                int tipo = Integer.parseInt(sc.nextLine());
                if(tipo != 1 && tipo != 2){
                    System.out.println("Error: ingrese una opcion valida");
                    return;
                }
                System.out.println("Patente: ");
                String patente = sc.nextLine();
                System.out.println("Marca: ");
                String marca = sc.nextLine();
                System.out.println("Revisiones pendientes: ");
                int revisiones = Integer.parseInt(sc.nextLine());
                if(revisiones < 0){
                    System.out.println("Error: No se pueden tener revisiones negativas");
                    return;
                }
                if(tipo == 1) {
                    System.out.println("Numero de pasajeros: ");
                    int pasajeros = Integer.parseInt(sc.nextLine());
                    if(pasajeros <= 0){
                        System.out.println("Error: El vehiculo no puede tener menos de 1 pasajero");
                        return;
                    }
                    vehiculos.add(new VehiculoParticular(patente, marca, revisiones, pasajeros));
                    System.out.println("[OK] Vehiculo Particular Registrado");
                } else{
                    System.out.println("Peso maximo de carga (Kg): ");
                    int peso = Integer.parseInt(sc.nextLine());
                    if(peso <= 0){
                        System.out.println("Error: El peso maximo no puede ser menor o igual a 0");
                        return;
                    }
                    vehiculos.add(new VehiculoCarga(patente, marca, revisiones, peso));
                    System.out.println("[OK] Vehiculo De Carga Registrado.");
                }
            } catch(NumberFormatException e){
                System.out.println("Error: Ingrese un numero entero.");
            }
        }
    private static void listarVehiculos(){
                
        }

}

