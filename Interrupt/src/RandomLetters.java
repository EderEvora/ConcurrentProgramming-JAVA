import java.util.Random;

public class RandomLetters implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                System.out.print(" " + (char) ('A' + new Random().nextInt(26)));
                Thread.sleep(200);
            }
        }catch(InterruptedException e){
            System.out.println("\n" + Thread.currentThread().getName() + " Interrupted. ");
            System.out.println("INTERRUPTED flag: " + Thread.currentThread().isInterrupted());
        }
        System.out.println("Thread" + Thread.currentThread().getName() + " is Done! ");
    }
}
