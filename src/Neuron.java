public class Neuron {
    public static float minimValue;
    public static float maximValue;

    private float[] listweights;
    private float[] cache_listweights;
    private float gradient;
    private float biais;
    private float value = 0;

    public Neuron(float[] listweights, float biais) {
        this.listweights = listweights;
        this.biais = biais;
        this.cache_listweights = this.listweights;
        this.gradient = 0;
    }

    public Neuron(float value) {
        this.listweights = null;
        this.biais = -1;
        this.cache_listweights = null;
        this.gradient = -1;
        this.value = value;
    }

    public static void setRangeValue(float minimValue, float maximValue) {
        Neuron.minimValue = minimValue;
        Neuron.maximValue = maximValue;
    }
    public void update_weight(){
        this.listweights = this.cache_listweights;
    }

    public static float getMinimValue() {
        return minimValue;
    }

    public static void setMinimValue(float minimValue) {
        Neuron.minimValue = minimValue;
    }

    public static float getMaximValue() {
        return maximValue;
    }

    public static void setMaximValue(float maximValue) {
        Neuron.maximValue = maximValue;
    }

    public float[] getListweights() {
        return listweights;
    }

    public void setListweights(float[] listweights) {
        this.listweights = listweights;
    }

    public float[] getCache_listweights() {
        return cache_listweights;
    }

    public void setCache_listweights(float[] cache_listweights) {
        this.cache_listweights = cache_listweights;
    }

    public void setCache_listweights_element(float element, int index) {
        this.cache_listweights[index] = element;
    }
    public float getGradient() {
        return gradient;
    }

    public void setGradient(float gradient) {
        this.gradient = gradient;
    }

    public float getBiais() {
        return biais;
    }

    public void setBiais(float biais) {
        this.biais = biais;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
