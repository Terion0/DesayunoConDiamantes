package Tareas;

import java.util.Random;

public class TareaRunnable implements  Runnable {
    public void run(String tarea, int cantidad, Random tiempo)
    {
        int tiempoTotal=0;
        int tiempoTarea=0;
        for (int i=0;i<cantidad;i++)
        {
            System.out.println("Tarea en curso: " + tarea);
            try {
              tiempoTarea = tiempo.nextInt(10) + 1;
              Thread.sleep((tiempoTarea * 1000));
              System.out.println(tarea + " Terminada en " + tiempo + " segundos ");
              tiempoTotal += tiempoTarea;
            } catch (InterruptedException e) {System.out.println("Error de ejecución de"+ tarea);}
        }
        System.out.println("En hacer "+cantidad+" "+tarea+" se tarda "+tiempoTotal+ "segundos."  );
    }



    @Override
    public void run() {

    }
}
