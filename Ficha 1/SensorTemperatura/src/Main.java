import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SensorTemperatura sensor = new SensorTemperatura();

        List<Integer> listaLeituras = Collections.synchronizedList(new ArrayList<Integer>());

        Thread registor = new Thread(new RegistorTemperatura(sensor, listaLeituras));
        
        registor.start();
        
        try{
            registor.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("\nLeituras registadas: " + listaLeituras);
    }
}