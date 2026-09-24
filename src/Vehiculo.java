abstract class  Vehiculo 
{
    protected String patente;
    protected String marca;
    protected int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes)
    {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    public Vehiculo(){}

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

    public void reducirRevisionesPendientes(){
        revisionesPendientes -= 1;
    }

    public String mostrarInfo()
    {
        return "Patente" + patente + "Marca" + marca + "Revisiones pendientes" + revisionesPendientes;
    }
}
