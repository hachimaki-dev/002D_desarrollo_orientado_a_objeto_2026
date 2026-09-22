public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    public Vehiculo(String patente, String marca, int revisionesPendientes){
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    public String getpatente(){
        return this.patente;
    }
    public String getmarca(){
        return this.marca;
    }
    public int getrevisionesPendientes(){
        return this.revisionesPendientes;
    }

    public void setRevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes < 0 ){
            System.out.println("La cantidad de revisiones pendientes no pueden ser negativas");
        }else{
            this.revisionesPendientes=revisionesPendientes;
            System.out.println("Revisiones pendientes registradas con éxito");
        }
    }

    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return this.getpatente() + " - " + getmarca() + " (Pendientes: " + getrevisionesPendientes() + ")";
    }

}
