package by.it.loktev.jd01_12;

import java.util.*;

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

    void runC1() {

        String text = "хлеб батон курица хлеб молоко мясо водка компот сок курица";

        String[] namesArray = text.split("[^a-zA-Zа-яА-ЯёЁ]+");
        System.out.println("Наименования:");
        System.out.println(Arrays.toString(namesArray));

        ArrayList<Elem> elems=new ArrayList<>();

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

        TreeSet<String> usedNames=new TreeSet<>(); // будем использовать этот сет для контроля повторяемости имён
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

    void runC2(){

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


}
