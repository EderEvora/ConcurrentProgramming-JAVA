public class RunnableHelloWorld implements Runnable {
        @Override
        public void run() {
                System.out.println("Hello World Paralelo");
                System.out.println("Eu sou o thread: " + Thread.currentThread().getName());
                RunnableHelloWorld firstThread = new RunnableHelloWorld();
    }
}

