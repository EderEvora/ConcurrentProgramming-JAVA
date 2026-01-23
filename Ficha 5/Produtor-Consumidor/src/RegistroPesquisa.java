public class RegistroPesquisa {

    private volatile boolean encontrado = false;
    private String nomeFicheiro;
    private int linha;

    public synchronized void registrarEncontrado(String ficheiro, int linha) {
        if (!encontrado) {
            this.encontrado = true;
            this.nomeFicheiro = ficheiro;
            this.linha = linha;
        }
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public String getNomeFicheiro() {
        return nomeFicheiro;
    }

    public int getLinha() {
        return linha;
    }
}
