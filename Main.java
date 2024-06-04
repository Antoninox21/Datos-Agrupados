public class Main {
    public static void main(String[] args) {
        double[] data = {98,92,97,94,95,95,93,95,95,95,91,82,91,85,90,86,87,89,87,89};

        if (data.length > 30) {
            GroupedDataSet groupedDataSet = new GroupedDataSet(data);
            System.out.println("Datos agrupados:");
            System.out.println("Media: " + groupedDataSet.calculateMean());
            System.out.println("Moda: " + groupedDataSet.calculateMode());
            System.out.println("Mediana: " + groupedDataSet.calculateMedian());
        } else {
            UngroupedDataSet ungroupedDataSet = new UngroupedDataSet(data);
            System.out.println("Datos no agrupados:");
            System.out.println("Media: " + ungroupedDataSet.calculateMean());
            System.out.println("Moda: " + ungroupedDataSet.calculateMode());
            System.out.println("Mediana: " + ungroupedDataSet.calculateMedian());
        }
    }
}
