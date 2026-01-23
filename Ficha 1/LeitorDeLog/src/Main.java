import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> linhasProcessadas = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(new LeitorDeLog("log1.txt", linhasProcessadas), "Leitor-1");
        Thread t2 = new Thread(new LeitorDeLog("log2.txt", linhasProcessadas), "Leitor-2");
        Thread t3 = new Thread(new LeitorDeLog("log3.txt", linhasProcessadas), "Leitor-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n===============================");
        System.out.println("Total de linhas lidas: " + linhasProcessadas.size());
        System.out.println("===============================");
    }
}
