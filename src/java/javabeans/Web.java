/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author deniss
 */
public class Web {
    
    int id;
    String fecha_inserccion;
    String direccion_website;
    String nombre_website;
    String categoria;
    String subcategoria;
    int puntuacion;
    String idioma;

    public Web() {
    }

    public Web(int id, String fecha_inserccion, String direccion_website, String nombre_website, String categoria, String subcategoria, int puntuacion, String idioma) {
        this.id = id;
        this.fecha_inserccion = fecha_inserccion;
        this.direccion_website = direccion_website;
        this.nombre_website = nombre_website;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.puntuacion = puntuacion;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inserccion() {
        return fecha_inserccion;
    }

    public void setFecha_inserccion(String fecha_inserccion) {
        this.fecha_inserccion = fecha_inserccion;
    }

    public String getDireccion_website() {
        return direccion_website;
    }

    public void setDireccion_website(String direccion_website) {
        this.direccion_website = direccion_website;
    }

    public String getNombre_website() {
        return nombre_website;
    }

    public void setNombre_website(String nombre_website) {
        this.nombre_website = nombre_website;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
}
