public class VehiculoCarga extends Vehiculo{
    private int pesoMaxCarga;
    public VehiculoCarga(String Patente, String Marca, int RevisionPendientes, int pesoMaxCarga){
        super(Patente, Marca, RevisionPendientes);
    }

    public int getPesoMaxCarga() {
        return pesoMaxCarga;
    }
    @Override
    public int CostoRevision() {
        return super.CostoRevision();
    }
    @Override
    public void mostrarInfo(String Patente, String Marca, int RevisionPendientes) {
        super.mostrarInfo(Patente, Marca, RevisionPendientes);
    }
}
