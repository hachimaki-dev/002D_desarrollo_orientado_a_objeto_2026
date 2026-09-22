abstract class  Vehículo 
{
    protected String patente;
    protected String marca;
    protected int revisionesPendientes;

    public Vehículo(String patente, String marca, int revisionesPendientes)
    {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    public Vehículo(){}

    public String getPatente()
    {
        return patente;
    }

    public void setPatente(String patente)
    {
        this.patente = patente;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public int getRevisionesPendientes()
    {
        return revisionesPendientes;
    }

    public void setRevisionesPendientes(int revisionesPendientes)
    {
        this.revisionesPendientes = revisionesPendientes;
    }

    abstract int calcularCostoRevision();

    public String mostrarInfo()
    {
        return "Patente" + patente + "Marca" + marca + "Revisiones pendientes" + revisionesPendientes;
    }
}
