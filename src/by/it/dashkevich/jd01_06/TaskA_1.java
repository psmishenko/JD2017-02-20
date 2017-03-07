package by.it.dashkevich.jd01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by дёня on 03.03.2017.
 */
public class TaskA_1 {
    public static void main(String[] args) {

        String text = "У лукоморья дуб зеленый; Златая цепь на дубе том: И днем и ночью кот ученый Всё ходит по цепи кругом; Идет направо — песнь заводит, Налево — сказку говорит.";

        Pattern p1 = Pattern.compile("[А-Яа-я]{4,}");  // instruction for regEx
        ArrayList<String> array = new ArrayList<>();  //words with more than 4 char
        ArrayList<StringBuilder> resArray = new ArrayList<>();  //final array with result

        Matcher m1 = p1.matcher(text);
        while(m1.find()) {
            array.add(m1.group());  // add words with more than 4 char to array
        }

        for(String r: array) {
            System.out.print(r + " ");  //out our medium result
        }
        System.out.println("");
        for(int i=0; i<array.size(); i++) {
            resArray.add(resString(array.get(i)));  //add our result to array
        }
        for(StringBuilder r: resArray) {   //out our result to console
            System.out.print(r + " ");
        }


    }
    static StringBuilder resString(String a) {
        StringBuilder res= new StringBuilder(a);
        if(a.length()<7) {
            res.setCharAt(3, '#');
        }
        if(a.length()>=7) {
            res.setCharAt(3, '#');
            res.setCharAt(6, '#');
        }
        return res;
    }
}
