public abstract class VehiculoCarga {
    public class Vehiculo extends VehiculoCarga{
        private int pesoMaxCarga;

        public VehiculoCarga(String patente, String marca, int pesoMaxCarga){
            super(patente, marca, revisionesPendientes);
            this.pesoMaxCarga = pesoMaxCarga;

        }
            
        

        public int getPesoMaxCarga(){
            return pesoMaxCarga;

        }

        @Override 
        public int calcularCostoRevision(){
            return 3000 + (pesoMaxCarga * 5);

        }

        @Override 
        public String mostrarInfo() {
            return "carga: " + getPatente() + "marca: " + getMarca() + " Carga Maxima: " + pesoMaxCarga + "KG: " + "costo revision: " + calcularCostoRevision() + "Pendientes: " + getRevisionesPendientes();

        }



        }

        
    }

    

