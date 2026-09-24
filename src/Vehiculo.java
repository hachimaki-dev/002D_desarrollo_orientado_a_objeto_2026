abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int RevisionesPendientes) {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = RevisionesPendientes;
    }

    public String getPatente() {
        return patente;
    }
    
    public String getMarca() {
        return marca;
    }

    public int getRevisionesPendientes() {
        return revisionesPendientes;
    }

    public void setRevisionesPendientes(int pendientes) {
        revisionesPendientes = pendientes;
    }

    abstract public int calcularCostoRevision();

    public String mostrarInfo(){
        return "Patente: " + getPatente() + " | Marca: " + getMarca() + " | Costo de revisión: $" + calcularCostoRevision() + " | Revisiones pendientes: " + getRevisionesPendientes();
    }
}
