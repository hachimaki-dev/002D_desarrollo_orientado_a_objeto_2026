public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes){
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
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
        this.revisionesPendientes = revisionesPendientes;
    }

    public abstract int calcularCostoRevision();
    

    public String mostrarInfo(){
        return "| Patente: " + this.patente + "| Marca: " + this.marca + "| Revisiones Pendientes: " + this.revisionesPendientes + " |";
    }
}
