public class Zombie extends Character {
    boolean canInffectVillager = true;


    @Override
    public void atacar() {
        super.atacar();
        System.out.println("Te persigue y te pega con la pala 'dependiendo'");
    }

    public void infectarAldeano(){
        System.out.println("Te mato, luego te infecto");
    }

}
