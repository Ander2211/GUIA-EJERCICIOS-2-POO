package com.ejercicios.jdbc.Ejercicio_5;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCine {
    private ArrayList<Pelicula> peliculas = new ArrayList<>();
    private ArrayList<Sala> salas = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaCine sistema = new SistemaCine();
        sistema.mostrarMenu();
    }

    private void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Sistema de Reservas de Cine ---");
            System.out.println("1. Agregar película");
            System.out.println("2. Agregar sala");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Mostrar reservas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarPelicula();
                case 2 -> agregarSala();
                case 3 -> realizarReserva();
                case 4 -> cancelarReserva();
                case 5 -> mostrarReservas();
                case 6 -> { System.out.println("¡Hasta pronto!"); return; }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void agregarPelicula() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Duración (min): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        peliculas.add(new Pelicula(codigo, titulo, genero, duracion));
        System.out.println("Película agregada exitosamente");
    }

    private void agregarSala() {
        System.out.print("Número de sala: ");
        int numero = scanner.nextInt();
        System.out.print("Capacidad total: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        salas.add(new Sala(numero, capacidad));
        System.out.println("Sala agregada exitosamente");
    }

    private void realizarReserva() {
        if (peliculas.isEmpty() || salas.isEmpty()) {
            System.out.println("Debe agregar películas y salas primero");
            return;
        }

        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine();

        System.out.println("Películas disponibles:");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + ". " + peliculas.get(i).getTitulo());
        }
        System.out.print("Seleccione una película: ");
        int idxPelicula = scanner.nextInt() - 1;

        System.out.println("Salas disponibles:");
        for (Sala sala : salas) {
            System.out.println("Sala " + sala.getNumeroSala() +
                    " - Asientos disponibles: " + sala.getCapacidadDisponible());
        }
        System.out.print("Seleccione número de sala: ");
        int numSala = scanner.nextInt();

        System.out.print("Número de asientos: ");
        int asientos = scanner.nextInt();
        scanner.nextLine();

        Sala salaSeleccionada = salas.stream()
                .filter(s -> s.getNumeroSala() == numSala)
                .findFirst()
                .orElse(null);

        if (salaSeleccionada != null && salaSeleccionada.getCapacidadDisponible() >= asientos) {
            Reserva nuevaReserva = new Reserva(cliente, peliculas.get(idxPelicula), asientos);
            reservas.add(nuevaReserva);
            salaSeleccionada.reservarAsientos(asientos);
            System.out.println("Reserva realizada exitosamente");
        } else {
            System.out.println("No hay capacidad suficiente en la sala seleccionada");
        }
    }

    private void cancelarReserva() {
        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine();

        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getNombreCliente().equalsIgnoreCase(cliente)) {
                reservasCliente.add(r);
            }
        }

        if (reservasCliente.isEmpty()) {
            System.out.println("No se encontraron reservas para ese cliente");
            return;
        }

        System.out.println("Reservas encontradas:");
        for (int i = 0; i < reservasCliente.size(); i++) {
            System.out.println((i + 1) + ". " + reservasCliente.get(i));
        }

        System.out.print("Seleccione la reserva a cancelar: ");
        int idxReserva = scanner.nextInt() - 1;
        scanner.nextLine();

        Reserva reservaCancelar = reservasCliente.get(idxReserva);
        reservas.remove(reservaCancelar);

        // Liberar asientos en la sala
        salas.stream()
                .filter(s -> s.getNumeroSala() ==
                        salas.stream()
                                .filter(sala -> sala.getCapacidadDisponible() <=
                                        sala.getCapacidadTotal() - reservaCancelar.getNumeroAsientos())
                                .findFirst()
                                .get()
                                .getNumeroSala())
                .findFirst()
                .ifPresent(s -> s.cancelarReserva(reservaCancelar.getNumeroAsientos()));

        System.out.println("Reserva cancelada exitosamente");
    }

    private void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas");
            return;
        }

        System.out.println("\n--- Listado de Reservas ---");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}