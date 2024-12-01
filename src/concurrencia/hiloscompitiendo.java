package concurrencia;

import java.util.Scanner;

public class hiloscompitiendo {

    private static String valorCompartido = null;

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new HiloEntrada("Hilo 1"));
        Thread hilo2 = new Thread(new HiloEntrada("Hilo 2"));

        hilo1.start();
        hilo2.start();
    }

    static class HiloEntrada implements Runnable {
        private String nombre;
        private Scanner scanner;

        public HiloEntrada(String nombre) {
            this.nombre = nombre;
            this.scanner = new Scanner(System.in);
        }

        @Override
        public void run() {
            while (valorCompartido == null) {
                synchronized (HiloEntrada.class) {
                    System.out.print(nombre + ": Introduce un valor: ");
                    String valor = scanner.nextLine();
                    valorCompartido = valor;
                }
            }
            System.out.println(nombre + ": El valor introducido es " + valorCompartido);
        }
    }
}