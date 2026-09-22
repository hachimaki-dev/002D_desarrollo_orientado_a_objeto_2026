public abstract class VehiculoParticular extends Vehiculo{
    private int numPasajeros;

    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros){
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;
    }
    public int getnumPasajeros(){
        return this.numPasajeros;
    }

    @Override
    public int calcularCostoRevision() {
        return 30000+(this.numPasajeros*2000);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " numero de pasajeros " + this.getnumPasajeros();
    }
}
