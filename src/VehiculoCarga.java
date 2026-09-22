public class VehiculoCarga extends Vehiculo{
    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga) {
        super(patente, marca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }

    public int getpesoMaxCarga(){
        return this.pesoMaxCarga;
    }
    
    @Override
    public int calcularCostoRevision() {
        return 30000 + (this.getpesoMaxCarga() * 5);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " El tipo de vehiculo es ''CARGA''. El peso máximo es de: " + this.getpesoMaxCarga();
    }
    
}
