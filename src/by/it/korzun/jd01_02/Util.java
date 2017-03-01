package by.it.korzun.jd01_02;


class Util {
    static void bubbleSortAbs(double[] arr){
        boolean swap;
        int last = arr.length - 1;
        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(Math.abs(arr[i]) < Math.abs(arr[i+1])){
                    double buff = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                    swap = true;
                }
            }
            last--;
        }while (swap);

    }


    static void printMatrix(double[][] matrix, boolean exact){
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!exact)
                    System.out.printf("%10.3f", aMatrix[j]);
                else
                    System.out.printf("%5d", (int) aMatrix[j]);
            }
            System.out.println();
        }
    }

    /*
    static double[][] deleteByElement(double[][] matrix,double elem){
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if((int)matrix[i][j] == elem) {
                    count++;
                }
            }
        }

        int countIter = 0;
        int[] massI = new int[count];
        int[] massJ = new int[count];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if((int)matrix[i][j] == elem){
                    massI[countIter] = i;
                    massJ[countIter] = j;
                    countIter++;
                }
            }
        }
        for (int i = 0; i < massI.length; i++) {
            for (int j = i + 1; j < massI.length; j++) {
                if(massI[i] == massI[j]){
                    massI[j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < massJ.length; i++) {
            for (int j = i + 1; j < massJ.length; j++) {
                if(massJ[i] == massJ[j]){
                    massJ[j] = Integer.MAX_VALUE;
                }
            }
        }
        double[][] resMatrix = new double[matrix.length - count][matrix.length - count];
//        countIter = 0;
//        while(countIter != count) {
//            if(massJ[countIter] != Integer.MAX_VALUE) {
//                for (int i = 0; i < matrix.length - count; i++) {
//                    for (int j = 0; j < matrix[0].length - 1 - countIter; j++) {
//                        if (j >= massJ[countIter]) {
//                            resMatrix[i][j] = (int) matrix[i][j + 1 - countIter];
//                        }
//                    }
//                }
//            }
//            countIter++;
//        }
        boolean scale = false;
        int countIterI = 0;
        int countIterJ = 0;
        for(int i = 0, m = 0; m < resMatrix.length; i++, m++){
            if(countIterI < count && i == massI[countIterI]){
                i++;
                countIterI++;
                //arrMinus(massI);
            }
            for(int j = 0, k = 0; k < resMatrix.length; j++, k++){
                if(countIter < count && j == massJ[countIter] ){
                    j++;
                    scale = true;
                }
                resMatrix[m][k] = matrix[i][j];
            }
            if(scale == true){
                //arrMinus(massJ);
                countIter++;
            }
        }

        printMatrix(resMatrix, true);
        return resMatrix;
    }*/
}
