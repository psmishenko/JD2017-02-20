package by.it.loktev.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        System.out.print("Введите числа: ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] strArr = line.split(" ");
        int Len = strArr.length;
        int[] intArr = new int[Len];
        for (int i = 0; i < Len; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 A 1");
        System.out.println("===================");

        int MaxLen = 0;
        int MinLen = Integer.MAX_VALUE;
        String MinValue = "";
        String MaxValue = "";
        int SumLength = 0;
        for (int i = 0; i < Len; i++) {
            int strLen = strArr[i].length();
            if (strLen > MaxLen) {
                MaxLen = strLen;
                MaxValue = strArr[i];
            }
            if (strLen < MinLen) {
                MinLen = strLen;
                MinValue = strArr[i];
            }
            SumLength += strLen;
        }
        System.out.println("Максимальная длина " + MaxLen + " у числа " + MaxValue);
        System.out.println("Минимальная длина " + MinLen + " у числа " + MinValue);

        System.out.println("===================");
        System.out.println("Задание JD01_02 A 2");
        System.out.println("===================");

        float AverLen=(float)SumLength/Len;
        for (int i=0; i<Len; i++)
        {
            int strLen=strArr[i].length();
            if ( strLen<AverLen )
                System.out.println("Длина числа "+strArr[i]+" меньше чем среднее "+AverLen);
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 A 3");
        System.out.println("===================");

        for (int i=0; i<Len; i++)
        {
            char [] usedDigits={0,0,0,0,0,0,0,0,0,0};
            String val=strArr[i];
            int len=val.length();
            int diffcount=0;
            //System.out.println(val);
            for ( int ci=0; ci<len; ci++ )
            {
                String c=val.substring(ci,ci+1);
                int n=Integer.parseInt(c);
                //System.out.println(n);
                if ( usedDigits[n]>0 )
                    break;
                usedDigits[n]++;
                diffcount++;
            }
            if ( diffcount==len ) {
                System.out.println("Число " + val + " состоит только из различных цифр");
                break; // нужно только самое первое такое число
            }
        }

    }
}
