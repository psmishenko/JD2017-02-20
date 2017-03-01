package by.it.akhmelev.jd01_04;

public class Runner {
    public static void main(String[] args) {
        double[][] a={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2},
        };

        double[] y={20,11,40,37};
        double[] x666= Util.findRoots(a,y,false);

        InOut.arrayPrint(x666,"X",4);


    }

}
