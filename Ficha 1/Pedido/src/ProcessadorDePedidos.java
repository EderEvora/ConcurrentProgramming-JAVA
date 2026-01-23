import java.util.Random;

public class ProcessadorDePedidos implements Runnable {

    private Pedido pedido;

    public ProcessadorDePedidos(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try{
            while (true) {
                System.out.println(" " + (char) ('a' + new Random().nextInt(2) ));
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("\n" + Thread.currentThread().getName() + " Thread Interrupted. ");
            System.out.println(" Interrupted FLAG: " + Thread.currentThread().isInterrupted());
        }
        System.out.println(" Thread" + Thread.currentThread().getName() + "is DONE!");

    }
}
