public abstract  class  VehiculoParticular {

    public class Vehiculo extends VehiculoParticular{
        private int numPasajeros;
        

        public VehiculoParticular(String patente, String marca, int revisionesPendientes, int numPasajeros) {
            super (patente, marca, revisionesPendientes);
            this.numPasajeros = numPasajeros;
        }

        
        public int getNumPasajeros() { 
            return numPasajeros;

        }

        
        @Override 
        public int CalcularCostoRevision() {
            return 3000 + (numPasajeros * 2000);
        }

        @Override 
        public String mostrarInfo() {
            return "Particular: " + getPatente() + "marca: " + getMarca() + "Pasajeros: " + numPasajeros + "Costo de revision: " + calcularCostoRevision() + "pendientes: " + getRevisionesPendientes();
            

        }

    }
}
