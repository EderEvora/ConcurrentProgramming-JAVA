public class ChatNotifier implements Runnable {

    private String utilizador;
    private int intervalo;
    private Mensagem mensagem;

    public ChatNotifier(String utilizador, int intervalo, Mensagem mensagem) {
        this.utilizador = utilizador;
        this.intervalo = intervalo;
        this.mensagem = mensagem;
    }

    @Override
    public void run() {
        try {
            System.out.println("Notifier iniciando..." + utilizador + " (intervalo: " + intervalo + " ms ");

            Thread.sleep(intervalo);

            System.out.println(" Notificação ao "+ utilizador + ": Nova mensagem: " + mensagem);

        } catch (InterruptedException e) {

            System.out.println("Notifier interrompido..." + utilizador);

        }

    }
}
