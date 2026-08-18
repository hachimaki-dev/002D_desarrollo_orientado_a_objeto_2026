public class Character {
    String name;
    private int hit_points;
    int magic_points;
    boolean is_ally;


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
