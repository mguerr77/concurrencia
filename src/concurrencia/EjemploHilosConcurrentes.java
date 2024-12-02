package concurrencia;

public class EjemploHilosConcurrentes {

    public static void main(String[] args) {

        // Crear dos hilos
        Thread hilo1 = new Thread(new Hilo("Hilo 1"));
        Thread hilo2 = new Thread(new Hilo("Hilo 2"));

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
    }

    // Clase que implementa la interfaz Runnable para definir la tarea del hilo
    static class Hilo implements Runnable {
        private String nombre;

        public Hilo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                System.out.println(nombre + ": Ejecutando tarea " + i);
                try {
                    // Simular tiempo de ejecución variable
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nombre + ": Finalizado");
        }
    }
}