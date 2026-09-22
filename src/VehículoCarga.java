public class VehículoCarga extends Vehículo
{
    private int pesoMaxCarga;

    public VehículoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga)
    {
        super(patente, marca, revisionesPendientes);
        setMarca(marca);
        setPatente(patente);
        setRevisionesPendientes(revisionesPendientes);
        setPesoMaxCarga(pesoMaxCarga);
    }

    public int getPesoMaxCarga()
    {
        return pesoMaxCarga;
    }

    public void setPesoMaxCarga(int pesoMaxCarga)
    {
        this.pesoMaxCarga = pesoMaxCarga;
    }

    int calcularCostoRevision()
    {
        return 30000 + (pesoMaxCarga * 5);
    }

    @Override
    public String mostrarInfo()
    {
        return "Patente" + patente + "Marca" + marca + "Revisiones pendientes" + revisionesPendientes + "Peso maximo de carga" + pesoMaxCarga;
    }
}
