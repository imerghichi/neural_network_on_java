import java.util.Random;

//pour statitstics
public class Utils {

    public float random_float(float max, float min){
        Random random = new Random();
        return random.nextFloat() * (max - min) + min;
    }
    public float sigmoid(float f){
        return f;
    }
}
