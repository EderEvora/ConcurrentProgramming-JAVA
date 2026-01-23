public class Estoque {
    private volatile int quantidade;

    public Estoque(int quantidade) {
        this.quantidade = quantidade;
    }

    public synchronized boolean comprarProduto() {
        if (quantidade > 0) {
            quantidade--;
            return true;
        }
        return false;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
