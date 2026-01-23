public class Main {
    public static void main(String[] args) {
        Pedido p1 = new Pedido(01, "Marcio" , 350 );
        Pedido p2 = new Pedido(02, "Ebson", 100);
        Pedido p3 = new Pedido(03, "Reinaldo", 500);

        Thread t1 = new Thread(new ProcessadorDePedidos(p1));
        Thread t2 = new Thread(new ProcessadorDePedidos(p2));
        Thread t3 = new Thread(new ProcessadorDePedidos(p3));

        t1.start();
        t2.start();
        t3.start();

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {}

        System.out.println( "\n = Tempo limite alcançado. Interrompendo Thread...");

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }

}