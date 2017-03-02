package by.it.loktev.jd01_05;

import java.util.Arrays;

public class Task7 {

    public static void task7(){

        int elems=20;

        // задание сформулировано очень неоднозначно касательно вывода в виде строк, столбцов и прочее
        // что такое строка, столбец? это в символах, и надо определять минимально необходимое
        // количество СИМВОЛОВ для вывода? я реализовал именно так
        // ограничение на количество строк и столбцов касается ограничения ВЫВОДИМЫХ элементов,
        // т.е. надо выводить не все? я реализовал именно так
        // или в смысле что одномерный массив надо печатать в виде прямоугольной таблицы?
        // и автоматом высчитывать количество строк при заданном количестве столбцов и наоборот?
        // это нетрудно - например int maxrows=5; int cols=Math.ceil(arr.length/double(maxrows))

        double [] C=new double[elems+1];

        for (int i=0; i<=elems; i++){
            double a=Math.PI*2/elems*i;
            double f=Math.cos(a)*12; // амплитуду берём не 4 а 12, а то неинтересно
            C[i]=Math.round(f*10)/10;
        }

        // будем печатать максимум не 5 а 13 строк, иначе неинтересно
        printVertArray("C",C,13, 1);

        // посчитаем, сколько элементов будет в массиве B
        int countB=0;
        for (int i=0; i<=elems; i++){
            if ( Math.abs(C[i])<=i )
                countB++;
        }

        double [] B=new double[countB];
        int indexB=0;
        for (int i=0; i<=elems; i++){
            if ( Math.abs(C[i])<=i )
                B[indexB++]=C[i];
        }

        Arrays.sort(B);
        reverseArray(B); // это просто трындец! в Java нельзя отсортировать массив по убыванию?
        printVertArray("B",B,100, 1);
        printHorzArray("B",B,5, 1);

    }

    public static void reverseArray(double [] a)
    {
        for (int i = 0, j = a.length - 1; i < j; i++, j--)
        {
            double t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static String charRepeat(char c, int count){
        StringBuffer s=new StringBuffer("");
        for (int i=0; i<count; i++)
            s.append(c);
        return s.toString();
    }

    public static int getMaxIntLen(double [] arr, int maxIndex)
    {
        // определяем, сколько нужно позиций на целую часть
        int intPartLen=1;
        for ( int i=0; i<=maxIndex; i++ ) {
            int intValue=(int) arr[i];
            int intValueLen=((intValue<0)?1:0) + (int) Math.ceil(Math.log10(Math.abs(intValue)));
            intPartLen = Math.max(intPartLen, intValueLen);
        }
        return intPartLen;
    }

    public static void printVertArray(String name, double [] arr, int maxRows, int fractLen){

        // определяем, сколько нужно позиций на индекс
        int maxIndex=Math.min(maxRows,arr.length)-1;
        int indexLen=(int)Math.ceil(Math.log10(maxIndex));

        // определяем, сколько нужно позиций на целую часть
        int intPartLen=getMaxIntLen(arr,maxIndex);

        String divider="|-"+charRepeat('-',name.length())+"-"+charRepeat('-',indexLen)+"--"+charRepeat('-',intPartLen+fractLen+1)+"-|";
        System.out.println("\n"+divider);
        System.out.println("| Массив "+name+charRepeat(' ',divider.length()-name.length()-10)+"|");
        System.out.println(divider);
        for ( int i=0; i<=maxIndex; i++ )
            System.out.println("| "+name+"["+String.format("%"+indexLen+"d",i)+"]="+String.format("%"+(intPartLen+fractLen+1)+"."+fractLen+"f",arr[i])+" |");
        System.out.println(divider);
    }

    public static void printHorzArray(String name, double [] arr, int maxCols, int fractLen){

        int maxIndex=Math.min(maxCols,arr.length)-1;

        // определяем, сколько нужно позиций на целую часть
        int intPartLen=getMaxIntLen(arr,maxIndex);

        StringBuffer vs=new StringBuffer("|");
        for ( int i=0; i<=maxIndex; i++ ){
            if (i>0)
                vs.append(" |");
            vs.append(" "+name+"["+i+"]="+String.format("%"+(intPartLen+fractLen+1)+"."+fractLen+"f",arr[i]));
        }
        vs.append(" |");

        String divider="|"+charRepeat('-',vs.length()-2)+"|";

        System.out.println("\n"+divider);
        System.out.println("| Массив "+name+charRepeat(' ',divider.length()-name.length()-10)+"|");
        System.out.println(divider);
        System.out.println(vs);
        System.out.println(divider);

    }

}
