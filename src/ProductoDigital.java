public class ProductoDigital extends Producto{
    private int descuento;
    private String plataforma;

    ProductoDigital(String nombre, int precioBase, int stock, int descuento, String plataforma){
        super(nombre, precioBase, stock);
        this.descuento = descuento;
        this.plataforma = plataforma;
    }

    @Override
    public int calcularPrecioFinal() {
        return  this.getPrecioBase() - (this.getPrecioBase() * this.descuento )/ 100;
    }

    public int getDescuento(){
        return this.descuento;
    }

    public String getPlataforma(){
        return this.getPlataforma();
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " . Descuento de " + this.descuento + "% " + " . [PLATAFORMA] " + this.plataforma + this.calcularPrecioFinal();
    }

}
