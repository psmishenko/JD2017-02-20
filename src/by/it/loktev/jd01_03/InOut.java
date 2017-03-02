package by.it.loktev.jd01_03;

import java.util.Scanner;

public class InOut {

    /**
     * @version 1.0
     * @return String прочитанная с консоли строка
     */
    static public String consoleReadLine()
    {
        Scanner scanner=new Scanner(System.in);
        String res=scanner.nextLine();
        return res;
    }

    /**
     * @version 1.0
     * @param line строка, состоящая из разделённых пробелами чисел
     * @return массив значений double
     */
    static double[] readDoubleArrayFromLine(String line)
    {
        line=line.trim();
        String[] strValues=line.split(" ");
        double[] res=new double[strValues.length];
        for (int i = 0; i <strValues.length ; i++) {
            res[i]=Double.parseDouble(strValues[i]);
        }
        return res;
    }

    /**
     * @version 1.0
     * @param arr одномерный массив значений double, который надо распечатать
     * @param header заголовок вывода, если null - не печатается
     * @param name название массива при выводе с showMode==3
     * @param colsCount количество колонок вывода, 0 - неограниченно
     * @param showMode режим отображения элементов: 1 - только значение, 2 - индекс и значение, 3 - имя массива, индекс и значение
     */
    static public void printDoubleArray(double [] arr, String header, String name, int colsCount, int showMode){
        if ( header!=null )
          System.out.println(header);
        for (int i = 0; i < arr.length; i++) {
            if ((colsCount>0) && (i!=0) && (i%colsCount==0))
                System.out.println("");
            double elem=arr[i];
            if (showMode==3)
              System.out.print(name);
            if (showMode!=1) {
                System.out.printf("[% -3d]=", i);
                System.out.printf("%-6.2f ", elem);
            }
            else
              System.out.printf("%6.2f ", elem);
        }
        System.out.println("");

    }

    /**
     * @version 1.0
     * @param arr двумерный массив значений double, который надо распечатать
     * @param header заголовок вывода, если null - не печатается
     * @param name название массива при выводе с showMode==3
     * @param colsCount количество колонок вывода, 0 - неограниченно
     * @param showMode режим отображения элементов: 1 - только значение, 2 - индекс и значение, 3 - имя массива, индекс и значение
     */
    static public void printDoubleArray(double [] [] arr, String header, String name, int colsCount, int showMode){
        // showMode: 1 - только значение, 2 - индекс и значение, 3 - имя массива, индекс и значение
        if ( header!=null )
            System.out.println(header);
        for (int i = 0; i < arr.length; i++) {
            printDoubleArray(arr[i],null,name+String.format("[% -3d]", i),  colsCount, showMode);
        }

    }

}
