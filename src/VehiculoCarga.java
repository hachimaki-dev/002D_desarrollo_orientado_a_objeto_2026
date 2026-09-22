public class VehiculoCarga extends Vehiculo{
    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
        super(patente, marca, revisionesPendientes);
        pesoMaxCarga = this.pesoMaxCarga;
    }

    public int getPesoMaxCarga(){
        return this.pesoMaxCarga;
    }

    public int calcularCostoRevision(){
        return 30000 + (pesoMaxCarga * 5);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " Vehiculo de Carga, con un peso maximo de carga de: " + pesoMaxCarga;
    }
}
