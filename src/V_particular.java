public class V_particular extends Vehiculo{
    private int NumeroP;
    
    public V_particular(String patente, String marca, int revision_pendiente,int NumeroP){
    super(patente, marca, revision_pendiente);
    this.NumeroP = NumeroP;

    }
    public int getNumeroP(){
        return this.NumeroP;
    }
    @Override
    public int calcular_costo_de_revision(){
        return 30000 + (NumeroP * 2000);
    } 
    @Override
    public String mostrarInfo(){
      return "Patente: " + getpatente() + "Marca: " + getmarca() + "Revisiones pendientes: " + getrevisionP() + "Costo de revisiones: " + calcular_costo_de_revision() + "Particular: "+ NumeroP ;
    }
        
}