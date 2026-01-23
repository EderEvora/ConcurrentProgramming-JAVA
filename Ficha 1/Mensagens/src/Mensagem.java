public class Mensagem {

    private String remetente;
    private String destinatario;
    private String texto;

    public Mensagem(String remetente, String destinatario) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "[" + remetente + ", " + destinatario + ", " + texto + "]";
    }
}
