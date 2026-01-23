public class Cliente implements Runnable {

    private int id;
    private Estoque estoque;

    public Cliente (int id, Estoque estoque){
        this.id = id;
        this.estoque = estoque;
    }

    @Override
    public void run() {
        if(Thread.currentThread().isInterrupted()){
            System.out.println("Cliente" + id + "Interrompido");
            return;
        }
        boolean sucesso = estoque.comprarProduto();

        if (sucesso) {
            System.out.println("Cliente" + id + "comprou o produto");
        } else {
            System.out.println("Cliente" + id + "tentou comprar, mas produto fora de estoque");
        }
    }

}
