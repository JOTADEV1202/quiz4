package model;

import java.util.ArrayList;

public class Task {

     private String titulo;
     private String descripcion;
     private boolean completada;

public Task(String titulo, String descripcion) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.completada = false; // Por defecto, la tarea no está completada
 }

    public static void add(Task newTask) {
    }

    public String getTitulo() {
        return titulo;
 }

    public String getDescripcion() {
        return descripcion;
}

    public boolean estaCompletada() {
     return completada;
}

 public void completar() {
    this.completada = true;
}

    public void setName(String newTaskName) {
    }

    public void setDescription(String newTaskDescription) {
    }
}
