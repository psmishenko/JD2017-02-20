package by.it.loktev.jd01_04;

public class Runner {

    public static void main(String[] args) {

        double [] [] m={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2}
        };

        double [] y={20,11,40,37};

        System.out.print("\nМатрица:");
        InOut.arrayPrint(m,"M",true);

        System.out.print("\nВектор:");
        InOut.arrayPrint(y,"Y",true);

        System.out.print("\nКорни:");
        double [] roots=Util.findRoots(m,y,false);
        InOut.arrayPrint(roots,"R",true);

        System.out.print("\nПроверяем корни (должно быть равно исходному вектору):");
        double [] mt=Util.arrayMulVector(m,roots);
        InOut.arrayPrint(mt,"MT",true);

        double deter=Util.findDeterminant(m,false);
        System.out.println("\nДетерминант: "+deter);

        System.out.print("\nОбратная матрица:");
        double [] [] im=Util.inverseMatrix(m,y,false);
        InOut.arrayPrint(im,"IM",true);

        System.out.print("\nПроверяем обратную матрицу (должно быть единичной матрицей):");
        double [] [] t=Util.arrayMulVector(m,im);
        InOut.arrayPrint(t,"T",true);
    }

}
