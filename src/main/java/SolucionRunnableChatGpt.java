import Tareas.TareaRunnable;

import java.util.concurrent.*;
/**
 * Esta clase representa una solución para un problema de concurrencia utilizando la interfaz Runnable.
 *
 * @author José María y Rodrigo
 * @version 1.0
 */
public class SolucionRunnableChatGpt {
    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {


    ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
        System.out.println("Me levanto de la cama y empiezo a preparar el desayuno...");
        long inicio = System.currentTimeMillis();

        // Crear tareas Runnable
        TareaRunnable desayunoTostadas = new TareaRunnable("Preparar Tostada", 3);
        TareaRunnable desayunoLeche = new TareaRunnable("Calentar leche", 1);
        TareaRunnable desayunoHuevos = new TareaRunnable("Cocer huevos", 2);

        // Enviar tareas al pool de hilos
        Future<?> futureTostadas = executor.submit(desayunoTostadas);
        Future<?> futureLeche = executor.submit(desayunoLeche);
        Future<?> futureHuevos = executor.submit(desayunoHuevos);

        // Comprobar resultados para manejar errores
        verificarFuturo(futureTostadas, executor);
        verificarFuturo(futureLeche, executor);
        verificarFuturo(futureHuevos, executor);

        executor.shutdown();
        if (!executor.awaitTermination(1,   TimeUnit.MINUTES)) {
            System.out.println("El tiempo de espera se excedió.");
            executor.shutdownNow();
        }

        long total = (System.currentTimeMillis() - inicio) / 1000;
        System.out.println("Me pongo a desayunar tras " + total + " segundos.");
    } catch (Exception e) {
        System.out.println("Error detectado: " + e.getMessage());
        executor.shutdownNow();
    }
}
    /**
     * Método que verifica el resultado de una tarea ejecutada en un hilo y maneja posibles excepciones.
     *
     * @param future El resultado de la tarea ejecutada en un hilo.
     * @param executor El ejecutor de hilos que gestionó la tarea.
     * @throws InterruptedException Si el hilo es interrumpido.
     */
private static void verificarFuturo(Future<?> future, ExecutorService executor) {
    try {
        future.get(); // Bloquea hasta que termine la tarea o lance una excepción
    } catch (ExecutionException e) {
        System.out.println("Excepción en una tarea: " + e.getCause().getMessage());
        executor.shutdownNow(); // Detener todas las tareas activas
        throw new RuntimeException("Tarea fallida, deteniendo ejecución.");
    } catch (InterruptedException e) {
        System.out.println("Hilo principal interrumpido.");
        Thread.currentThread().interrupt(); // Restaurar estado de interrupción
        executor.shutdownNow();
        throw new RuntimeException(e);
    }
}

}
