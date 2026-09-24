public class VehiculoCarga extends Vehiculo{
 private int pesoMaxCarga;
 VehiculoCarga(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
    super(patente, marca, revisionesPendientes);
    this.pesoMaxCarga=pesoMaxCarga;
 }
 public int getPesoMaxCarga(){
    return this.pesoMaxCarga;
 }
  @Override
 public int calcularCostoRevision(){
    return 30000+(pesoMaxCarga*5);
 }
 @Override 
 public String mostrarInfo(){
    return super.mostrarInfo()+"peso MAximo De Carga: "+this.pesoMaxCarga;
 }
}
