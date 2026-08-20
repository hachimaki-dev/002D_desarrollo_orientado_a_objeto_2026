public class Character {
    String name;
    private int hit_points;
    int magic_points;
    boolean is_ally;
    private int age;


    public void validarEdad(int age){
        if (age < 0){
            System.out.println("Dado que le asignaste una edad negativa, el programa la dejo en 0");
            this.age = 0;
        }else{
            this.age = age;
        }
    }
    //MUestre la edad
    public int mostrarEdad(){
        return this.age ;
    }

    public void asignarVida(int hit_points){
        if (hit_points < 0) {
            this.hit_points = 0;
        }else{
            this.hit_points = hit_points;
        }
    }

    public int mostrarVida(){
        return this.hit_points;
    }

}
