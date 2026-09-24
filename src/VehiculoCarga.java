public class VehiculoCarga extends Vehiculo {
    private int pesoMaxCarga;

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga) {
        super(patente, marca, revisionesPendientes);
        this.pesoMaxCarga = pesoMaxCarga;
    }
    public int getPesoMaxCarga() {
        return pesoMaxCarga;
    }
    public void setPesoMaxCarga(int pesoMaxCarga) {
        this.pesoMaxCarga = pesoMaxCarga;
    }
    @Override
    public int calcularCostoRevision() {
        return 30000 + (pesoMaxCarga * 5);
    }
    @Override 
    public String toString() {
        return "Carga | " + getPatente() + " | Marca: " + getMarca() + 
            " | Carga max: " + pesoMaxCarga + " kg" + 
            " | Costo revision: $" + calcularCostoRevision() + 
            " | Revisiones pendientes: " + getRevisionesPendientes();
    }
}