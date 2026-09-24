public class VehiculoCarga extends Vehiculo{
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
        return 30000 + (this.pesoMaxCarga * 5);
    }

  
    @Override
    public String mostrarInfo() {
        return "Vehiculo de carga: " + super.mostrarInfo() + ". Peso maximo de carga: " + this.pesoMaxCarga;
    }
    
}
