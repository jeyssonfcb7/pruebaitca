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
public class Computadora {
    
    private int id;
    private String marca;
    private String procesador;
    private int memoria;
    private String disco;
    private int memoria_video;
    private String descripcion;

    public Computadora() {
    }

    public Computadora(int id, String marca, String procesador, int memoria, String disco, int memoria_video, String descripcion) {
        this.id = id;
        this.marca = marca;
        this.procesador = procesador;
        this.memoria = memoria;
        this.disco = disco;
        this.memoria_video = memoria_video;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public int getMemoria_video() {
        return memoria_video;
    }

    public void setMemoria_video(int memoria_video) {
        this.memoria_video = memoria_video;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
