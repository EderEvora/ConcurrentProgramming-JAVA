public class Main {
    public static void main(String[] args) {
        Mensagem mensagem = new Mensagem(
                "Yoo, Elvin",
                "Firmeza?"
        );

        Thread t1 = new Thread(new ChatNotifier("Utilizador 1", 1000, mensagem));
        Thread t2 = new Thread(new ChatNotifier("Utilizador 2", 2000, mensagem));
        Thread t3 = new Thread(new ChatNotifier("Utilizador 3", 3000, mensagem));


        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\nTodas as notificações enviadas!");
    }
}