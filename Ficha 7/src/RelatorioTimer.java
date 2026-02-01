import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class RelatorioTimer extends TimerTask {

    private final Timer timer;
    private final long inicio;
    private final ProcessadorDeRelatorios processador = new ProcessadorDeRelatorios();

    private final AtomicInteger contadorDisparos = new AtomicInteger(0);

    public RelatorioTimer(Timer timer) {
        this.timer = timer;
        this.inicio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        long agora = System.currentTimeMillis();
        long decorrido = agora - inicio;
        if (decorrido >= 20_000) {
            timer.cancel();
            System.out.println("Agendamento de relatórios encerrado.");
            return;
        }

        int disparo = contadorDisparos.incrementAndGet();
        if (disparo == 3) {
            Thread tErro = new Thread(() -> {
                Relatorio r = processador.processarRelatorio();
                System.out.println("Relatório processado: " + r);
            });
            tErro.start();
            return;
        }

        int userId = (disparo % 2 == 0) ? 2 : 1;
        String preferencia = (userId == 1) ? "propinas" : "matrículas";

        Thread t = new Thread(() -> {
            try {
                ProcessadorDeRelatorios.configurarUsuario(userId, preferencia);
                Relatorio r = processador.processarRelatorio();
                System.out.println("Relatório processado: " + r);
            } finally {
                ProcessadorDeRelatorios.limparConfiguracao();
            }
        });

        t.start();
    }
}
