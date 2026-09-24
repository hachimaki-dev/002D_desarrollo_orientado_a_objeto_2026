public class VehiculoParticular extends  Vehiculo{
    private int numeroPasajeros;

    public VehiculoParticular(String patente , String marca, int revisionesPendientes, int numeroPasajeros){
        super(patente, patente, revisionesPendientes);
        this.numeroPasajeros = numeroPasajeros;
    }

  public int NumeroPasajeros(){
        return numeroPasajeros;
    }
    
     @Override 

    public int calcularCostoRevision(){
     return 30000 + (numeroPasajeros * 2000);
    }
    @Override 

    public String mostrarInfo(){
     return  "Particular: " + super.mostrarInfo() + "Pasajeros : " + numeroPasajeros;

    }

  
    

}

