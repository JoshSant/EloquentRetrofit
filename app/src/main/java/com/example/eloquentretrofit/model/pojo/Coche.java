package com.example.eloquentretrofit.model.pojo;

public class Coche {

    private long id;
    private int caballos;
    private String marca, modelo, matricula, imagen;

    public Coche(String matricula, String marca, String modelo, String imagen, int caballos) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
        this.caballos = caballos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return marca + '\n' + modelo;
    }
}
