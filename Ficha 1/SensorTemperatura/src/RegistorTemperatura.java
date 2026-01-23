import java.util.List;

public class RegistorTemperatura implements Runnable {

    private SensorTemperatura sensor;
    private List<Integer> leituras;

    public RegistorTemperatura(SensorTemperatura sensor, List<Integer> leituras) {
        this.sensor = sensor;
        this.leituras = leituras;
    }
    @Override
    public void run() {
        long inicio = System.currentTimeMillis();

        try{
            while(!Thread.currentThread().isInterrupted()) {

                int temp = sensor.LerTemperatura();
                leituras.add(temp);
                System.out.println("Temperatura lida: " + temp + " Celsius");

                if (temp > 30) {
                    System.out.println(" Alerta: Temperatura excedeu os 30ºC");
                    Thread.currentThread().interrupt();
                    break;

                }

                Thread.sleep(1000);

                if (System.currentTimeMillis() - inicio >= 15000) {
                    System.out.println("15 segumdos concluidos. Encerrando registor...");
                    break;
                }
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }  {
            System.out.println("Thread interrupted");
        }
    }
}
