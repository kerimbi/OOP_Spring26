public class Data {
    private double sum;
    private int count;
    private double maximum;
    
    public Data() {
        sum = 0.0;
        count = 0;
        maximum = Double.NEGATIVE_INFINITY;
    }
    
    public void addValue(double value) {
        sum = sum + value;
        count = count + 1;
        
        if (count == 1) {
            maximum = value;
        } else {
            if (value > maximum) {
                maximum = value;
            }
        }
    }
    
    public double getAverage() {
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }
    
    public double getMaximum() {
        return maximum;
    }
}