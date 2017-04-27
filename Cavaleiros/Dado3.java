import java.util.Random;
public class Dado3 implements Sorteador{
    
    public int sortear(){
        Random random  = new Random();
        final int min = 1, max = 3;
        return random.nextInt(max-min +1) + min;
    }
}