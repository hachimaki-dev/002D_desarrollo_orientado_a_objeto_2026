//¿Que paradigma de programacion se esta usando y sus caracteristicas principales?
//R: El paradigma es programacion orientada a objetos y su principal funcion es que puedes ordenar todo en distintos lados y de distintas maneras como con polimorfismo, abstraccion, herencia y encapsulamiento.
//Al menos 2 DIFERENCIAS CONCRETAS entre POO(Java) y paradigma anterior (Python funcional)
//R: Que java no compila con errores, al contrario de python que compila linea por linea sin importar mucho (algunas veces) si hay un error o no, y la otra diferencia es que en java se debe estipular que tipo de dato es cada uno y a diferencia de python que puedes dejar un dato vacio y asignarle un valor cualquiera en otro momento.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
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
                    System.err.println("Ingrese una de las 6 opciones!");
                    break;
            }
            
        }
    }

    static void registrarVehiculo(){
        boolean mostrar_menu=true;
        while (mostrar_menu) {
            System.out.println("---Tipo de Vehiculo---");
            System.out.println("1. Particular");
            System.out.println("2. Carga");
            System.out.println("3. Volver al menú");
            String eleccion =sc.nextLine();
            switch (eleccion) {
                case "1":
                    registrarVehiculoParticular();
                    break;
                case "2":
                    registrarVehiculoCarga();
                    break;
                case "3":
                    mostrar_menu=false;
                default:
                    break;
            }

        }
    }

    static void registrarVehiculoParticular(){
        System.out.println("Ingrese la patente del vehiculo:");
        String patente = sc.nextLine();
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.nextLine();
        int revisionesPendientes=0;
        int numPasajeros=0;
        boolean validacion= true;
        while (validacion) {
            try {
                        System.out.println("Ingrese el numero de revisiones pendientes del vehiculo: ");
                        revisionesPendientes= Integer.parseInt(sc.nextLine());
                        if (revisionesPendientes>=0) {
                            System.out.println("Cantidad de revisiones pendientes a ingresar valida");
                            validacion=false;
                        }else{
                            System.out.println("Ingrese un numero valido!");
                            continue;
                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error, el numero de revisiones pendientes ingresada no es valida");
                        continue;
                    }
        }
        while (validacion==false) {
            try {
                        System.out.println("Ingrese el numero de pasajeros del vehiculo: ");
                        numPasajeros= Integer.parseInt(sc.nextLine());
                        if (numPasajeros>0) {
                            System.out.println("Cantidad de pasajeros a ingresar valida");
                            validacion=true;
                        }else{
                            System.out.println("Ingrese un numero valido!");
                            continue;
                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error, la capacidad del vehiculo ingresada no es valida");
                        continue;
                    }
        }
        Vehiculo vehiculo = new VehiculoParticular(patente, marca, revisionesPendientes,numPasajeros);
        if (vehiculos.add(vehiculo)) {
            System.out.println("Vehiculo Particular ingresado exitosamente.");
        }else{
            System.err.println("No se pudo ingresar el vehiculo.");
        }
    }

    static void registrarVehiculoCarga(){
        System.out.println("Ingrese la patente del vehiculo:");
        String patente = sc.nextLine();
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.nextLine();
        int revisionesPendientes=0;
        int pesoMaxCarga=0;
        boolean validacion= true;
        while (validacion) {
            try {
                        System.out.println("Ingrese el numero de revisiones pendientes del vehiculo: ");
                        revisionesPendientes= Integer.parseInt(sc.nextLine());
                        if (revisionesPendientes>=0) {
                            System.out.println("Cantidad de revisiones pendientes a ingresar valida");
                            validacion=false;
                        }else{
                            System.out.println("Ingrese un numero valido!");
                            continue;
                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error, el numero de revisiones pendientes ingresada no es valida");
                        continue;
                    }
        }
        while (validacion==false) {
            try {
                        System.out.println("Ingrese peso maximo de carga del vehiculo: ");
                        pesoMaxCarga= Integer.parseInt(sc.nextLine());
                        if (pesoMaxCarga>0) {
                            System.out.println("Cantidad de peso maximo de carga a ingresar valida");
                            validacion=true;
                        }else{
                            System.out.println("Ingrese un numero valido!");
                            continue;
                        }
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error, la capacidad del vehiculo ingresada no es valida");
                        continue;
                    }
        }
        Vehiculo vehiculo = new VehiculoCarga(patente, marca, revisionesPendientes, pesoMaxCarga);
        
        if (vehiculos.add(vehiculo)) {
            System.out.println("Vehiculo Particular ingresado exitosamente.");
        }else{
            System.err.println("No se pudo ingresar el vehiculo.");
        }

    }
    static void listarVehiculos(){
        System.out.println("---VEHICULOS REGISTRADOS---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.mostrarInfo());
        }
    }
    static void buscarVehiculoPorPatente(){
        System.out.println("---BUSCAR VEHICULOS---");
        System.out.println("Ingrese la patente del vehiculo que desea buscar:");
        String vehiculo_a_buscar= sc.nextLine().toUpperCase();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().toUpperCase().contains(vehiculo_a_buscar)) {
                System.out.println("Vehiculo Encontrado!");
                System.out.println(vehiculo.mostrarInfo());
            }else{
                System.err.println("Vehiculo no encontrado!");
            }
        }
    }
    static void realizarRevision(){
        if (vehiculos.isEmpty()) {
            System.err.println("No hay vehiculos registrados!");
            return;
        }
        System.out.println("---ESTAMOS REALIZANDO REVISION---");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo revision_vehiculo = vehiculos.get(i);
            System.out.println((i+1) + " La patente del vehiculo es: " + revision_vehiculo.getPatente() + ", la marca es: " + revision_vehiculo.getMarca() + ", el costo de revision es: " + revision_vehiculo.calcularCostoRevision());
            try {
                System.out.println("Ingrese el indice del vehiculo:");
                int indice_ingresado= Integer.parseInt(sc.nextLine());
                indice_ingresado-=1;
                if (indice_ingresado<0 || indice_ingresado>=vehiculos.size()) {
                    System.err.println("El indice ingresado está fuera del rango!");
                    return;
                }
                Vehiculo seleccionado = vehiculos.get(indice_ingresado);
                if (seleccionado.getRevisionesPendientes()<=0) {
                    System.out.println("No tienes revisiones pendientes!");
                    return;
                }
                seleccionado.setRevisionesPendientes(seleccionado.getRevisionesPendientes()-1);
                System.out.println("Revision realizada con exito");
                System.out.println("Las revisiones pendientes son: " + seleccionado.getRevisionesPendientes());
                
            } catch (IllegalArgumentException e) {
                System.err.println("Ingrese un numero entero!");
            }
        }
    }
    static void resumenDeVehiculos(){
        System.out.println("---RESUMEN DE LOS VEHICULOS---");
        int totalDeVehiculos= vehiculos.size();
        int vehiculosParticulares=0;
        int vehiculosDeCarga=0;
        long ingresosProyectados=0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof VehiculoParticular) {
                vehiculosParticulares++;
            }else if (vehiculo instanceof VehiculoCarga) {
                vehiculosDeCarga++;
            }
            ingresosProyectados+= (long) vehiculo.calcularCostoRevision()*vehiculo.getRevisionesPendientes();
        }
        System.out.println("La cantidad total de vehiculos son de: " + totalDeVehiculos);
        System.out.println("La cantidad de vehiculos particulares son de: " + vehiculosParticulares);
        System.out.println("La cantidad de vehiculos de carga es de: " + vehiculosDeCarga);
        System.out.println("Los ingresos estimados totales son de: " + ingresosProyectados);
    }
}
