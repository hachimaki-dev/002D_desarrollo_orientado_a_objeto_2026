public abstract class Vehiculo_Carga {
    public class Vehiculo extends Vehiculo_Carga{
        private int pesoMaxCarga;

        public Vehiculo_carga(int pesoMaxCarga, String patente, String marca, int revisionesPendientes) {
            this.pesoMaxCarga = pesoMaxCarga;
            
        }

        public int getPesoMaxCarga(){
            return pesoMaxCarga;

        }

        @Override 
        public getCalcularCostoRevision() {
            return 3000 + (pesoMaxCarga * 5);

        }

    
    }

    
}
