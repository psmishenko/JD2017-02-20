package by.it.loktev.jd01_05;

public class Task6 {

    public static void task6(){

        int points=20;
        double xStart=12;
        double xEnd=77;
        //double xStep=(xEnd-xStart)/(points-1);
        double [] mas=new double[points+1];
        for ( int p=0; p<=points; p++ ){
            double x=(xEnd-xStart)*((double)p/points)+xStart;
            double y=Math.sqrt(x/3+1);
            //System.out.println(x+" "+y);
            mas[p]=y;
        }

        System.out.println("Массив mas:");
        for (int i=0; i<mas.length; i++)
            System.out.printf("mas[%2d]=%7.4f\n",i,mas[i]);

        int mas2len=0;
        for (int i=0; i<mas.length; i++)
            if ( 4<mas[i] && mas[i]<5 )
                mas2len++;
        double [] mas2=new double[mas2len];
        int mas2i=0;
        for (int i=0; i<mas.length; i++)
            if ( 4<mas[i] && mas[i]<5 )
                mas2[mas2i++]=mas[i];

        System.out.println("Массив mas2:");
        for (int i=0; i<mas2.length; i++)
            System.out.printf("mas2[%2d]=%7.4f\n",i,mas2[i]);

        int evenindcount=0;
        for (int i=0; i<mas2.length; i++)
            if (i%2==0)
                evenindcount++;
        System.out.println("В массиве mas2 чётный индекс имеют: "+evenindcount+" элементов");

        // то же без перебора - каждые 2 элемента массива содержат 1 чётный индекс
        int evenindcount2=(int)Math.ceil(mas2.length/2);
        System.out.println("В массиве mas2 чётный индекс имеют: "+evenindcount2+" элементов");


    }

}
