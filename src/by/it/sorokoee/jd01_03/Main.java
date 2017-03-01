package by.it.sorokoee.jd01_03;

public class Main {

    public static void main(String[] args) {
	String line=InOut.consoleReadLine();
//
        double [] a=InOut.readDoubleArrayFromLine(line);
//        InOut.printDoubleArray(a, "A",3);
//        Util.sort(a);
//        InOut.printDoubleArray(a, "A",3);

        InOut.printDoubleArray(Util.sortDoubleArr(a,true),"a",3);
//
//        System.out.println("MAX="+Util.maxDoubleArray(a));
//        System.out.println("MIN="+Util.minDoubleArray(a));
//        System.out.println();
//        double arr [][]= {
//                {1.0, 2.0, 3.0, 4.0, 5.0,},
//                {6.0, 7.0, 8.0, 9.0, 10.0},
//                {4.0, 2.0, 5.0, 7.0, 8.0,},
//                {1.0, 2.0, 7.0, 4.0, 3.0,},
//        };


//        InOut.printArray2D(arr,"A");

//        InOut.printDoubleArray(Util.arrayMulVector(arr,a),"A",2);
//InOut.printArray2D(Util.arrayMulArray(arr,arr),"A");




    }
}
