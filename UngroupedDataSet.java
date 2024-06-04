import java.util.Arrays;

public class UngroupedDataSet {
    private double[] data;

    public UngroupedDataSet(double[] data) {
        this.data = data;
    }

    public double calculateMean() {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public double calculateMode() {
        Arrays.sort(data);

        int maxCount = 0;
        double mode = data[0];
        int currentCount = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mode = data[i - 1];
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            mode = data[data.length - 1];
        }

        return mode;
    }

    public double calculateMedian() {
        Arrays.sort(data);
        int middle = data.length / 2;
        if (data.length % 2 == 0) {
            return (data[middle - 1] + data[middle]) / 2.0;
        } else {
            return data[middle];
        }
    }
}
