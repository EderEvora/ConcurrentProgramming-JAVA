public class Pedido {
    private int id;
    private String cliente;
    private double valor;

    public Pedido(int id, String cliente, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public int getId() {return id;}

    public String getClient() {return cliente;}

    public double getValor() {return valor;}
}

