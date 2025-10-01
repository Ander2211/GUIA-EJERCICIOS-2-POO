package com.ejercicios.jdbc.Ejercicio_4;


public class Main {
    public static void main(String[] args) {
        // Crear 2 autos
        Auto auto1 = new Auto("Toyota", "Corolla", 2020, 4);
        Auto auto2 = new Auto("Honda", "Civic", 2021, 2);
        Auto auto3 = new Auto("Kia", "Rio", 2019, 4);


        // Crear 2 motos
        Moto moto1 = new Moto("Yamaha", "MT-07", 2019, 689);
        Moto moto2 = new Moto("Kawasaki", "Ninja", 2022, 998);
        Moto moto3 = new Moto("Kawasaki", "Equis", 2025, 800);


        // Mostrar información de los objetos
        System.out.println("--------- Autos ---------");
        auto1.mostrarInfo();
        System.out.println();
        auto2.mostrarInfo();
        auto3.mostrarInfo();

        System.out.println("\n--------- Motos ---------");
        moto1.mostrarInfo();
        System.out.println();
        moto2.mostrarInfo();
        moto3.mostrarInfo();
    }
}
