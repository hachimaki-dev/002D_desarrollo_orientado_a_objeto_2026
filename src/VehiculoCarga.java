public class VehiculoCarga extends Vehiculo {

    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga) {
        super(patente, marca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }

    public int getPesoMaxCarga() {
        return pesoMaxCarga;
    }

    @Override
    public int calcularCostoRevision() {
        return getPrecioBase() + (pesoMaxCarga * 5);

    }

    @Override
    public String mostrarInfo() {
        return "Patente:" + getPatente()+
                "Marca:" + getMarca() +
                "Revisiones Pendientes:" + getRevisionesPendientes() +
                "Final: $" + calcularCostoRevision();
    }

}
