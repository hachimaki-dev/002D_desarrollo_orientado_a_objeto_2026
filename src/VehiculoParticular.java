public class VehiculoParticular extends Vehiculo{
 private int numPasajeros;
 Vehiculo(String patente, String marca, int revisionesPendientes, int numPasajeros){
    super(patente, marca, revisionesPendientes);
    this.numPasajeros=numPasajeros;
 }
 public int getNumPasajeros(){
    return this.numPasajeros;
 }

 @Override
 public int calcularCostoRevision(){
    return getRevisionesPendientes()-getNumPasajeros();
 }
 @Override 
 public String mostrarInfo(){
    return super.mostrarInfo()+"Numero de pasajeros: "+this.numPasajeros;
 }
}
