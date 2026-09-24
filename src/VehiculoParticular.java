public class VehiculoParticular extends Vehiculo {
    //esto seria el encapsulamiento donde los datos estan protegido y solo se pueden acceder por getter(mostrar dato) o setter(modificar datos)
    private int numPasajeros;
    
    public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros){
        super(patente, marca, revisionesPendientes);
        this.numPasajeros = numPasajeros;

    }// esta linea seria el metodo contructor que hereda los atributo de la clase padre que es Vehiculo ( se utilizar el comando super para eso)
    public int getnumPasajeros(){
        return this.numPasajeros;
    }
    @Override
    public int calcularCostoRevision() {
        return 30000 + (this.getnumPasajeros() * 2000);
    }
    @Override
    public String mostrarInfo() {
    
        return super.mostrarInfo() + " vehiculo particular con capacidad de :" + this.getnumPasajeros() + " pasajeros. Costo de la revision : $"+ this.calcularCostoRevision();
    }
}
