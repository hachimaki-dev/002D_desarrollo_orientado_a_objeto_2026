public abstract class vehiculo {
    private String patente;
    private String marca;
    private int revisiones_pendientes;

    public vehiculo(String patente, String marca, int revisiones_pendientes) {
        this.patente = patente;
        this.marca = marca;
        this.revisiones_pendientes = revisiones_pendientes;
    }

    public String getpatente() { return patente; }
    public String getmarca() { return marca; }
    public int getrevisiones_pendientes() { return revisiones_pendientes; }

    public void setrevisiones_pendientes(int revisiones_pendientes ) {
        this.revisiones_pendientes = revisiones_pendientes;
    }

    public abstract int calcular_costo_revision();

    public String mostrarinformacion() {
        return patente + " marca: " + marca + " costo revision: " + calcular_costo_revision();
    }


}
