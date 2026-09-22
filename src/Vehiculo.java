public abstract class Vehiculo {
        private String Patente;
        private String Marca;
        public int RevisionPendientes;
       
        public Vehiculo(String patente, String marca, int RevisionPendientes){
        }

        public String getPatente() {
            return Patente;
        }
        
        public String getMarca(){
            return Marca;
        }

        public int getRevisionPendientes(){
            return RevisionPendientes;
        }

        public void setRevisionPendientes(int revisionPendientes) {
            RevisionPendientes = revisionPendientes;
        }   

        public int CostoRevision(){
            return RevisionPendientes;
            
        }

        public void mostrarInfo(String Patente, String Marca, int RevisionPendientes){
        }
}
