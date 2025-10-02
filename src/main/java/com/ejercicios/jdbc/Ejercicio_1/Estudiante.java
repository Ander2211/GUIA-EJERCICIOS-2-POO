package com.ejercicios.jdbc.Ejercicio_1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Estudiante {
    // Atributos privados
    private String nombreCompleto;
    private String carnet;
    private String carrera;
    private double nota1;
    private double nota2;
    private double nota3;

    // Constructor
    public Estudiante(String nombreCompleto, String carnet, String carrera, double nota1, double nota2, double nota3) {
        this.nombreCompleto = nombreCompleto;
        this.carnet = carnet;
        this.carrera = carrera;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    // Método para calcular promedio
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3;
    }

    // Método para indicar si aprueba o reprueba
    public String estado() {
        return calcularPromedio() >= 6.0 ? "Aprobado" : "Reprobado";
    }

    // Mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Carnet: " + carnet);
        System.out.println("Carrera: " + carrera);
        System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.printf("Promedio: %.2f%n", calcularPromedio());
        System.out.println("Estado: " + estado());
        System.out.println("-----------------------------");
    }
}