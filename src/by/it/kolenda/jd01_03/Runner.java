package by.it.kolenda.jd01_03;


public class Runner {
    public static void main(String[] args) {
        String line= InOut.consoleReadLine();
        System.out.println(line);
        double[] a= InOut.readDoubleArrayFormLine(line);
        InOut.printDoubleArray(a,"Num",4);
        Util.sort(a);
        System.out.println("");
        InOut.printDoubleArray(a,"Num",4);

    }
}

