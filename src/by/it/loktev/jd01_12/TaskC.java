package by.it.loktev.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    private class Elem{
        private int ident;
        private String name;

        public Elem(int ident, String name) {
            this.ident = ident;
            this.name = name;
        }

        @Override
        public String toString() {
            return ident + "/" + name;
        }
    }

    private class MyIterator implements Iterator
    {
        int i; // какой элемент будет возвращён при следующем вызове next
        List<Elem> list;

        public void start(List<Elem> list){
            this.i = 0;
            this.list=list;
        }

        @Override
        public boolean hasNext() {
            return i<list.size();
        }

        @Override
        public Elem next() {
            //System.out.println("!!!");
            return list.get(i++);
        }

        @Override
        public void remove() {
           list.remove(i-1);
        }

    }

    void runC1() {

        String text = "хлеб батон курица хлеб молоко мясо водка компот сок курица";

        String[] namesArray = text.split("[^a-zA-Zа-яА-ЯёЁ]+");
        System.out.println("Наименования:");
        System.out.println(Arrays.toString(namesArray));

        ArrayList<Elem> elems=new ArrayList<Elem>(){
            @Override
            public Iterator<Elem> iterator() {
                MyIterator myIterator=new MyIterator();
                myIterator.start(this);
                return myIterator;
            }
        };

        // пусть шифром будет hashCode строки наименования; он не совсем уникальный, но для целей задания подойдёт
        for ( String name : namesArray ){
            int ident=name.hashCode();
            elems.add(new Elem(ident,name));
        }
        System.out.println("Исходный список - шифры + наименования");
        System.out.println(elems);

        Comparator<Elem> comp=new Comparator<Elem>() {
            @Override
            public int compare(Elem e1, Elem e2) {
                return e1.ident-e2.ident;
            }
        };
        Collections.sort(elems,comp);
        System.out.println("Список, отсортированный по шифрам:");
        System.out.println(elems);

        TreeSet<String> usedNames=new TreeSet<String>(); // будем использовать этот сет для контроля повторяемости имён
        Iterator<Elem> it=elems.iterator();
        while ( it.hasNext() ){
            Elem elem=it.next();
            if (usedNames.contains(elem.name)){
                it.remove();
            }
            else{
                usedNames.add(elem.name);
            }

        }
        System.out.println("Список после удаления повторяющихся наименований:");
        System.out.println(elems);
    }

    void runC2(int num, boolean showDebug){

        // проверять будем на String

        MyGenericCollect<String> myStringCollect=new MyGenericCollect<String>();

        Set<String> a=new HashSet<>();
        Set<String> b=new HashSet<>();

        for (int i = 0; i < 8; i++) {
            String value="$"+(int)Math.floor(Math.random()*10+1);
            a.add(value);
        }
        System.out.println("Первый список: "+a);

        for (int i = 0; i < 8; i++) {
            String value="$"+(int)Math.floor(Math.random()*10+1);
            b.add(value);
        }
        System.out.println("Второй список: "+b);

        Set<String> c=myStringCollect.getUnion(a,b);
        System.out.println("Объединение: "+c);

        Set<String> d=myStringCollect.getCross(a,b);
        System.out.println("Пересечение: "+d);

    }

    /**
     * @version 1.0
     * @param str - строка, в которой нужно проверить расстановку скобок
     * @return boolean - правильно ли расставлены скобки
     */
    private boolean checkBrackets(String str){

        Stack<String> openedBrackets=new Stack<>();

        Matcher bracketsMatcher=Pattern.compile("[\\(\\)\\[\\]\\{\\}]").matcher(str);
        while (bracketsMatcher.find()){
            String bracket=bracketsMatcher.group();
            switch (bracket)
            {
                case "(":
                case "[":
                case "{":
                    openedBrackets.push(bracket);
                    break;
                case ")":
                    if ( (openedBrackets.size()==0) || !openedBrackets.pop().equals("(") )
                        return false;
                    break;
                case "]":
                    if ( (openedBrackets.size()==0) || !openedBrackets.pop().equals("[") )
                        return false;
                    break;
                case "}":
                    if ( (openedBrackets.size()==0) || !openedBrackets.pop().equals("{") )
                        return false;
                    break;
            }
        }
        if (openedBrackets.size()>0)
            return false; // не все скобки закрыты
        return true;
    }

    void runC3(){

        String s1="hello ( ) goodbye [] hello {} goodbye";
        String s2="hello ( goodbye [ hello { berry } goodbye ] field ) forever";
        String s3="hello ( goodbye [ hello ] berry { goodbye } field ) forever";
        String s4="(([[{{}}]]))";
        String s5="([)]";
        String s6="([)";
        String s7="";
        String s8=")";

        System.out.println("строка: "+s1+", скобки расставлены "+(checkBrackets(s1)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s2+", скобки расставлены "+(checkBrackets(s2)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s3+", скобки расставлены "+(checkBrackets(s3)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s4+", скобки расставлены "+(checkBrackets(s4)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s5+", скобки расставлены "+(checkBrackets(s5)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s6+", скобки расставлены "+(checkBrackets(s6)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s7+", скобки расставлены "+(checkBrackets(s7)?"правильно":"НЕправильно"));
        System.out.println("строка: "+s8+", скобки расставлены "+(checkBrackets(s8)?"правильно":"НЕправильно"));

    }


}
