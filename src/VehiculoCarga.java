public class VehiculoCarga extends Vehiculo {
    private int pesoMaxCarga;
    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
        super(patente, marca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }
    public int getPesoMaxCarga(){
        return this.pesoMaxCarga;
    }
    @Override
    public int calcularCostoRevision() {
        return 30000 + (this.getPesoMaxCarga() * 5);
    }
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " vehiculo de carga con peso maximo de carga : " + this.getPesoMaxCarga() + " kilogramos.  " + "costo de la revision : $"+ this.calcularCostoRevision();
    }
}
