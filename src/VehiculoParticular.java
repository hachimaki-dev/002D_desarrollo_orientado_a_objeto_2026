public class VehiculoParticular extends Vehiculo{
    private int numPasajeros;

    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros) {
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros(){
        return numPasajeros;
    }

    @Override public int calcularCostoRevision(){
        return 30000 + (numPasajeros * 2000);
    }

    @Override public String mostrarInfo() {
        return super.mostrarInfo() + "| Tipo: Particular" + "| Numero de pasajeros: " + getNumPasajeros();
    }


}
