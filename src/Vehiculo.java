public abstract  class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes) {
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
        if(revisionesPendientes >= 0){
            this.revisionesPendientes = revisionesPendientes;
        } else {
            System.out.println("No se pueden tener revisiones pendientes negativas");
        }
    }

    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return "Patente: " +  patente + ", Marca: " + marca + ", Revisiones pendientes: " + revisionesPendientes; 
    }
}
