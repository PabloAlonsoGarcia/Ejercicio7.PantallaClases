package com.example.ejercicio7pantallaclases;

public class Personaje {

    private String nombre;
    private String raza;
    private String clase;
    private int fuerza;
    private int defensa;
    private int mochila;
    private int vida;
    private int monedero;

    public Personaje(String nombre, String raza, String clase, int fuerza, int defensa, int mochila, int vida, int monedero) {

        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.mochila = mochila;
        this.vida = vida;
        this.monedero = monedero;
    }

    public Personaje() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getMochila() {
        return mochila;
    }

    public void setMochila(int mochila) {
        this.mochila = mochila;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMonedero() {
        return monedero;
    }

    public void setMonedero(int monedero) {
        this.monedero = monedero;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", clase='" + clase + '\'' +
                ", fuerza=" + fuerza +
                ", defensa=" + defensa +
                ", mochila=" + mochila +
                ", vida=" + vida +
                ", monedero=" + monedero +
                '}';
    }
}
