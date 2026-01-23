import java.util.LinkedList;
import java.util.Queue;

public class BufferCompartilhado {

    private Queue<LinhaDocente> buffer = new LinkedList<>();
    private int capacidade = 20;
    private RegistroPesquisa registro;

    public BufferCompartilhado(RegistroPesquisa registro) {
        this.registro = registro;
    }

    public synchronized void produzir(LinhaDocente linha) throws InterruptedException {
        while (buffer.size() == capacidade && !registro.isEncontrado()) {
            wait();
        }

        if (registro.isEncontrado()) return;

        buffer.add(linha);
        notifyAll();
    }

    public synchronized LinhaDocente consumir() throws InterruptedException {
        while (buffer.isEmpty() && !registro.isEncontrado()) {
            wait();
        }

        if (registro.isEncontrado()) return null;

        LinhaDocente linha = buffer.poll();
        notifyAll();
        return linha;
    }
}
