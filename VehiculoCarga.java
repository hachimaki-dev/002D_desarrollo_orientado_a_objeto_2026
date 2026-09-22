public class VehiculoCarga extends Vehiculo{

    private int pesoMaxCarga;

    VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
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
        // TODO Auto-generated method stub
        return super.mostrarInfo() + "tipo: Carga" + "y su peso maximo de carga es de: " + this.getPesoMaxCarga() ;
    }
}
