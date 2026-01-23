public class Main {

    public static void main(String[] args) {

        GestorCentroEstagiario gestor = new GestorCentroEstagiario(3);

        gestor.iniciar();

        long inicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - inicio < 15000) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }

            gestor.monitorarEstados();
            gestor.liberarProximoCiclo();
            System.out.println();
        }

        gestor.encerrarCentro();
        gestor.aguardarFinalizacao();

        gestor.monitorarEstados();
        System.out.println("Centro de estágio da UM encerrado.");
    }
}
