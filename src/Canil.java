public class Canil {
   
    public static void main(String[] args) {

        Perro perro_de_camilo = new Perro();

        Perro perro_de_alexander = new Perro();
    
        Perro perro_de_rogelio = new Perro();

        perro_de_camilo.nombre = "Porky";
        perro_de_camilo.edad = 5;
        perro_de_camilo.raza = "Quiltro";
        perro_de_camilo.peso = 40.5;
        perro_de_camilo.vacuna = true;

        perro_de_alexander.nombre = "Sacha";
        perro_de_alexander.edad = 2;
        perro_de_alexander.raza = "Pastor Alemàn";
        perro_de_alexander.peso = 30.5;
        perro_de_alexander.vacuna = true;

        perro_de_rogelio.nombre = "Almendra";
        perro_de_rogelio.edad = 4;
        perro_de_rogelio.raza = "Quiltro";
        perro_de_rogelio.peso = 4;
        perro_de_rogelio.vacuna = true;


        System.out.println("Los siguientes animales han ingresado al canil");

        System.out.println(perro_de_camilo.nombre);
        String ladrido  =  perro_de_camilo.ladrar();
        System.out.println(ladrido);


        System.out.println(perro_de_alexander.nombre);
        System.out.println(perro_de_rogelio.nombre);
        
    }


}
