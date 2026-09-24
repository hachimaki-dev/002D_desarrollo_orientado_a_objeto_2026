public class VehiculoParticular extends Vehiculo{
    private int numPasajeros;

    public VehiculoParticular(String Patente, String Marca, int RevisionesPendientes, int numPasajeros){
        super(Patente, Marca, RevisionesPendientes);
        this.numPasajeros = numPasajeros;
    }

    public int getnumPasajeros(){
        return numPasajeros;
    }

    @Override
    public int CalcularCostoRevision() {
        return 30000 + (numPasajeros * 2000);
    }

    @Override
    public String mostrarInfo() {
        return "Particular " + "Patente : " + getPatente() + "Marca : " + getMarca() + "Numero de pasajeros : " + getnumPasajeros() + "Costo de revision : $" + CalcularCostoRevision() + "Revisiones pendientes : " + getRevisionesPendientes();        
    }
}