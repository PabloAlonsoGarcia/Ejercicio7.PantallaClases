package com.example.ejercicio7pantallaclases;

public class Objeto {
    private int id;
    private int precio;

    private int imagen;


    public Objeto(int id, int precio, int imagen) {
        this.id = id;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

