public class VehiculoCarga extends Vehiculo{
 private int pesoMaxCarga;
 Vehiculo(String patente, String marca, int revisionesPendientes, int pesoMaxCarga){
    super(patente, marca, revisionesPendientes);
    this.pesoMaxCarga=pesoMaxCarga;
 }
 public int getPesoMaxCarga(){
    return this.pesoMaxCarga;
 }
  @Override
 public int calcularCostoRevision(){
    return getRevisionesPendientes()-getPesoMaxCarga();
 }
 @Override 
 public String mostrarInfo(){
    return super.mostrarInfo()+"peso MAximo De Carga: "+this.pesoMaxCarga;
 }
}
