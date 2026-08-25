import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();

    }

    static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        Character player_character = new Character();

        boolean flag_menu = true;

        System.out.println("****WELCOME TO THE SEVEN KINGDOMS****");

        while (flag_menu) {
            System.out.println("1.- CREATE CHARACTER");
            System.out.println("2.- VISUALIZE CHARACTER");
            System.out.println("3.- EXIT");

            System.out.println("CHOOSE AN OPTION");

            String user_option = scanner.nextLine();

            switch (user_option) {
                case "1":
                    createCharacter(player_character, scanner);
                    break;

                case "2":
                    showCharacter(player_character);

                    break;

                case "3":
                    System.out.println("GRACIAS POR JUGAR, VUELVA PRONTO");
                    flag_menu = false;
                    break;

                default:
                    System.out.println("OPCIÓN INVALIDA");
                    break;
            }
        }
    }

    static void createCharacter(Character player_character, Scanner scanner) {

        Enderman enderman = new Enderman();
        Creeper creeper = new Creeper();
        Zombie zombie = new Zombie();
        Dragon dragon = new Dragon();


        System.out.println("CREATING CHARACTER");
        // NOMBRE DEL PERSONAJE
        System.out.println("INNGRESE UN NOMBRE");

        // player_character.validarNombre("weon");
        player_character.validarNombre(scanner.nextLine());

        // VIDA DEL PERSONAJE
        System.out.println("INNGRESE LOS PUNTOS DE VIDA");
        // Esto es la forma no segura
        // player_character.hit_points = Integer.parseInt(scanner.nextLine());

        // Esto es con encapsulamiento
        player_character.asignarVida(Integer.parseInt(scanner.nextLine()));

        // PUNTOS MAGICO
        System.out.println("INNGRESE EL MANÁ");
        player_character.validarPuntosMagicos(Integer.parseInt(scanner.nextLine()));

        // Asigenemos la edad
        System.out.println("Ingrese la edad:");

        player_character.validarEdad(Integer.parseInt(scanner.nextLine()));
    }

    static void showCharacter(Character player_character) {

        System.out.println("VER PERSONAJE");
        System.out.println("NOMBRE: " + player_character.mostrarNombre());
        System.out.println("HP: " + player_character.mostrarVida());
        System.out.println("MANÁ: " + player_character.mostrarPM());
        System.out.println("AGE: " + player_character.mostrarEdad());
    }

}
