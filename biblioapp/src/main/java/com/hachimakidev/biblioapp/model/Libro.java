package com.hachimakidev.biblioapp.model;

public class Libro extends Material{
    String autor;
    int paginas;

    

    public Libro(int id, String titulo, String fecha_publicacion, boolean esta_disponible, String autor, int paginas) {
        super(id, titulo, fecha_publicacion, esta_disponible);
        this.autor = autor;
        this.paginas = paginas;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }


}
