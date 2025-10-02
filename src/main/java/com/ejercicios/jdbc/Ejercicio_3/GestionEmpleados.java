package com.ejercicios.jdbc.Ejercicio_3;

import javax.swing.*;
import java.util.ArrayList;

public class GestionEmpleados {
    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú de Gestión de Empleados:\n" +
                            "1. Agregar empleado\n" +
                            "2. Listar empleados\n" +
                            "3. Buscar empleado por ID\n" +
                            "4. Eliminar empleado\n" +
                            "5. Salir\n\n" +
                            "Seleccione una opción:"
            );

            if (opcion == null) break; // Si se presiona Cancelar

            switch (opcion) {
                case "1": agregarEmpleado(); break;
                case "2": listarEmpleados(); break;
                case "3": buscarEmpleado(); break;
                case "4": eliminarEmpleado(); break;
                case "5": System.exit(0);
                default: JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void agregarEmpleado() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado:"));

            // Verificar si el ID ya existe
            for (Empleado emp : empleados) {
                if (emp.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Error: El ID ya existe.");
                    return;
                }
            }

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String puesto = JOptionPane.showInputDialog("Ingrese el puesto:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario:"));

            empleados.add(new Empleado(id, nombre, puesto, salario));
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Formato numérico inválido.");
        }
    }

    private static void listarEmpleados() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder("Lista de Empleados:\n");
        for (Empleado emp : empleados) {
            lista.append(emp.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void buscarEmpleado() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID a buscar:"));
            for (Empleado emp : empleados) {
                if (emp.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" + emp);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Empleado con ID " + id + " no encontrado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un ID válido.");
        }
    }

    private static void eliminarEmpleado() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado a eliminar:"));
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).getId() == id) {
                    empleados.remove(i);
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Empleado con ID " + id + " no encontrado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un ID válido.");
        }
    }
}