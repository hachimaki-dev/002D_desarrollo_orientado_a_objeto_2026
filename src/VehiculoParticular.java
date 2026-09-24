public class VehiculoParticular extends Vehiculo {

    private int numPasajeros;

    VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros){
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;
    }



    public int getPasajeros(){
        return this.numPasajeros;
    }
    

    @Override
    public int calcularCostoRevision() {
        return 30000 + (this.getPasajeros() * 2000);
    }

    @Override
    public String mostrarInfo() {
        // TODO Auto-generated method stub
        return "PARTICULAR | " + super.mostrarInfo() + " y contiene " + this.getPasajeros() + " pasajeros";
    }
}
