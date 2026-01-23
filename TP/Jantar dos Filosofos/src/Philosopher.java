import java.util.concurrent.Semaphore;
import java.util.Random;

public class Philosopher extends Thread {

    private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;
    private Semaphore room;
    private Random random = new Random();

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork, Semaphore room) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.room = room;
    }

    private void think() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep(random.nextInt(1000) + 500);
    }

    private void eat() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep(random.nextInt(1000) + 500);
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                room.acquire();

                leftFork.acquire();
                System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");

                rightFork.acquire();
                System.out.println("Filósofo " + id + " pegou o garfo direito.");

                eat();

                rightFork.release();
                leftFork.release();
                room.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
