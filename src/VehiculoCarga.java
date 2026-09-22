public class VehiculoCarga extends Vehiculo {
    private int pesoMaxCarga;

    public VehiculoCarga(String patente , String marca , int revisionesPendientes , int pesoMaxCarga){
        super(patente, marca, revisionesPendientes);
        setpesoMaxCarga(pesoMaxCarga);
    }
    public void setpesoMaxCarga(int pesoMaxCarga){
        this.pesoMaxCarga = pesoMaxCarga;
    }
    public int getpesoMaxCarga(){
        return pesoMaxCarga;
    }
    public int calcularCostoRevision(){
        return 30000 + (pesoMaxCarga * 5);
    }
    @Override 
    public String toString(){
        return  "| Vehiculo Carga" + "| Patente :" + getPatente() + "| Marca :" + getPatente() + "| Costo revision :" + calcularCostoRevision() + "Peso maximo de carga" + getpesoMaxCarga(); 
    
}
}