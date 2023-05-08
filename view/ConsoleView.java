package view;
import model.Task;

import java.util.List;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleView  {
        private Scanner agregarTarea;


public ConsoleView() {
    this.agregarTarea = new Scanner(System.in);

 }
 public void mostrarTareas(List<Task> tareas) {
    if (tareas.isEmpty()) {

        System.out.println("No hay tareas pendientes.");

 } else {
    for (int i = 0; i < tareas.size(); i++) {

            Task tarea = tareas.get(i);

        String estado = tarea.estaCompletada() ? "completada" : "pendiente";
        System.out.println((i+1) + ". " + tarea.getTitulo() + " (" + estado + ")");
        System.out.println(" Descripción: " + tarea.getDescripcion());

         }

     }

}
 public int pedirOpcion() {

    System.out.print("Ingrese el número de tarea que desea marcar como completada (o 0 para salir): ");
        return agregarTarea.nextInt();

 }
public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
        }

    public void mostrarMenu() {
    }

    public String getInput(String s) {

    return s;
    
    }

    public void mostrarError(String message) {
    }
    
    public void showMessage(String tareaActualizadaExitosamente) {
    }

    public void showError(String índiceNoVálido) {
    }

    public void showTask(int i, Task task) {
    }
}

