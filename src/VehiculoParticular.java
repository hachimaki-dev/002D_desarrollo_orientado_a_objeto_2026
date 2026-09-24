public class VehiculoParticular extends Vehiculo
{
    private int numeroDePasajeros;

    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numeroDePasajeros)
    {
        super(patente, marca, revisionesPendientes);
        setMarca(marca);
        setPatente(patente);
        setRevisionesPendientes(revisionesPendientes);
        setNumeroDePasajeros(numeroDePasajeros);
        
    }

    public int getNumeroDePasajeros()
    {
        return numeroDePasajeros;
    }

    public void setNumeroDePasajeros(int numeroDePasajeros)
    {
        this.numeroDePasajeros = numeroDePasajeros;
    }
    
    int calcularCostoRevision()
    {
        return 30000 + (numeroDePasajeros * 2000);
    }

    @Override
    public String mostrarInfo()
    {
        return "Este vehículo es particular. " + "Patente: " + patente + "Marca: " + marca + "Revisiones pendientes: " + revisionesPendientes + "Numero de pasajeros: " + numeroDePasajeros;
    }
}
