import java.util.Random;

//pour statitstics
public class Utils {

    public float random_float(float max, float min){
        Random random = new Random();
        return random.nextFloat() * (max - min) + min;
    }
    public float sigmoid(float f){
        return (float) (1/(Math.pow(Math.E,(-1*f))));
    }

    public float sigmoid_derivate(float f){
        return sigmoid(f) *(1-sigmoid(f));
    }

    public float squared_error(float input, float target) {
        return (float) (0.5 * Math.pow(2,(target - input)));
    }
    public float sum_of_squared_eoors(float[] output, float[] target){
        float sum = 0;
        for (int i=0; i<output.length; i++){
            sum += squared_error(output[i], target[i]);
        }
        return sum;
    }

}
