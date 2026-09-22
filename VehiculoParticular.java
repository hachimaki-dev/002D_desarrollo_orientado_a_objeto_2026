public abstract  class  VehiculoParticular {

    public class Vehiculo extends VehiculoParticular{
        private int numPasajeros;
        

        public VehiculoParticular(int numPasajeros, String patente, String marca, int revisionesPendientes) {
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
            return "";
            

        }

    }
}
