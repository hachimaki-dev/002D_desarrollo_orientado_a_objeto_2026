abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes){
        this.patente=patente;
        this.marca=marca;
        this.revisionesPendientes= revisionesPendientes;
    }

    public String getPatente(){
        return this.patente;
    }

    public String getMarca(){
        return this.marca;
    }

    public int getRevisionesPendientes(){
        return this.revisionesPendientes;
    }

    public void setRevisionesPendientes(int revisionesPendientes){
        this.revisionesPendientes= revisionesPendientes;
    }

    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return "La patente es: " + patente + ", la marca es: " + marca + ", el costo de revision es: " + calcularCostoRevision() + ", las revisiones pendientes son: " + revisionesPendientes;

    }

}
