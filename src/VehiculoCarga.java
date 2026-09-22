package src;

public class VehiculoCarga extends Vehiculo {
    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int RevisionesPendientes, int pesoMaxCarga) {
        super(patente, marca, RevisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }

    public int getPesoMaxCarga() {
        return pesoMaxCarga;
    }

    public int calcularCostoRevision() {
        return 30000 + (pesoMaxCarga * 5);
    }

    @Override
    public String mostrarInfo() {
        return "Patente: " + getPatente() + " | Marca: " + getMarca() + " | Tipo de vehículo: Carga | Peso máximo de carga: " + pesoMaxCarga +" | Costo de revisión: $" + calcularCostoRevision() + " | Revisiones pendientes: " + getRevisionesPendientes();
    }

}
