public abstract class Vehiculo {
    private String Patente;
    private String Marca;
    private int RevisionesPendientes;
    
    public Vehiculo(String Patente, String Marca, int RevisionesPendientes){
        this.Patente = Patente;
        this.Marca = Marca;
        this.RevisionesPendientes = RevisionesPendientes;
    }
    public String getPatente(){
        return Patente;
    }
    public String getMarca(){
        return Marca;
    }
    public void setMarca(){
        Marca = Marca;
    }
    public int getRevisionesPendientes(){
        return RevisionesPendientes;
    }
    public void setRevisionesPendientes(int RevisionesPendientes){
        this.RevisionesPendientes = RevisionesPendientes;
    }
    public abstract int CalcularCostoRevision();
    
    public String mostrarInfo(){
        return "Patente : " + Patente + "Marca : " + Marca + "Costo de revision : " + CalcularCostoRevision() + "Revisiones Pendientes : " + RevisionesPendientes;
    }
}