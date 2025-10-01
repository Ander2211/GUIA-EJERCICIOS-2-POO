package com.ejercicios.jdbc.Ejercicio_5;

import java.util.ArrayList;
import java.util.Scanner;

class Pelicula {
    private String codigo;
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(String codigo, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}

class Sala {
    private int numeroSala;
    private int capacidadTotal;
    private int capacidadDisponible;

    public Sala(int numeroSala, int capacidadTotal) {
        this.numeroSala = numeroSala;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    // Getters
    public int getNumeroSala() { return numeroSala; }
    public int getCapacidadTotal() { return capacidadTotal; }
    public int getCapacidadDisponible() { return capacidadDisponible; }

    public void reservarAsientos(int asientos) {
        capacidadDisponible -= asientos;
    }

    public void cancelarReserva(int asientos) {
        capacidadDisponible += asientos;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numeroSala=" + numeroSala +
                ", capacidadTotal=" + capacidadTotal +
                ", capacidadDisponible=" + capacidadDisponible +
                '}';
    }
}

class Reserva {
    private String nombreCliente;
    private Pelicula pelicula;
    private int numeroAsientos;

    public Reserva(String nombreCliente, Pelicula pelicula, int numeroAsientos) {
        this.nombreCliente = nombreCliente;
        this.pelicula = pelicula;
        this.numeroAsientos = numeroAsientos;
    }

    // Getters
    public String getNombreCliente() { return nombreCliente; }
    public Pelicula getPelicula() { return pelicula; }
    public int getNumeroAsientos() { return numeroAsientos; }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", pelicula=" + pelicula.getTitulo() +
                ", numeroAsientos=" + numeroAsientos +
                '}';
    }
}

