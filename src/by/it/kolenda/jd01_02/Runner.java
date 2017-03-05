package by.it.kolenda.jd01_02;

import java.util.Scanner;

/**
 * Created by user on 22.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        System.out.println(line+"!");
        String[] strArr=line.split(" ");

        int n=strArr.length;
        int [] intArr=new int[n];

        for (int i=0;i<n;i++) {

            intArr[i] = Integer.parseInt(strArr[i]);
//            System.out.println("intArr[" + i + "]=" + intArr[i]);
        }
         int maxLen=0;
         int minLen=Integer.MAX_VALUE;

         for (int i=0;i<n;i++){
             int len=strArr[i].length();
             if (len>maxLen)
                maxLen=len;
             if (len<minLen)
                 minLen=len;
         }
         System.out.println("maxLen="+maxLen+" minLen="+minLen);

        int sum=0;
        for (int i=0; i<n; i++) {
            sum=sum+intArr[i];

        };
        double m=((double)sum)/n;
        for (int i = 0; i < n; i++) {
            if (strArr[i].length() < m){
                System.out.println(intArr[i]);

            }

        }

        }

}
