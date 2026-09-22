public abstract class Vehiculo {
    
    private String patente;
    private String marca;
    private int revisionesPendientes;
    private int precioBase = 30000;

    
    public Vehiculo(String patente, String marca, int revisionesPendientes) {
        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;
    }

    

    public int getPrecioBase() {
        return precioBase;
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


    public void setRevisionesPendientes(int revisionesPendientes) {
        this.revisionesPendientes = revisionesPendientes;
    }
    
    
    public abstract int calcularCostoRevision();

    public String mostrarInfo() {
        return "Patente:" + patente +
               "Marca:" + marca +
               "Revisiones Pendientes:" + revisionesPendientes +
               "Final: $" + calcularCostoRevision();
    

    


    }




  







}
