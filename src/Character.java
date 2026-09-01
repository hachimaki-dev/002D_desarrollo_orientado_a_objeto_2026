public class Character {
    private String name;
    private int hit_points;
    private int magic_points;
    boolean is_ally;
    private int age;



    public void atacar(){
        System.out.println("Atacando!!");
    }

    public void validarPuntosMagicos(int pmRecibidos){
    if (pmRecibidos < 0) {
        System.out.println("LOS PM NO PUEDEN QUEDAR NEGATIOS");
        
    }else{
        this.magic_points = pmRecibidos;
    }
       
    }


    public int mostrarPM(){
        return this.magic_points;
    }

    public void validarNombre(String name) {
        name = name.toUpperCase();
        switch (name) {
            case "WEON":
                System.out.println("Nombre no valido");
                break;
            case "SOPENCO":
                System.out.println("Nombre no valido");

                break;
            case "SOPENKO":
                System.out.println("Nombre no valido");

                break;
            case "ESTUPIDO":
                System.out.println("Nombre no valido");

                break;

            default:
                this.name = name;
                break;
        }
    }

    public String mostrarNombre() {
        return this.name;
    }

    public void validarEdad(int age) {
        if (age < 0) {
            System.out.println("Dado que le asignaste una edad negativa, el programa la dejo en 0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    // MUestre la edad
    public int mostrarEdad() {
        return this.age;
    }

    public void asignarVida(int hit_points) {
        if (hit_points < 0) {
            this.hit_points = 0;
        } else {
            this.hit_points = hit_points;
        }
    }

    public int mostrarVida() {
        return this.hit_points;
    }

}
