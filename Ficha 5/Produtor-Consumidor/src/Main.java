public class Main {

    public static void main(String[] args) {

        String nomeProcurado = "Carlos Silva";

        String[] ficheiros = {
                "docentes/ficha1.txt",
                "docentes/ficha2.txt",
                "docentes/ficha3.txt",
                "docentes/ficha4.txt",
                "docentes/ficha5.txt",
                "docentes/ficha6.txt",
                "docentes/ficha7.txt",
                "docentes/ficha8.txt",
                "docentes/ficha9.txt"
        };

        RegistroPesquisa registro = new RegistroPesquisa();
        BufferCompartilhado buffer = new BufferCompartilhado(registro);

        Thread[] produtores = new Thread[ficheiros.length];
        Thread[] consumidores = new Thread[3];

        for (int i = 0; i < ficheiros.length; i++) {
            produtores[i] = new Thread(new Produtor(ficheiros[i], buffer, registro));
            produtores[i].start();
        }

        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumidor(nomeProcurado, buffer, registro));
            consumidores[i].start();
        }

        try {
            for (Thread t : produtores) t.join();
            for (Thread t : consumidores) t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (registro.isEncontrado()) {
            System.out.println(
                    "Nome encontrado no ficheiro: " +
                            registro.getNomeFicheiro() +
                            ", na linha: " +
                            registro.getLinha()
            );
        } else {
            System.out.println("Nome não encontrado em nenhum dos ficheiros.");
        }
    }
}
