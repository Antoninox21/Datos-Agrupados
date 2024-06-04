import java.util.Arrays;

public class DiscreteMaths {
    public static double calcularRango(double[] data) {
        Arrays.sort(data);
        return data[data.length - 1] - data[0];
    }

    public static int calcularNumeroClases(double[] data) {
        return (int) Math.sqrt(data.length);
    }

    public static double calcularAmplitud(double rango, int numClases) {
        return rango / numClases;
    }

    public static int calcularFrecuencia(double[] data, double limiteInferior, double limiteSuperior) {
        int frecuencia = 0;
        for (double value : data) {
            if (value >= limiteInferior && value < limiteSuperior) {
                frecuencia++;
            }
        }
        return frecuencia;
    }
}
