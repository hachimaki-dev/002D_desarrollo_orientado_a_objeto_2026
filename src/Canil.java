public class Canil {
    public static void main(String[] args) {
        
        System.out.println("***Bienvenido al caníl****");

        Perro perro_del_profe = new Perro();
        perro_del_profe.nombre = "Gimli";
        perro_del_profe.edad = 1;
        perro_del_profe.peso = 40.5;
        perro_del_profe.tiene_vacuna = false;

        if (perro_del_profe.edad > 2) {
            System.out.println("El perro tiene más de 2 años. Su edad es " + perro_del_profe.edad);
        } else {
            System.out.println("El perro NO tiene más de 2 años. Su edad es " + perro_del_profe.edad);
        }


        System.out.println("Gracias por su visita");

     if (perro_del_profe.peso > 20) {

        System.out.println("El perro tiene mas de 20 kilogramos de peso y su peso es: " + perro_del_profe.peso);
     }else{
        System.out.println("El perro tiene menos de 20 kilogramos de peso y su peso es: " + perro_del_profe.peso);
     }
    }
    
}
