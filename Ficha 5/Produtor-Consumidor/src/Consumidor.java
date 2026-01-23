public class Consumidor implements Runnable {

    private String nomeProcurado;
    private BufferCompartilhado buffer;
    private RegistroPesquisa registro;

    public Consumidor(String nomeProcurado, BufferCompartilhado buffer, RegistroPesquisa registro) {
        this.nomeProcurado = nomeProcurado;
        this.buffer = buffer;
        this.registro = registro;
    }

    @Override
    public void run() {
        try {
            while (!registro.isEncontrado()) {

                LinhaDocente linha = buffer.consumir();
                if (linha == null) return;

                if (linha.nome.equalsIgnoreCase(nomeProcurado)) {
                    registro.registrarEncontrado(linha.ficheiro, linha.numeroLinha);
                    System.out.println("\n>>> NOME ENCONTRADO!");
                    return;
                }
            }
        } catch (InterruptedException e) {
            // Finalização controlada
        }
    }
}
