public class VehiculoParticular extends Vehiculo{
    private int numPasajeros;

    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros) {
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros(){
        return this.numPasajeros;
    }

    @Override
    public int calcularCostoRevision() {
        return 3000 + (this.numPasajeros * 2000);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " El tipo de vehiculo es PARTICULAR. El número de pasajeros es de: " + this.getNumPasajeros();
    }
}
