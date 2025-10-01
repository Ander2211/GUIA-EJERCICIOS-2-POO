package com.ejercicios.jdbc.Ejercicio_2;

public class Rectangulo {
    int ancho;
    int altura;

    public int getancho() {
        return ancho;
    }

    public void setancho(int ancho) {
        this.ancho = ancho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Rectangulo(int altura, int ancho) {
        this.altura = altura;
        this.ancho = ancho;
    }

    public int calcularArea(int altura, int ancho) {
        return ancho * altura;
    }

    public int calcularPerimetro(int altura, int ancho) {
        return 2 * (ancho + altura);
    }

}



