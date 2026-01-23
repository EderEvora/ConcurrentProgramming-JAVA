import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    public static void main(String[] args) {

        int numberOfPhilosophers = 5;

        Semaphore[] forks = new Semaphore[numberOfPhilosophers];
        Semaphore room = new Semaphore(numberOfPhilosophers - 1);

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % numberOfPhilosophers];

            philosophers[i] = new Philosopher(i + 1, leftFork, rightFork, room);
            philosophers[i].start();
        }
    }
}
