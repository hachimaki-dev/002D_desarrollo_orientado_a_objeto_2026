public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente , String marca , int revisionesPendientes){
        setPatente(patente);
        setMarca(marca);
        setRevisionesPendientes(revisionesPendientes);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        return "| Patente : " + getPatente() + "| Marca : " + getMarca() + "| Costo de revision : " + calcularCostoRevision();
    }
    
}
