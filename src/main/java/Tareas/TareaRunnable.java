package Tareas;

import java.util.Random;

/**
 * La clase TareaRunnable representa una tarea que se puede ejecutar de forma concurrente.
 * Implementa la interfaz Runnable.
 */
public class TareaRunnable implements Runnable {
    private String tarea;
    private int cantidad;
    private Random Rand = new Random();

    /**
     * Constructor de la clase TareaRunnable.
     *
     * @param tarea    El nombre de la tarea.
     * @param cantidad La cantidad de veces que se ejecutará la tarea.
     */
    public TareaRunnable(String tarea, int cantidad) {
        this.tarea = tarea;
        this.cantidad = cantidad;
    }

    /**
     * Método que ejecuta la tarea.
     * Imprime el progreso y el tiempo total de ejecución.
     */
    @Override
    public void run() {
        int tiempoTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            try {
                int tiempoTarea = 0;
                System.out.println("Tarea en curso: " + tarea);
                tiempoTarea = Rand.nextInt(10) + 1;
                if (tiempoTarea < 5) {
                    throw new RuntimeException("Error " + tarea);
                }
                Thread.sleep(tiempoTarea * 1000);
                System.out.println(tarea + " Terminada en " + tiempoTarea + " segundos ");
                tiempoTotal += tiempoTarea;
            } catch (Exception e) {
                throw new RuntimeException("Error de " + tarea);
            }
        }
        System.out.println("En " + tarea + " se tarda " + tiempoTotal + " segundos.");
    }
}
