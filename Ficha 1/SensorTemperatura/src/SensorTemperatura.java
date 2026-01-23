import java.util.Random;

public class SensorTemperatura {
    private Random random = new Random();

    public int LerTemperatura (){
        return random.nextInt(21) + 15;
    }
}
