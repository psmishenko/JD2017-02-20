package by.it.loktev.jd01_12;

import java.util.*;

public class TaskB {

    void runB1(){

        String text="What is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "Why do we use it?\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                "Where does it come from?\n" +
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.\n" +
                "Where can I get some?\n" +
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";

        String [] wordsArray=text.split("[^a-zA-Zа-яА-ЯёЁ]+");
        System.out.println("Полный список слов (массив):");
        System.out.println(Arrays.toString(wordsArray));

        List<String> wordsList=Arrays.asList(wordsArray);
        System.out.println("Полный список слов (List):");
        System.out.println(wordsList);

        // получаем все различные слова
        HashSet<String> diffWords=new HashSet<String>(wordsList);
        System.out.println("Различные слова:");
        System.out.println(diffWords);

        // получаем частоту слов
        HashMap<String,Integer> countWords=new HashMap<String,Integer>();
        for ( String word : wordsList ){
            Integer freq=countWords.get(word);
            if ( freq==null )
                freq=0;
            freq++;
            countWords.put(word,freq);
        }
        System.out.println("Частота слов:");
        System.out.println(countWords);


    }

    // я описал параметризованный метод вместо двух - processArray и processLinked, это яснее и не нарушает DRY, недостатков не вижу
    // вряд ли можно было итерирование+remove сделать быстрее, пользуясь какими-либо специфичными для ArrayList или LinkedList методами
    <T extends List> void processList(T list, int N, boolean debug){

        // заполним список номерами людей
        for (int i = 1; i <=N ; i++) {
            list.add(new Integer(i));
        }
        if (debug) {
            System.out.println("Исходное положение: " + list);
        }

        int pos=0;
        while( list.size()>1 ) {
            Iterator<Integer> it=list.iterator();
            while (it.hasNext()) {
                Integer num = it.next();
                pos++;
                if (pos % 2 == 0) {
                    it.remove();
                    if (debug) {
                        System.out.println("Удаляем: " + num + ", осталось: " + list);
                    }
                }
            }
        }
    }

    class TimeCheck{
        private long prevTime;
        TimeCheck(){
            prevTime=System.nanoTime();
        }
        int check(){
            long time=System.nanoTime();
            long interval=time-prevTime;
            prevTime=time;
            return (int)interval/1000;
        }
    }

    void runB2(){

        System.out.println("=== ArrayList, N=10");
        processList(new ArrayList<Integer>(),10,true);
        System.out.println("=== LinkedList, N=10");
        processList(new LinkedList<Integer>(),10,true);

        System.out.println("=== Замер скорости:");
        TimeCheck timeCheck=new TimeCheck();
        processList(new ArrayList<Integer>(),10,false);
        int AL1=timeCheck.check();
        processList(new LinkedList<Integer>(),10,false);
        int LL1=timeCheck.check();
        processList(new ArrayList<Integer>(),1000,false);
        int AL3=timeCheck.check();
        processList(new LinkedList<Integer>(),1000,false);
        int LL3=timeCheck.check();
        processList(new ArrayList<Integer>(),100000,false);
        int AL5=timeCheck.check();
        processList(new LinkedList<Integer>(),100000,false);
        int LL5=timeCheck.check();

        System.out.println("ArrayList, N=10 - "+AL1+" мс");   // 40-60 мс
        System.out.println("LinkedList, N=10 - "+LL1+" мс");  // 30-70 мс
        // для N=10 результаты почти одинаковы, т.к. списки малы и ArrayList.remove не успевает повлиять на скорость
        System.out.println("ArrayList, N=1000 - "+AL3+" мс");   // 2000-6900
        System.out.println("LinkedList, N=1000 - "+LL3+" мс");  // 2000-3800
        // для N=1000 результаты сравнимы, ArrayList.remove успевает слегка повлиять на скорость
        System.out.println("ArrayList, N=100_000 - "+AL5+" мс");   // 853000-893000
        System.out.println("LinkedList, N=100_000 - "+LL5+" мс");  // 38000-47000
        // для N=100_000 результаты сильно отличаются, ArrayList.remove для большого массива дорог, LinkedList.remove дешёв
        // стоимость доступа к i-му элементу в LinkedList сильно больше чем в ArrayList, но мы перебираем LinkedList итератором, т.е. доступ по индексу не требуется

    }

}
