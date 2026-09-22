public class VehiculoCarga extends Vehiculo {
    private int pesoMaxCarga;   // Peso carga en KG

    public VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga)
    {
        super(patente, marca, revisionesPendientes);

        this.pesoMaxCarga = pesoMaxCarga;
    }

    public int getPesoMaxCarga()
    {
        return pesoMaxCarga;
    }
    
    @Override
    public int calcularCostoRevision()
    {
        return 30000 + (pesoMaxCarga * 5);
    }

    @Override
    public String mostrarInfo()
    {
        String mensaje =  "Carga, " + "| Carga máxima: " + pesoMaxCarga + " kg" + super.mostrarInfo();

        return mensaje;
    }
}
