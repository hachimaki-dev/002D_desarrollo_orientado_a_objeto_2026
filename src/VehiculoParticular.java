public class VehiculoParticular extends Vehiculo {
    private int numPasajeros;
    
    public VehiculoParticular(String patente , String marca , int revisionesPendientes , int numPasajeros){
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;
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
        return "Particular" + getPatente() + "| Marca " + getMarca() + "| Pasajeros " + getnumPasajeros() + "Revisiones" + getRevisionesPendientes() + "Costo revision : $ " + calcularCostoRevision();
    } 
    }

