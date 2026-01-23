public class GestorCentroEstagiario {

    private Thread[] threads;
    private Computador[] computadores;
    private final Object lock = new Object();

    public GestorCentroEstagiario(int quantidade) {
        threads = new Thread[quantidade];
        computadores = new Computador[quantidade];

        for (int i = 0; i < quantidade; i++) {
            computadores[i] = new Computador(i + 1, lock);
            threads[i] = new Thread(computadores[i]);
        }
    }

    public void iniciar() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public void monitorarEstados() {
        for (Thread t : threads) {
            System.out.println(
                    "Estado de computador " + t.getName() + ": " + t.getState()
            );
        }
    }

    public void liberarProximoCiclo() {
        synchronized (lock) {
            System.out.println("Liberando computadores para o próximo ciclo...");
            lock.notifyAll();
        }
    }

    public void encerrarCentro() {
        System.out.println("\nEncerrando o centro de estágio...\n");
        for (Computador c : computadores) {
            c.encerrar();
        }
    }

    public void aguardarFinalizacao() {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
