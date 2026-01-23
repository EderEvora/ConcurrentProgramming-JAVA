import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeitorDeLog implements Runnable {

    private String caminho;
    private List<String> listaPartilhada;

    public LeitorDeLog(String caminho, List<String> listaPartilhada) {
        this.caminho = caminho;
        this.listaPartilhada = listaPartilhada;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                synchronized (listaPartilhada) {
                    listaPartilhada.add(linha);
                }
                System.out.println(Thread.currentThread().getName() + " leu: " + linha);

                Thread.sleep(100);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
