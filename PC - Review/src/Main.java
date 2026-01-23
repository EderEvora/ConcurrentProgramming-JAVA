public class Main {
    public static void main(String[] args) {
        RunnableHelloWorld firstThread = new RunnableHelloWorld();
        firstThread.run();
        System.out.println ("Thread Principal: " + Thread.currentThread().getName());
    }
}