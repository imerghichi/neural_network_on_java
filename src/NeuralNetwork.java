public class NeuralNetwork {
    public static Layer[] layers;
    public static DataTraining[] dataTrainings;

    public static void main(String[] args){

        Neuron.setRangeValue(-1,1);

        layers = new Layer[3];
        layers[0] = null;//input
        layers[1] = new Layer(2,6); //medium hidden
        layers[2] = new Layer(6,1); //output

        createdatatraining();
        
        System.out.println("before training");
        for (int i = 0; i<dataTrainings.length;i++){
            forward(dataTrainings[i].getData());
            System.out.println(layers[2].getNeurons()[0].getValue());
        }
        train(1000000,0.05f);

        System.out.println("after training");
        for (int i = 0; i<dataTrainings.length;i++){
            forward(dataTrainings[i].getData());
            System.out.println(layers[2].getNeurons()[0].getValue());
        }

    }

    private static void train(int iterations, float rate) {
        for (int i = 0; i<iterations; i++){
            for(int j = 0; j<dataTrainings.length; j++){
                forward(dataTrainings[j].getData());
                backwards(rate, dataTrainings[j]);
            }
        }
    }

    private static void forward(float[] data) {
        Utils utils = new Utils();
        layers[0] = new Layer(data);
        for (int i =1; i <layers.length;i++){
            for (int j=0; j<layers[i].getNeurons().length;j++){
                float sum = 0;
                for (int k= 0; k<layers[i-1].getNeurons().length;k++){
                    sum +=layers[i-1].getNeurons()[k].getValue() * layers[i].getNeurons()[j].getListweights()[k];
                }
                layers[i].getNeurons()[j].setValue(utils.sigmoid(sum));
            }
        }
    }

    public static void createdatatraining(){
        float[] input1 = new float[] {0,0};
        float[] input2 = new float[] {0,1};
        float[] input3 = new float[] {1,0};
        float[] input4 = new float[] {1,1};
        //using function that return 1 if variables are equals
        float[] expectedoutput1 = new float[] {1};
        float[] expectedoutput2 = new float[] {0};
        float[] expectedoutput3 = new float[] {0};
        float[] expectedoutput4 = new float[] {1};

        dataTrainings =new DataTraining[4];
        dataTrainings[0] = new DataTraining(input1, expectedoutput1);
        dataTrainings[1] = new DataTraining(input2, expectedoutput2);
        dataTrainings[2] = new DataTraining(input3, expectedoutput3);
        dataTrainings[3] = new DataTraining(input4, expectedoutput4);
    }

    public static float sumGradient(int index_neuron,int index_layer){
        float sum_gradient = 0;
        Layer current_layer = layers[index_layer];
        for (int i = 0; i < current_layer.getNeurons().length; i++){
            Neuron current_neuron = current_layer.getNeurons()[i];
            sum_gradient += current_neuron.getListweights()[index_neuron] * current_neuron.getGradient();
        }
        return sum_gradient;


    }
    public static void backwards(float rate, DataTraining dataTraining){
        int number_layers = layers.length;
        int index = number_layers -1;

        for (int i =0; i<layers[index].getNeurons().length;i++){
            float output = layers[index].getNeurons()[i].getValue();
            float target = dataTraining.getOutputexpected()[i];
            float derivation = output - target;
            float delta =derivation * (output*(1-output));
            layers[index].getNeurons()[i].setGradient(delta);
            for (int j = 0; j<layers[index].getNeurons()[i].getListweights().length;j++){
                float previous_output = layers[index-1].getNeurons()[j].getValue();
                float error = delta * previous_output;
                layers[index].getNeurons()[i].setCache_listweights_element(layers[index].getNeurons()[i].getListweights()[j] - rate*error, j);
            }
        }
        //update
        for (int i = index-1; i>0; i--){
            for (int j = 0; j<layers[i].getNeurons().length; j++){
                float output = layers[i].getNeurons()[j].getValue();
                float gradient_sum = sumGradient(j, i+1);
                float delta = gradient_sum * output * (1 - output);
                layers[i].getNeurons()[j].setGradient(delta);
                for (int k =0 ; k<layers[i].getNeurons()[j].getListweights().length; k++){
                    float previous_output = layers[i-1].getNeurons()[k].getValue();
                    float error = delta * previous_output;
                    layers[i].getNeurons()[j].setCache_listweights_element(layers[i].getNeurons()[j].getListweights()[k] - rate*error, k);

                }
            }
        }
    }
}
