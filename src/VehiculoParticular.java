public class VehiculoParticular extends Vehiculo{
    private int numPasajeros;
    public VehiculoParticular(String Patente, String Marca, int RevisionPendientes, int numPasajeros){
        super(Patente, Marca, RevisionPendientes);
    }

    public int getNumPasajeros() {
        return numPasajeros;
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