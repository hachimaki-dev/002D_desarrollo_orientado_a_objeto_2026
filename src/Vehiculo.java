public abstract class Vehiculo {
    private String patente;
    private String  marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes) {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    public String getPatente(){
        return this.patente;
    }

    public void setRevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes < 0){
            System.out.println("Las revisiones no pueden ser menores a 0");
        } else{
            this.revisionesPendientes = revisionesPendientes;
        }
    }

    public String getMarca(){
        return this.marca;
    }
    
    public int getRevisionesPendientes(){
        return this.revisionesPendientes;
    }

    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return "La patente del vehiculo es: " + this.getPatente() + ". La marca es: " + this.getMarca() + "El costo de revisión es de: $" + this.calcularCostoRevision() + ". Las revisiones pendientes son: " + this.getRevisionesPendientes();
    }
}
