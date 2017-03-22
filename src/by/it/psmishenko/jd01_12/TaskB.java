package by.it.psmishenko.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
void runB1(String s){
    Map<String,Integer> newText = new HashMap<>();
    Pattern pattern = Pattern.compile("[A-Za-z]+");
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()){
        int k =1;
        if(newText.containsKey(matcher.group())) k++;
            newText.put(matcher.group(),k);
    }

        for (Map.Entry<String,Integer> entry:newText.entrySet()){
       if(entry.getValue().equals(1)) System.out.printf("Найдено слово \"%s\", которое встречпется в тексте %d раз\n",
               entry.getKey(),entry.getValue());
    }
    Iterator<Map.Entry<String, Integer>> itr = newText.entrySet().iterator();
    int tab = 0;
    while (itr.hasNext()) {
        tab++;
        System.out.print(itr.next()+"   ");
        if(tab%10==0) System.out.println("");
    }
    System.out.println("\n---------------------------------------------------");
}
void processArray(int n){
    List<String> arList = new ArrayList<>();
    for (int i = 0; i < n ; i++) {
        arList.add("n"+(i+1));
    }
    System.out.println(arList+"   size = "+arList.size());
    while (arList.size() > 1){
        if (arList.size()%2!=0){
            int k = 0;
            int bufSize = arList.size() / 2;
            for (int i = 0; i < bufSize; i++) { // удаляем элементы через 1
                arList.remove(k + 1);
                k++;
            }
            System.out.println("NewLap: "+arList+"   size = "+arList.size());
        arList.remove(0); // если n нечётное, то на след. круге 1 элемент нужно вычёркивать по правилу игры
        }else {
            int k = 0;
            int bufSize = arList.size() / 2;
            for (int i = 0; i < bufSize; i++) { // удаляем элементы через 1
                arList.remove(k + 1);
                k++;
            }
            System.out.println("NewLap: "+arList+"   size = "+arList.size());
        }

    }
    System.out.println("Winner: "+arList);
}

void processLinked(int n){
    List<String> linkedList = new LinkedList<>();
    for (int i = 0; i < n ; i++) {
        linkedList.add("n"+(i+1));
    }
    System.out.println(linkedList +"   size = "+linkedList.size());
   while (linkedList.size() > 1){
       if(linkedList.size()%2!=0){
        int k =0;
        int bufSize = linkedList.size()/2;
        for (int i = 0; i <bufSize ; i++) { // удаляем элементы через 1
            linkedList.remove(k+1);
            k++;
        }
        System.out.println("NewLap: "+linkedList+"   size = "+linkedList.size());
        linkedList.remove(0);
       }else {
           int k =0;
           int bufSize = linkedList.size()/2;
           for (int i = 0; i <bufSize ; i++) { // удаляем элементы через 1
               linkedList.remove(k+1);
               k++;
           }
           System.out.println("NewLap: "+linkedList+"   size = "+linkedList.size());
       }
    }
    System.out.println("Winner: "+linkedList);
}
}
