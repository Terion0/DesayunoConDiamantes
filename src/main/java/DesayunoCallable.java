import Tareas.TareaCallable;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.Future;

/**
 * La clase DesayunoCallable simula la preparación de un desayuno utilizando tareas concurrentes.
 */
public class DesayunoCallable {


    private static Callable<String> crearTarea(String elemento, Random random) {
        return () -> {
            int tiempo = random.nextInt(5) + 1;
            Thread.sleep(tiempo * 1000); // Simula el tiempo de preparación
            if (random.nextBoolean()) { // Simula un error aleatorio
                throw new Exception("Error preparando " + elemento);
            }
            return elemento + " listo(a) en " + tiempo + " segundos.";
        };
}
}
