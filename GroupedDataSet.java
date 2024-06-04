import java.util.Arrays;

public class GroupedDataSet {
    private double[] data;
    private int numClases;
    private double rango;
    private double amplitud;

    public GroupedDataSet(double[] data) {
        this.data = data;
        calcularRango();
        calcularNumClases();
        calcularAmplitud();
    }

    private void calcularRango() {
        rango = DiscreteMaths.calcularRango(data);
    }

    private void calcularNumClases() {
        numClases = DiscreteMaths.calcularNumeroClases(data);
    }

    private void calcularAmplitud() {
        amplitud = DiscreteMaths.calcularAmplitud(rango, numClases);
    }

    public double calculateMean() {
        double sumOfMidpointFrequency = 0;
        double sumOfFrequency = 0;
        double limiteInferior = data[0];
        double limiteSuperior = limiteInferior + amplitud;

        for (int i = 0; i < numClases; i++) {
            int frecuencia = DiscreteMaths.calcularFrecuencia(data, limiteInferior, limiteSuperior);
            double puntoMedio = (limiteInferior + limiteSuperior) / 2.0;
            sumOfMidpointFrequency += puntoMedio * frecuencia;
            sumOfFrequency += frecuencia;
            limiteInferior = limiteSuperior;
            limiteSuperior += amplitud;
        }
        return sumOfMidpointFrequency / sumOfFrequency;
    }

    public double calculateMode() {
        double maxFrequency = -1;
        double mode = Double.NaN;
        double limiteInferior = data[0];
        double limiteSuperior = limiteInferior + amplitud;

        for (int i = 0; i < numClases; i++) {
            int frecuencia = DiscreteMaths.calcularFrecuencia(data, limiteInferior, limiteSuperior);
            if (frecuencia > maxFrequency) {
                maxFrequency = frecuencia;
                mode = (limiteInferior + limiteSuperior) / 2.0;
            }
            limiteInferior = limiteSuperior;
            limiteSuperior += amplitud;
        }
        return mode;
    }

    public double calculateMedian() {
        double[] dataSorted = Arrays.copyOf(data, data.length);
        Arrays.sort(dataSorted);
        int middle = dataSorted.length / 2;
        if (dataSorted.length % 2 == 0) {
            return (dataSorted[middle - 1] + dataSorted[middle]) / 2.0;
        } else {
            return dataSorted[middle];
        }
    }
}
