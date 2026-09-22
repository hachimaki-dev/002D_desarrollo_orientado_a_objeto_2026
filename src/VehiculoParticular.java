package src;

public class VehiculoParticular extends Vehiculo {
    private int numPasajeros;

    public VehiculoParticular(String patente, String marca, int RevisionesPendientes, int numPasajeros) {
        super(patente, marca, RevisionesPendientes);
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public int calcularCostoRevision() {
        return 30000 + (numPasajeros * 2000);
    }

    @Override
    public String mostrarInfo() {
        return "Patente: " + getPatente() + " | Marca: " + getMarca() + " | Tipo de vehículo: Particular | Número de pasajeros: " + numPasajeros +" | Costo de revisión: $" + calcularCostoRevision() + " | Revisiones pendientes: " + getRevisionesPendientes();
    }

}
