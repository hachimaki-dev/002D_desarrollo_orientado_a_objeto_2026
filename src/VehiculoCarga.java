public class VehiculoCarga extends Vehiculo{
    private int CapacidadCarga;

    public VehiculoCarga(String Patente, String Marca, int RevisionesPendientes, int CapacidadCarga){
        super(Patente, Marca, RevisionesPendientes);
        this.CapacidadCarga = CapacidadCarga;
    }

    public int getCapacidadCarga(){
        return CapacidadCarga;
    }

    @Override
    public int CalcularCostoRevision() {
        return 30000 + (CapacidadCarga * 5);
    }

    @Override
    public String mostrarInfo() {
        return "Carga " + "Patente : " + getPatente() + "Marca : " + getMarca() + "Capacidad de carga : " + getCapacidadCarga() + "Costo de revision : $" + CalcularCostoRevision() + "Revisiones pendientes : " + getRevisionesPendientes();        
    }
}