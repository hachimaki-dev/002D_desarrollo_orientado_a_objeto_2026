public abstract class  Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;
    public Vehiculo(String patente, String marca, int revisionesPendientes){
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }
    public String getpatente(){
        return this.patente;
    }
    public String getmarca(){
        return this.marca;
    }
    public int getrevisionesPendientes(){
        return this.revisionesPendientes;
    }
    public void settrevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes < 0) {
            System.out.println("el numero ingresado tiene que ser mayor a 0");
            return;
        }
        else{
            this.revisionesPendientes = revisionesPendientes;

        }

    }
    public abstract int calcularCostoRevision();
    public String mostrarInfo(){
        return "patente del vehiculo: " + this.getpatente() + " marca del vehiculo : "+ this.getmarca() + " revisiones pendientes: " + this.getrevisionesPendientes();
    }

}
