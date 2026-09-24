//1. El paradigma que se esta usando en este ejercicio es POO(Programacion orientada a objetos) la cual usa elementos de la vida real y llevar a estas mismas a programacion:
//la caracteristicas que se usan son: Herencia,polimorfismo,abstraccion,encapsulamiento

//2. a.la diferencia que hay entre python y java es que python puede compilar incluso si hay errores mientras que en java no puede compilar si hay almenos un error
//b. en java para crear una variable tienes que decir que tipo de dato es esa variable(int,String,boolean,float,double) y en python se puede crear solo poniendo el tipo de dato y se asigna automaticamente ese dato
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
   static ArrayList<Vehiculo> coleccion_de_vehiculos = new ArrayList<>();
    public static void main(String[] args) {

        mostrarMenu();
        
    }
    static void mostrarMenu(){
        boolean mostrarmenu = true;
        System.out.println("==== TALLER MECANICO ====");
        while (mostrarmenu) {

            System.out.println("1.Registrar vehiculo");
            System.out.println("2.Listar inventario");
            System.out.println("3.Buscar vehiculo por patente");
            System.out.println("4.Realizar revision");
            System.out.println("5.Resumen de vehiculos");
            System.out.println("6.Salir");

            System.out.println("Ingrese una opcion");

            String opcionusuario = sc.nextLine();

            switch (opcionusuario) {
                case "1":
                    RegistrarVehiculo();
                    break;
                case "2":
                    ListarInventario();
                    break;
                case "3":
                    BuscarVehiculoPorPatente();
                    break;
                case "4":
                    RealizarRevision();
                    break;
                case "5":
                    ResumenVehiculos();
                    break;
                case "6":
                    mostrarmenu = false;
                default:
                    break;
            }
            
        }
        
        
    }
    static void RegistrarVehiculo(){
            boolean mostramenu2 = true;
            System.out.println("****REGISTRAR VEHICULO*****");
            while (mostramenu2){

                System.out.println("1. Vehiculo Particular");
                System.out.println("2. Vehiculo Carga");
                System.out.println("3. Salir");

                System.out.println("Ingrese una opcion: ");

                String opcionusuario2 = sc.nextLine();

                switch (opcionusuario2) {
                    case "1":
                        RegistrarVehiculoParticular();
                        break;
                    case "2":
                        RegistrarVehiculoCarga();
                        break;
                    case "3":
                        mostramenu2 = false;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }

                
                
               


            }
            
        }
        static void RegistrarVehiculoParticular(){
            boolean menuflag = true;
            
            while (menuflag) {
                System.out.println("****OPCION 1: PARTICULAR");

            System.out.println("Ingrese la patente del vehiculo:");

            String patente = sc.nextLine();

            System.out.println("Ingrese la marca del vehiculo:");

            String marca = sc.nextLine();

            System.out.println("Ingrese las revisiones del vehiculo del vehiculo:");
            
               try {
                int revisionpendiente = Integer.parseInt(sc.nextLine()); 

                System.out.println("Ingrese el numero de pasajeros en el vehiculo:");

                int numpasajeros = Integer.parseInt(sc.nextLine());

                
                
                if(revisionpendiente < 0 ){

                    System.out.println("Ingrese un numero entero positivo");

                    continue;

                    
                

                }
                if(numpasajeros < 0 ){

                    System.out.println("Ingrese un numero entero positivo");

                    continue;
                }
                coleccion_de_vehiculos.add(new VehiculoParticular(patente, marca, revisionpendiente, numpasajeros));
                System.out.println("vehiculo registrado exitosamente");
                menuflag = false;


               } catch (NumberFormatException e) {
                 System.out.println("Ingrese un numero entero positivo");

                 continue;
               }
                   
            
            }
            

                    
                    

                
               }
               
               
                
                

                        


                    

               
               

            
                
            
            
            
             

             




                
            


        
        static void RegistrarVehiculoCarga(){

            System.out.println("****OPCION ACEPTADA: CARGA");

            System.out.println("Ingrese la patente del vehiculo:");

            String patente = sc.nextLine();

            System.out.println("Ingrese la marca del vehiculo:");

            String marca = sc.nextLine();

            System.out.println("Ingrese las revisiones del vehiculo :");

            
             int revisionpendiente = Integer.parseInt(sc.nextLine()); 

             System.out.println("Ingrese el peso maximo del vehiculo(kilogramos):");

             int cargamaxima = Integer.parseInt(sc.nextLine());

             coleccion_de_vehiculos.add(new VehiculoCarga(patente, marca, revisionpendiente, cargamaxima));

             System.out.println("Vehiculo registrado exitosamente");

             
             
             





            
                

                
            


        }
        static void ListarInventario(){
             
              if (coleccion_de_vehiculos.isEmpty()){

                System.out.println("No hay vehiculos en el inventario");
              }else{
                System.out.println("*****INVENTARIO VEHICULOS******");

                for (Vehiculo vehiculo : coleccion_de_vehiculos) {

                System.out.println(vehiculo.mostrarInfo());
                
              } 

              }
              


        }
        static void BuscarVehiculoPorPatente(){

            System.out.println("Ingrese la patente del vehiculo a buscar: ");

            String patentevehiculo = sc.nextLine().toLowerCase();

            for (Vehiculo vehiculo : coleccion_de_vehiculos) {

                if(vehiculo.getPatente().toLowerCase().contains(patentevehiculo)){

                    System.out.println(vehiculo.mostrarInfo());


                }
                
            }
        }
        static void RealizarRevision(){

            System.out.println("****REALIZAR REVISION****");
            System.out.println("Ingrese la patente del vehiculo a revisar");
            String patenterevision = sc.nextLine().toUpperCase();

            for (Vehiculo vehiculo : coleccion_de_vehiculos) {

                if(vehiculo.getPatente().toUpperCase().contains(patenterevision)){
                     System.out.println("****REALIZANDO REVISION");
                    
                    if (vehiculo.getRevisionPendiente() > 0 ){

                        vehiculo.setRevisionesPendientes(vehiculo.getRevisionPendiente() - 1);

                        System.out.println(vehiculo.mostrarInfo()+ "Costo final:"+ vehiculo.CalcularCostoRevision()) ;





                    }
                }
                
            }
        }
        static void ResumenVehiculos(){

            System.out.println("====RESUMEN DE VEHICULOS===");

            int total_vehiculos = coleccion_de_vehiculos.size();

            int vehiculoparticular = 0;

            int vehiculocarga = 0;
            int ingresos_proyectados = 0;
            
            for (Vehiculo vehiculo : coleccion_de_vehiculos) {

                if(vehiculo instanceof VehiculoParticular){

                    vehiculoparticular++;


                }else if(vehiculo instanceof VehiculoCarga){

                    vehiculocarga++;

                }
                ingresos_proyectados += (long) vehiculo.CalcularCostoRevision()* vehiculo.getRevisionPendiente();
            }
             
            System.out.println("Total de vehiculos: "+ total_vehiculos);
            System.out.println("Vehiculos particulares: "+ vehiculoparticular);
            System.out.println("Vehiculo Carga: "+ vehiculocarga);
            System.out.println("Ingresos proyectados: "+ ingresos_proyectados);

        
            

        }
        

}
