public class VehiculoParticular extends Vehiculo{
    private int numPasajeros;

    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros){
        super(patente, marca, revisionesPendientes);
        this.numPasajeros= numPasajeros;
    }

    public int getNumPasajeros(){
        return this.numPasajeros;
    }

    public int calcularCostoRevision(){
        return 30000 + (numPasajeros * 2000);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " Vehiculo Particular, con un numero de pasajeros de: " + numPasajeros;
    }
}
