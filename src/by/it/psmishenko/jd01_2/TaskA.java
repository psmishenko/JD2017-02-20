package by.it.psmishenko.jd01_2;


public class TaskA {
    // #1
    static String getMax(int array[]) {
        Integer eqmax = 0;
        for (Integer i: array) {
            if (eqmax.toString().length()<i.toString().length())
                eqmax = i;
        }
        return "Макс. длина у элемента - "+eqmax.toString()+" , его длина - "+eqmax.toString().length();
    }
    static  String getMin (int array[]) {
        Integer eqmin = Integer.MAX_VALUE;
        for (Integer i: array) {
            if (eqmin.toString().length()>i.toString().length())
                eqmin= i;
        }
        return "Мин. длина у элемента - "+eqmin.toString()+" , его длина - "+eqmin.toString().length();
    }
    // #2 (вычисл ср. арифм)
    static double mean (int array[]){
        double eq = 0;
        for (int i : array) {
            eq+=i;
        }
        eq/=array.length;
        return eq;
    }

    static boolean uniqueDigits (Integer val){
        char ch[]=val.toString().toCharArray();
        for (int i = 0; i <ch.length ; i++)
            for (int j = i+1; j <ch.length ; j++)
                if(ch[i] == ch[j]) return false;
        return true;
    }


}
