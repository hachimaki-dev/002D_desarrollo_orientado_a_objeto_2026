public class ProductoFisico extends Producto{

    private int costoEnvio;

    ProductoFisico(String nombre, int precioBase, int stock, int costoEnvio){
        super(nombre, precioBase, stock);
        this.costoEnvio = costoEnvio;
    }

    @Override
    public int calcularPrecioFinal() {
        return this.getPrecioBase() + this.costoEnvio;
    }

    public int getCostoEnvio(){
        return this.costoEnvio;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " . Costo de envio " + this.costoEnvio;
    }

}
