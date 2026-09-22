public class vehiculocarga extends vehiculo {
    private int carga_maxima;

    public vehiculocarga(String patente, string marca, int revisiones_pendientes, int carga_maxima) {
        this.carga_maxima = carga_maxima;
    }
    
    @Override 
    public int calcular_costo_revision() {
        return 30000 + (carga_maxima * 5);

    }

    @Override 
    public String mostrarinformacion() {

        return "carga: " + getpatente() + "marca: " getmarca() + "carga max:" + carga_maxima + "kg" + calcular_costo_revision()
    }
}
