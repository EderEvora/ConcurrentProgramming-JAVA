import java.util.HashMap;
import java.util.Map;

public class RegistroDeNotas {

    private Map<Integer, Double> medias = new HashMap<>();

    private Map<Integer, Double> somaNotas = new HashMap<>();
    private Map<Integer, Integer> totalNotas = new HashMap<>();

    public synchronized void atualizarMedia(int id, double novaNota) {

        double somaAtual = somaNotas.getOrDefault(id, 0.0);
        int quantidadeAtual = totalNotas.getOrDefault(id, 0);

        somaAtual += novaNota;
        quantidadeAtual++;

        somaNotas.put(id, somaAtual);
        totalNotas.put(id, quantidadeAtual);

        double media = somaAtual / quantidadeAtual;
        medias.put(id, media);
    }

    public Map<Integer, Double> getMedias() {
        return medias;
    }
}
