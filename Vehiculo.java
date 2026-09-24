public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;



    public Vehiculo(int tipoVehiculo, String patente, String marca, int revisionesPendientes){
        this.marca = marca;
        this.patente = patente;
        this.revisionesPendientes = revisionesPendientes;
    
        

    }
    
    public String getPatente(){
        return patente;
    }

    public String getMarca(){
        return marca;
    }

    public int getRevisionesPendientes() { 
        return revisionesPendientes;

    }

    public abstract int calcularCostoRevision();

    


    
    public String motrarInfo(){
        return "MARCA: " + marca + "PATENTE: " + patente + "Costo de revision: " + calcularCostoRevision() + "Pendientes: " + revisionesPendientes;


    }





}
