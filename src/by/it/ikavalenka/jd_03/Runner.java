package by.it.ikavalenka.jd_03;

/**
* Created by USER on 24.02.2017.
*/
public class Runner {
public static void main (String[] args){
//        double mean =Avg.mean(Integer);
//        System.out.println("Numbers "+mean+"less: ");
//        for (int i:Integer){
//            if (i<mean){
//                System.out.print(i+" ");
//            }
//        }
        System.out.println();
        String line=InOut.consoleReadline();
        //String line="9 8 7 6 5 4 3 2 1";
        double[] a=InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a,"A",4);
                System.out.println();
        //Arrays.sort(a);
        Unitls.sort(a);

        InOut.printDoubleArray(a,"B",4);

    System.out.println();
    System.out.println("Maximum = " + Unitls.maxInArray(a));
    System.out.println("Minimum = " + Unitls.minInArray(a));

    System.out.println();
        double [] [] k = {
                {8.0,9.0,7.0,6.0},
                {1.0,5.0,2.0,3.0}
        };


    double[][] s = {
            {9.0, 8.0},
            {6.0, 5.0},
            {3.0, 2.0},
            {5.0, 6.0}
    };
    InOut.printArrayS(k,"K");
    InOut.printDoubleArray(Unitls.arrMulVec(k,a),"H",2);
    InOut.printArrayS(Unitls.arrMulVec(k,s),"L");


//       InOut.printArrayS(second, "S");
        //System.out.println();
        //double[] a=InOut.readDoubleArrayFromLine(line);
        //InOut.printDoubleArray(a,"A",4);
        //InOut.printDoubleArray(a,"A",4);

    }

}