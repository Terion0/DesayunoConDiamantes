import Tareas.TareaRunnable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DesayunoRunnable {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            System.out.println("Me levanto de la cama y empiezo a preparar el desayuno...");
            long inicio = System.currentTimeMillis();
            TareaRunnable desayunoTostadas = new TareaRunnable("Preparar Tostada", 3);
            TareaRunnable desayunoLeche = new TareaRunnable("Calentar leche", 1);
            TareaRunnable desayunoHuevos = new TareaRunnable("Cocer huevos", 2);
            executor.execute(desayunoTostadas);
            executor.execute(desayunoLeche);
            executor.execute(desayunoHuevos);
            executor.awaitTermination(1, TimeUnit.MINUTES);
            long total = (System.currentTimeMillis() - inicio) / 1000;
            System.out.println("Me pongo a desayunar tras " + total + " segundos.");
        } catch (Exception e) {
            System.out.println("Fin");
            e.getMessage();

            executor.shutdownNow();
        }
        finally {
            executor.shutdown();
        }
    }
}
