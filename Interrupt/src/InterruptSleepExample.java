public class InterruptSleepExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RandomLetters() {});
        t1.start();

        t1.interrupt();
        System.out.println("\nThread" + Thread.currentThread().getName() + " is Done! ");
    }
}