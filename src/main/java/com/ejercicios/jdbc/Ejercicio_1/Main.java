package com.ejercicios.jdbc.Ejercicio_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear lista de estudiantes
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // Registrar 3 estudiantes
        estudiantes.add(new Estudiante("Juan Pérez", "C001", "Ingeniería en Computación", 7.5, 8.0, 6.5));
        estudiantes.add(new Estudiante("María López", "C002", "Ingeniería Industrial", 5.0, 4.5, 6.0));
        estudiantes.add(new Estudiante("Carlos Gómez", "C003", "Arquitectura", 9.0, 8.5, 9.5));
        estudiantes.add(new Estudiante("Andrea Anahi", "C004", "Diseño", 2.0, 1.5, 4.5));

        // Mostrar información de cada estudiante
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
        }
    }
}