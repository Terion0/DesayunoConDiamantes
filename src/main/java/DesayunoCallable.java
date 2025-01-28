import java.util.Random;
import java.util.concurrent.Callable;

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
