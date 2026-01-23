import java.io.BufferedReader;
import java.io.FileReader;

public class Produtor implements Runnable {

    private String ficheiro;
    private BufferCompartilhado buffer;
    private RegistroPesquisa registro;

    public Produtor(String ficheiro, BufferCompartilhado buffer, RegistroPesquisa registro) {
        this.ficheiro = ficheiro;
        this.buffer = buffer;
        this.registro = registro;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))) {

            String linha;
            int contador = 0;

            while ((linha = br.readLine()) != null && !registro.isEncontrado()) {
                contador++;
                buffer.produzir(new LinhaDocente(linha, ficheiro, contador));
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler ficheiro: " + ficheiro);
        }
    }
}
