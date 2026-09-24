public class vehiculoparticular extends vehiculo {
    private int cantidad_pasajeros;

    public vehiculoparticular(String patente, String marca, int revisiones_pendientes, int cantidad_pasajeros) {
        super(patente, marca, revisiones_pendientes);
        this.cantidad_pasajeros = cantidad_pasajeros;
    }
    
    public int getcantidad_pasajeros() { return cantidad_pasajeros; }

    @Override 
    public int calcular_costo_revision() {
        return 30000 + (cantidad_pasajeros * 2000);

    }

    @Override 
    public String mostrarinformacion() {

        return "carga: " + getpatente() + "marca: " + getmarca() + "cantidad pasajeros:" + "costo revision: " + cantidad_pasajeros + calcular_costo_revision();
    }
}
