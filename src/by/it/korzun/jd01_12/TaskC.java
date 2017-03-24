package by.it.korzun.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    Set createRandomSet(String type, int length){
        switch (type){
            case "Double":{
                Set<Double> set = new HashSet<>();
                for (int i = 0; i < length; i++) {
                    set.add((double)(Math.round(Math.random() * 9) + 1));
                }
                return set;
            }
            case "Integer":{
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < length; i++) {
                    set.add((int)(Math.round(Math.random() * 9) + 1));
                }
                return set;
            }
        }
        return null;
    }

    void runC1(){
        String []strObjects = ObjectNames.text.split(" ");
        Map<Integer, String> mapObjects = new TreeMap<>();
        for (int i = 0; i < strObjects.length; i++) {
            mapObjects.put(Math.abs((int)(Math.round(Math.random() * 1000000) - 5000)), strObjects[i]);
        }
        System.out.println(mapObjects);

        List<String> repeats = new ArrayList<>();
        List<Integer> keysToRemove = new ArrayList<>();

        for(Map.Entry<Integer,String> entry:mapObjects.entrySet()){
            if(repeats.contains(entry.getValue())){
                keysToRemove.add(entry.getKey());
            }else{
                repeats.add(entry.getValue());
            }
        }
        for(Integer key:keysToRemove){
            mapObjects.remove(key);
        }
        System.out.println("Без повторений значений: " + mapObjects);


    }

    void runC2(){
        MyCollectGen<Double> doubleRunner = new MyCollectGen<>();
        MyCollectGen<Integer> integerRunner = new MyCollectGen<>();
        Set set1 = createRandomSet("Double", 6);
        Set set2 = createRandomSet("Double", 6);
        Set set3 = createRandomSet("Integer", 6);
        Set set4 = createRandomSet("Integer", 6);
        System.out.println("Double: \n  " + set1 + "\n  " + set2);
        System.out.println("Integer: \n  " + set3 + "\n  " + set4);
        doubleRunner.getCrossGen(set1, set2);
        doubleRunner.getUnionGen(set1, set2);

        integerRunner.getCrossGen(set3, set4);
        integerRunner.getUnionGen(set3, set4);

        System.out.println("");
    }

    void runC3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String str = scanner.nextLine();
        scanner.close();
        Stack<Character> stack = new Stack<>();
        Pattern pattern = Pattern.compile("[{}()\\[\\]]");
        Matcher matcher = pattern.matcher(str);
        boolean okneok = true;
        while(matcher.find()){
            if(str.charAt(matcher.start()) == '{'){
                stack.push('{');
            }else if(str.charAt(matcher.start()) == '('){
                stack.push('(');
            }else if(str.charAt(matcher.start()) == '['){
                stack.push('[');
            }else{
                if(stack.isEmpty()){
                    okneok = false;
                    break;
                }else if(stack.peek() == '{'&& str.charAt(matcher.start()) == '}'){
                    stack.pop();
                }else if(stack.peek() == '('&& str.charAt(matcher.start()) == ')'){
                    stack.pop();
                }else if(stack.peek() == '['&& str.charAt(matcher.start()) == ']'){
                    stack.pop();
                }else{
                    okneok = false;
                    break;
                }
            }
        }
        if(okneok && stack.isEmpty()){
            System.out.println("Скобки расставлены правильно");
        }else
            System.out.println("Скобки расставлены неправильно");

    }

}
