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
        train(10000,0.1f);

        System.out.println("after training");
        for (int i = 0; i<dataTrainings.length;i++){
            forward(dataTrainings[i].getData());
            System.out.println(layers[2].getNeurons()[0].getValue());
        }

    }

    private static void train(int i, float v) {
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
        dataTrainings[1] = new DataTraining(input1, expectedoutput1);
        dataTrainings[2] = new DataTraining(input2, expectedoutput2);
        dataTrainings[3] = new DataTraining(input3, expectedoutput3);
        dataTrainings[4] = new DataTraining(input4, expectedoutput4);
    }

}
