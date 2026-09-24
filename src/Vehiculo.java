public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes)
    {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getRevisionesPendientes() {
        return revisionesPendientes;
    }

    public void setRevisionesPendientes(int revisionesPendientes)
    {
        this.revisionesPendientes = revisionesPendientes;
    }

    public abstract int calcularCostoRevision();    // Costo en pesos chilenos

    public String mostrarInfo()
    {
        String mensaje = " | Patente: " + patente + " | Marca: " + marca + " | Revisiones pendientes: " + revisionesPendientes + " | Costo revisión: $" + calcularCostoRevision();

        return mensaje;
    }
}
