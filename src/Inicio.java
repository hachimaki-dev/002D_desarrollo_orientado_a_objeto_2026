import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        boolean mostrar_menu = true;
        System.out.println("****Inicio de programa****");

        while (mostrar_menu) {
            System.out.println("1. Probando array");
            System.out.println("2. Probando arrayList");
            System.out.println("9. Salir");

            System.out.println("Ingrese una opción");
            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    probandoArray();
                    break;
                case "2":
                    probandoArrayList();
                    break;

                case "9":
                    mostrar_menu = false;
                    break;

                default:
                    break;
            }
        }
    }

    static void probandoArray() {
        System.out.println("/////////ESTUIDANTES///////");

        String[] alumnos = new String[6];
        alumnos[0] = "Fernando Macias";
        alumnos[1] = "Tomás Barria";
        alumnos[2] = "Selena Figueroa";
        alumnos[3] = "Cristian Mancilla";
        alumnos[4] = "Francisco Almonacid";
        alumnos[5] = "Manuel Vivar";

        Integer[] edades = new Integer[6];
        edades[0] = 23;
        edades[1] = 18;
        edades[2] = 20;
        edades[3] = 19;
        edades[4] = 20;
        edades[5] = 20;

        System.out.println("El estudiante " + alumnos[0] + " tiene " + edades[0] + " años.");
        System.out.println("El estudiante " + alumnos[1] + " tiene " + edades[1] + " años.");
        System.out.println("El estudiante " + alumnos[2] + " tiene " + edades[2] + " años.");
        System.out.println("El estudiante " + alumnos[3] + " tiene " + edades[3] + " años.");
        System.out.println("El estudiante " + alumnos[4] + " tiene " + edades[4] + " años.");
        System.out.println("El estudiante " + alumnos[5] + " tiene " + edades[5] + " años.");

        System.out.println("======== CON FOR ========");
        for (int i = 0; i <= edades.length - 1; i++) {
            System.out.println("El estudiante " + alumnos[i] + " tiene " + edades[i] + " años.");
        }

    }

    static void probandoArrayList() {
        System.out.println("**********Probando arraylist*********");
        ArrayList<String> alumnos = new ArrayList<>();
        alumnos.add("Rogelio Huichacura");
        alumnos.add("Zinedine Argel");
        alumnos.add("Martín Cavero");
        alumnos.add("Gabriel Viveros");
        alumnos.add("Andrew Farías");
        alumnos.add("Nicole Aguilar");
        alumnos.add("Daniel Opazo");

        System.out.println(alumnos.get(5));

        alumnos.set(5, "Puly");

        System.out.println(alumnos.get(5));

        alumnos.remove(4);

        System.out.println(alumnos.get(4));

        System.out.println(alumnos.size());

        for (String por_cada_alumno : alumnos) {
            System.out.println(por_cada_alumno);
        }

    }
}
