public class Computador implements Runnable {

    private int id;
    private final Object lock;
    private volatile boolean ativo = true;

    public Computador(int id, Object lock) {
        this.id = id;
        this.lock = lock;
    }

    public void encerrar() {
        ativo = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void run() {

        while (ativo) {
            try {
                // Simula operação
                System.out.println("Computador " + id + " está operando...");
                Thread.sleep(2000);

                // Entra em WAITING
                synchronized (lock) {
                    System.out.println("Computador " + id + " aguardando liberação para o próximo ciclo.");
                    lock.wait();
                }

            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("Computador " + id + " foi encerrada.");
    }
}
