package com.ejercicios.jdbc.Ejercicio_4;


// Clase base Vehiculo
class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;

    // Constructor
    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
}

// Clase Auto que hereda de Vehiculo
class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String marca, String modelo, int año, int numeroPuertas) {
        super(marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numeroPuertas);
    }
}

// Clase Moto que hereda de Vehiculo
class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String marca, String modelo, int año, int cilindraje) {
        super(marca, modelo, año);
        this.cilindraje = cilindraje;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cilindraje: " + cilindraje + " cc");
    }
}