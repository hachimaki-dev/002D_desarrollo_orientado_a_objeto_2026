public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;


     Vehiculo(String patente,String marca,int revisionesPendientes){

        this.patente = patente;
        this.marca = marca;
        this.revisionesPendientes = revisionesPendientes;

    }

    public String getPatente(){

        return this.patente;
    }
    public String getMarca(){

        return this.marca;
    }
    public int getRevisionPendiente(){

        return this.revisionesPendientes;

    }
    public void setRevisionesPendientes(int revisionesPendientes){

        if (revisionesPendientes >= 0){

            this.revisionesPendientes = revisionesPendientes;
        }else{

            System.out.println("Ingrese un numero entero positivo");
        }


    }
    public abstract int CalcularCostoRevision();


    public String mostrarInfo(){

        return "|"+"La patente del vehiculo: "+ this.patente + "|" + " la marca del vehiculo: " + this.marca + "|"+ " Revisiones pendientes: "+ this.revisionesPendientes + "|";
    }

}
