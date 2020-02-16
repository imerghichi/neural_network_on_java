public class DataTraining {
    private float[] data;
    private float[] outputexpected;

    public DataTraining(float[] data, float[] outputexpected) {
        this.data = data;
        this.outputexpected = outputexpected;
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }

    public float[] getOutputexpected() {
        return outputexpected;
    }

    public void setOutputexpected(float[] outputexpected) {
        this.outputexpected = outputexpected;
    }
}
