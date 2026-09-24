public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;
    
    public Vehiculo(String patente, String marca, int revisionesPendientes) {
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
    
    public void setRevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes >= 0) {
            this.revisionesPendientes = revisionesPendientes;
        } else {
            System.err.println("Ingrese un numero de revisiones mayor o igual a 0 (!)");
        }
        
    }
    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return "La patente del vehiculo es: " + this.patente + ". La marca es: "
         + this.marca + ". Tiene revisiones pendientes: " + this.revisionesPendientes;
    }
    
}
