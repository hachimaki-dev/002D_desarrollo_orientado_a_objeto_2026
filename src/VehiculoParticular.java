public class VehiculoParticular extends Vehiculo {
    private int numPasajeros;
    
    public VehiculoParticular(String patente , String marca , int revisionesPendientes , int numPasajeros){
        super(patente, marca, revisionesPendientes);
        setnumPasajeros(numPasajeros);
    }
    public void setnumPasajeros(int numPasajeros){
        this.numPasajeros = numPasajeros;
    }
    public int getnumPasajeros(){
        return numPasajeros;
    }
    @Override 
    public int calcularCostoRevision(){
        return 30000 + (numPasajeros * 2000);
    }
    @Override 
    public String toString(){
        return "| Particular" + "| Patente : " + getPatente() + "| Marca : " + getMarca() + "| Costo de revision : " + calcularCostoRevision() + "Numero de pasajeros" + getnumPasajeros();
    }
    }

