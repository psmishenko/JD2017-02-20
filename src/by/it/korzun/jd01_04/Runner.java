package by.it.korzun.jd01_04;


public class Runner {
    public static void main(String[] args){
        double[][] a = {
                {2, 5, 4 ,1},
                {1, 3 ,2 ,1},
                {2, 10, 9, 7},
                {3, 8, 9 ,2}
        };
        InOut.arrayPrint(a, "M", true);

        double[] y = {20, 11, 40, 37};
        InOut.arrayPrint(y, "Y", 4);

        double []roots = Util04.findRoots(a, y);
        InOut.arrayPrint(roots, "R", 5);

        Util04.checkRoots(a, roots, y);
        double[][] inv = new double[a.length][a.length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                inv[i][j] = a[i][j];
            }
        }
        Util04.inverseMatrix(inv);
        InOut.arrayPrint(inv, "Inv", true);

        Util04.checkInv(a, inv);


    }
}
