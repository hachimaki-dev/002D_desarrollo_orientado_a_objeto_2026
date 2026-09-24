public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente , String marca , int revisionesPendientes){
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
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

    public void setRevisionesPendientes(int revisionesPendientes) {
        this.revisionesPendientes = revisionesPendientes;
    }

    public abstract int calcularCostoRevision();
    @Override 
    public String toString(){
        return "| Patente : " + getPatente() + "| Marca : " + getMarca() + "| Costo de revision : " + calcularCostoRevision() + "| Revisiones pendientes :" + revisionesPendientes;
    }
    
}
