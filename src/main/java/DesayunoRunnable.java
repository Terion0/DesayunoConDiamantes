import Tareas.TareaRunnable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DesayunoRunnable {
    public static void main(String[] args) throws InterruptedException {
        Random Tiempo= new Random();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("Me levanto de la cama y empiezo a preparar el desayuno...");
        long inicio = System.currentTimeMillis(); // Tiempo inicial

        // Ejecutamos las tareas de manera concurrente
        executor.execute(new TareaRunnable("Tostada", 3, Tiempo);

        executor.execute(new TareaRunnable("Tostada 3"));
        executor.execute(new TareaDesayunoRunnable("Huevo 1"));
        executor.execute(new TareaDesayunoRunnable("Huevo 2"));

        executor.shutdown(); // Cerramos el grupo de hilos
        executor.awaitTermination(1, TimeUnit.MINUTES); // Esperamos a que terminen todas las tareas

        long total = (System.currentTimeMillis() - inicio) / 1000; // Calculamos el tiempo total
        System.out.println("Me pongo a desayunar tras " + total + " segundos.");
    }
