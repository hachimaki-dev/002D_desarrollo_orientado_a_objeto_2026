// ESTOY USANDO EL PARADIGMA DE DESARROLLO ORIENTADO A OBJETOS, SE CENTRA EN EL COMO Y PORQUE FUNCIONAN LAS COSAS, SIMILITUDES Y DIFERENCIAS.
// Anteriormente en python usabamos el paradigma de programacion funcional, algo mucho más simple al actual paradigma de java.
// LAS principales diferencias serian en el como se ordenan los datos, siendo python un lenguaje interpretado y java uno compilado, podia hasta equivocarme y el programa seguiria abriendo, en cambio en java un error y no abre, además que debes de especificar el tipo de dato usado en las operaciones, otra diferencia seria que python era bastante más exigente con el sangrado, cosa que en java no ocurre.

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int revisionesPendientes;

    Vehiculo(String patente, String marca, int revisionesPendientes){
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

    public int getRevisionesPendientes(){
        return this.revisionesPendientes;
    }

    public void setRevisionesPendientes(int revisionesPendientes){
        if (revisionesPendientes < 0){
            System.out.println("La cantidad de revisiones pendientes no puede ser menor a 0.");
        }
        else{
            this.revisionesPendientes = revisionesPendientes;
        }

        
    }

    public abstract int calcularCostoRevision();

    public String mostrarInfo(){
        return "El vehiculo de patente " + this.getPatente() + " y de marca " + this.getMarca() + " actualmente tiene: " + this.getRevisionesPendientes() + " revisiones pendientes" ;
    }
}   
