public class VehiculoParticular extends Vehiculo {
    private int numPasajeros;



    VehiculoParticular(String patente,String marca,int revisionesPendientes,int numPasajeros){

        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;


    }
    public int getNumPasajeros(){

        return this.numPasajeros;


    }

    @Override
    public int CalcularCostoRevision() {
        
        return 30000 + (numPasajeros * 2000);


    }   
    @Override
    public String mostrarInfo() {
        
        return super.mostrarInfo() + "[Particular: " + numPasajeros + "]";

    }
}   
