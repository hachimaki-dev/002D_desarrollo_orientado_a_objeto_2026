public class VehiculoCarga extends Vehiculo{
    int pesoMaxCarga;

    public VehiculoCarga(String patente, String narca, int revisionesPendientes, int pesoMaxCarga){
        super(patente, narca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }
    public int getPesoMaxCarga(){
        return pesoMaxCarga;
    }

    @Override
    public int calcularCostoRevision(){    
        return 30000 + (this.pesoMaxCarga * 5);
    }
    @Override
    public String mostrarInfo(){
        return super.mostrarInfo() + " PesoMaxCarga: " + this.pesoMaxCarga + " |";
    }

}
