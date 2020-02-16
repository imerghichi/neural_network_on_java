public class Layer {
    private Neuron[] neurons;

    public Layer(int inNeurons, int numberNeurons) {
        this.neurons = new Neuron[numberNeurons];
        for (int i = 0; i<numberNeurons; i++){
            float[] weight = new float[inNeurons];
            for (int j = 0;j<inNeurons;j++){
                Utils utils = new Utils();
                weight[j] = utils.random_float(Neuron.maximValue,Neuron.minimValue);
            }
            Utils utils = new Utils();
            neurons[i] = new Neuron(weight,utils.random_float(0,1));
        }
    }

    public Layer(float input[]) {
        this.neurons = new Neuron[input.length];
        for (int i = 0; i <input.length; i++){
            this.neurons[i] = new Neuron(input[i]);
        }
    }

    public Neuron[] getNeurons() {
        return neurons;
    }
}
