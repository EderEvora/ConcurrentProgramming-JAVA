public class Main {

    public static void main(String[] args) {

        RegistroDeNotas registro = new RegistroDeNotas();

        Thread t1 = new Thread(new ProcessadorDeNotas("notas1.txt", registro));
        Thread t2 = new Thread(new ProcessadorDeNotas("notas2.txt", registro));
        Thread t3 = new Thread(new ProcessadorDeNotas("notas3.txt", registro));

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread principal interrompida.");
        }

        System.out.println("\n>>> Interrompendo processamento...\n");
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Erro ao aguardar threads.");
        }

        System.out.println("\nMÉDIAS FINAIS DOS ALUNOS:");
        registro.getMedias().forEach((id, media) ->
                System.out.println("Aluno ID " + id + " -> Média: " + String.format("%.2f", media))
        );
    }
}
