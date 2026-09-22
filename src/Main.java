//¿Que paradigma de programacion se esta usando y sus caracteristicas principales?
//R:
//Al menos 2 DIFERENCIAS CONCRETAS entre POO(Java) y paradigma anterior (Python funcional)
//R:

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean estado= true;
        while (estado) {
            System.out.println("==== TALLER MECANICO ====");
            System.out.println("1) Registrar Vehiculo");
            System.out.println("2) Listar Vehiculos");
            System.out.println("3) Buscar vehiculo por patente");
            System.out.println("4) Realizar revision");
            System.out.println("5) Resumen de vehiculos");
            System.out.println("6) Salir");

            System.out.println("Seleccione una de las opciones:");
            String opcion_usuario = sc.nextLine();
            switch (opcion_usuario) {
                case "1":
                    registrarVehiculo();
                    break;
                case "2":
                    listarVehiculos();
                    break;
                case "3":
                    buscarVehiculoPorPatente();
                    break;
                case "4":
                    realizarRevision();
                    break;
                case "5":
                    resumenDeVehiculos();
                    
                    break;
                case "6":
                    estado=false;
                    break;
            
                default:
                    break;
            }
            
        }
    }

    static void registrarVehiculo(){
        while (true) {
            System.out.println("---Tipo de Vehiculo---");
            System.out.println("1. Particular");
            System.out.println("2. Carga");
            String eleccion =sc.nextLine();
            switch (eleccion) {
                case "1":
                    try {
                        System.out.println("Ingrese el numero de pasajeros del vehiculo: ");
                        int capacidadVehiculo= Integer.parseInt(sc.nextLine());
                        if (capacidadVehiculo>0) {
                            System.out.println("Cantidad de pasajeros a ingresar valida");
                        }else{

                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error, la capacidad del vehiculo ingresada no es valida");
                    }
                    break;
                case "2":
                    try {
                        System.out.println("Ingrese el peso maximo de carga del vehiculo (kg): ");
                        int capacidadVehiculo= Integer.parseInt(sc.nextLine());
                        if (capacidadVehiculo>0) {
                            System.out.println("Cantidad de peso maximo de carga a ingresar valido");
                        }else{
                            System.err.println("Error, la cantidad de peso del vehiculo no es valida");
                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error, la capacidad del vehiculo ingresada no es valida");
                    }
                    
                    break;
            
                default:
                    break;
            }

        }
    }
    static void listarVehiculos(){

    }
    static void buscarVehiculoPorPatente(){

    }
    static void realizarRevision(){

    }
    static void resumenDeVehiculos(){

    }
}
