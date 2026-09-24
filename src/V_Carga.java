public class V_Carga extends Vehiculo{

    private int PesoMax;
    
    public V_Carga(String patente, String marca, int revision_pendiente,int PesoMax){
    super(patente, marca, revision_pendiente);
    this.PesoMax = PesoMax;

    }
    public int getPesoMax(){
        return this.PesoMax;
    }
    @Override
    public int calcular_costo_de_revision(){
        return 30000 + (PesoMax * 5);
    } 
    @Override
    public String mostrarInfo(){
      return "Patente: " + getpatente() + "Marca: " + getmarca() + "Revisiones pendientes: " + getrevisionP() + "Costo de revisiones: " + calcular_costo_de_revision() + "carga: "+ PesoMax ;
    }
        
    }
