import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();

    }

    static void showMenu(){
        Scanner scanner = new Scanner(System.in);
        Character player_character = new Character();

        boolean flag_menu = true;

        System.out.println("****WELCOME TO THE SEVEN KINGDOMS****");

        while (flag_menu) {
            System.out.println("1.- CREATE CHARACTER");
            System.out.println("2.- VISUALIZE CHARACTER");
            System.out.println("3.- EXIT");

            System.out.println("CHOOSE AN OPTION");

            String user_option =  scanner.nextLine();

            switch (user_option) {
                case "1":
                    System.out.println("CREATING CHARACTER");
                    //NOMBRE DEL PERSONAJE
                    System.out.println("INNGRESE UN NOMBRE");
                    player_character.name = scanner.nextLine();

                    //VIDA DEL PERSONAJE
                    System.out.println("INNGRESE LOS PUNTOS DE VIDA");
                    //Esto es la forma no segura
                    //player_character.hit_points = Integer.parseInt(scanner.nextLine());

                    //Esto es con encapsulamiento
                    player_character.asignarVida( Integer.parseInt( scanner.nextLine() ) );


                    //PUNTOS MAGICO
                    System.out.println("INNGRESE EL MANÁ");
                    player_character.magic_points = Integer.parseInt(scanner.nextLine());
                    break;

                case "2":

                    System.out.println("VER PERSONAJE");
                    System.out.println("NOMBRE: " + player_character.name);
                    System.out.println("HP: " +  player_character.mostrarVida() );
                    System.out.println("MANÁ: " + player_character.magic_points);

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
}
