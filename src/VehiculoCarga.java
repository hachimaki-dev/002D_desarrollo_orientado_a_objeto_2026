public class VehiculoCarga extends Vehiculo{

    private int pesomaxCarga;



    VehiculoCarga(String patente,String marca, int revisionesPendientes,int pesomaxCarga){

        super(patente, marca, revisionesPendientes);
        this.pesomaxCarga = pesomaxCarga;

       
    }
     public int GetPesoMaxCarga(){

            return this.pesomaxCarga;
        
    
    }
    @Override
    public int CalcularCostoRevision() {
        
        return 30000 + (pesomaxCarga * 5);


    }

    @Override
    public String mostrarInfo() {
        
        return super.mostrarInfo() + "[Carga: " + GetPesoMaxCarga() + "]";
    }

}