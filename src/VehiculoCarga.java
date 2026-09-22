public abstract class VehiculoCarga extends Vehiculo{
    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
        super(patente, marca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }
    public int getpesoMaxCarga(){
        return this.pesoMaxCarga;
    }

    @Override
    public int calcularCostoRevision() {
        return 30000+(this.pesoMaxCarga*5);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " La carga maxima es de: " + this.getpesoMaxCarga() + "Kg.";
    }
}
