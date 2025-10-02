package com.ejercicios.jdbc.Ejercicio_2;
import com.ejercicios.jdbc.Ejercicio_2.Rectangulo;

public class Main {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(4, 20);
        System.out.println("El area del rectangulo es: " + rectangulo.calcularArea(rectangulo.getAltura(), rectangulo.getancho()));
        System.out.println("El perimetro del rectangulo es: " + rectangulo.calcularPerimetro(rectangulo.getAltura(), rectangulo.getancho()));
    }
}
