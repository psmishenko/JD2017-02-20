package by.it.loktev.jd01_04;

public class InOut {

    static public void arrayPrint(double [] [] m, String name, boolean showIndex){
        System.out.println("");
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j <m[i].length ; j++) {
                if (showIndex)
                    System.out.print(name+"["+i+","+j+"]=");
                System.out.printf("%-8.4f ",m[i][j]);
            }
            System.out.println("");
        }
    }

    static public void arrayPrint(double [] m, String name, boolean showIndex){
        System.out.println("");
        for (int i = 0; i <m.length ; i++) {
                if (showIndex)
                    System.out.print(name+"["+i+"]=");
                System.out.printf("%-8.4f ",m[i]);
        }
        System.out.println("");
    }
}
