import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            System.out.println("Exceção capturada no thread " + thread.getName() + ": " + ex.getMessage());
        });

        Timer timer = new Timer("Relatorio-Scheduler");
        RelatorioTimer task = new RelatorioTimer(timer);

        timer.scheduleAtFixedRate(task, 0, 5_000);
    }
}
