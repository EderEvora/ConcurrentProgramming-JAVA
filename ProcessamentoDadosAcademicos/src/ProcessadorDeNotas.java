public class ProcessadorDeNotas implements Runnable {

        private String nomeArquivo;
        private RegistroDeNotas registro;

        public ProcessadorDeNotas(String nomeArquivo, RegistroDeNotas registro) {
            this.nomeArquivo = nomeArquivo;
            this.registro = registro;
        }

        @Override
        public void run() {
            System.out.println("Iniciando processamento do arquivo: " + nomeArquivo);

            String[] linhas = {
                    "ID: 1, Nome: Ana, Disciplina: Matemática, Nota: 14",
                    "ID: 2, Nome: Bruno, Disciplina: Física, Nota: 12",
                    "ID: 1, Nome: Ana, Disciplina: Programação, Nota: 16",
                    "ID: 3, Nome: Carla, Disciplina: Redes, Nota: 15"
            };

            for (String linha : linhas) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread do arquivo " + nomeArquivo + " foi interrompida.");
                    return;
                }

                try {

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupção durante o processamento de " + nomeArquivo);
                    Thread.currentThread().interrupt();
                    return;
                }

                int id = Integer.parseInt(linha.split(",")[0].split(":")[1].trim());
                double nota = Double.parseDouble(linha.split(",")[3].split(":")[1].trim());

                registro.atualizarMedia(id, nota);

                System.out.println("Arquivo " + nomeArquivo + " processou: " + linha);
            }

            System.out.println("Finalizado processamento do arquivo: " + nomeArquivo);
        }
}
