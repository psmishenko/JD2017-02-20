package by.it.loktev.jd01_03;

public class Runner {

    public static void main(String[] args) {
        //String line=InOut.consoleReadLine();
        String line="2.5 -3.96 67.3 7 28";
        double [] a=InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a,"Массив A","А",3,3);

        System.out.println("Минимальное значение в массиве: "+Util.findMinValueInArray(a));
        System.out.println("Максимальное значение в массиве: "+Util.findMaxValueInArray(a));

        Util.sort(a);
        InOut.printDoubleArray(a,"Отсортированный массив A", "А",3,3);

        double [] [] aa={
                InOut.readDoubleArrayFromLine("3.33 7.77 5.5"),
                InOut.readDoubleArrayFromLine("4.33 2.7 2.5"),
                InOut.readDoubleArrayFromLine("5.33 7.0 3.5"),
                InOut.readDoubleArrayFromLine("2.33 5.2 1.589"),
        };
        InOut.printDoubleArray(aa,"Массив AA","АА",3,3);

        double [] v=InOut.readDoubleArrayFromLine("5 7 8");
        double [] [] m=
                {
                        InOut.readDoubleArrayFromLine("2 4 3"),
                        InOut.readDoubleArrayFromLine("7 1 1"),
                };
        double [] [] m2=
                {
                        InOut.readDoubleArrayFromLine("4 9"),
                        InOut.readDoubleArrayFromLine("7 1"),
                        InOut.readDoubleArrayFromLine("3 4"),
                };
        InOut.printDoubleArray(v,"Вектор V","V",3,3);
        InOut.printDoubleArray(m,"Матрица M","M",3,3);
        InOut.printDoubleArray(m2,"Матрица M2","M2",3,3);
        double [] mv=Util.arrayMulVector(m,v);
        InOut.printDoubleArray(mv,"Матрица M*V","MV",3,3);
        double [] [] mm2=Util.arrayMulVector(m,m2);
        InOut.printDoubleArray(mm2,"Матрица M*M2","MM2",3,3);

    }


}
