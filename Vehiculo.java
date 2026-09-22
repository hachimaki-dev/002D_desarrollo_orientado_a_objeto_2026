public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;
    public int tipoVehiculo;



    public Vehiculo(int tipoVehiculo, String patente, String marca, int revisionesPendientes){
        this.marca = marca;
        this.patente = patente;
        this.revisionesPendientes = revisionesPendientes;
        this.tipoVehiculo = tipoVehiculo;
        

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

    public void setRevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes < 0){
            System.out.println("");    
        } else {
            this.revisionesPendientes = revisionesPendientes;

        }
        
    }


    
    public String motrarInfo(){
        return "El vehiculo es";


    }





}
