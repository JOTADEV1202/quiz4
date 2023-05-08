package controller;

import model.Task;
import view.ConsoleView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskController {
    private ArrayList<Task> tareas;
    private ConsoleView view;

    public TaskController() {
        tareas = new ArrayList<Task>();
        view = new ConsoleView();
    }

    public void run() {
        while (true) {
            view.mostrarMenu();
            String choice = view.getInput("Selecciona una opción: ");
            try {
                switch (choice) {
                    case "1":
                        createTask();
                        break;
                    case "2":
                        readTasks();
                        break;
                    case "3":
                        updateTask();
                        break;
                    case "4":
                        deleteTask();
                        break;
                    case "5":
                        return;
                    default:
                        throw new IllegalArgumentException("Opción no válida");
                }
            } catch (Exception e) {
                view.mostrarError(e.getMessage());
            }
        }
    }

    private void createTask() {

        String taskName = view.getInput("Nombre de la tarea: ");
        String taskDescription = view.getInput("Descripción de la tarea: ");
        Task newTask = new Task(taskName, taskDescription);
        Task.add(newTask);
        view.showMessage("Tarea creada exitosamente");
    }

    private void readTasks() {
        if (tareas.isEmpty()) {
            view.showMessage("No hay tareas");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                Task task = tareas.get(i);
                view.showTask(i, task);
            }
        }
    }

    private void updateTask() {
        if (tareas.isEmpty()) {
            view.showMessage("No hay tareas");
        } else {
            String taskIndexStr = view.getInput("Índice de la tarea a actualizar: ");
            try {
                int taskIndex = Integer.parseInt(taskIndexStr);
                if (taskIndex < 0 || taskIndex >= tareas.size()) {
                    throw new IllegalArgumentException("Índice no válido");
                }
                Task task = tareas.get(taskIndex);
                String newTaskName = view.getInput("Nuevo nombre de la tarea (dejar en blanco para mantener el mismo): ");
                String newTaskDescription = view.getInput("Nueva descripción de la tarea (dejar en blanco para mantener la misma): ");
                if (!newTaskName.isEmpty()) {
                    task.setName(newTaskName);
                }
                if (!newTaskDescription.isEmpty()) {
                    task.setDescription(newTaskDescription);
                }
                view.showMessage("Tarea actualizada exitosamente");
            } catch (NumberFormatException e) {
                view.showError("Índice no válido");
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            }
        }
    }

    private void deleteTask() {
        if (tareas.isEmpty()) {
            view.showMessage("No hay tareas");
        } else {
            String taskIndexStr = view.getInput("Índice de la tarea a eliminar: ");
            try {
                int taskIndex = Integer.parseInt(taskIndexStr);
                if (taskIndex < 0 || taskIndex >= tareas.size()) {
                    throw new IllegalArgumentException("Índice no válido");
                }
                tareas.remove(taskIndex);
                view.showMessage("Tarea eliminada exitosamente");
            } catch (NumberFormatException e) {
                view.showError("Índice no válido");
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            }
        }
    }
}


