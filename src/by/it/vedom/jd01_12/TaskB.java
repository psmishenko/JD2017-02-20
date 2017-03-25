package by.it.vedom.jd01_12;

import java.util.*;

public class TaskB {

    private static int defaultStep = 2;
    private static int defaultIndex = defaultStep;

    private static List<Integer> reformatList(List<Integer> list, int idx) {
        if (list.size() == 1) {
            return list;
        }

        if (idx > list.size())
            return reformatList(list, idx - list.size());

        System.out.print(list.get(idx - 1) + ", ");
        list.remove(idx - 1);

        return reformatList(list, defaultStep + idx - 1);
    }


    private static class Timer {
        private long iniTime;
        private Double Delta;
        public Timer() {iniTime = System.nanoTime();}
        public String toString() {
            Delta = ((double) System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "Прошло " +Delta.toString()+ " микросекнд";
        }
    }

    public static void prn (Object o) {
        System.out.println(o.toString());
    }


    //Задать текст на английском языке (100+ слов). Вывести все различные слова.
    // Для каждого слова подсчитать частоту его встречаемости. Слова, с различным регистром букв - разные.

    public static void main(String[] args) {


        String text = "Though it was winter Vadim Petrovich, the agronomist of the farm, had a busy day last Tuesday.\n" +
                "He began his morning with the radio, he listened to the news. At half past seven he got up, washed, did his morning exercises at an open window, dressed and had breakfast.\n" +
                "Vadim Petrovich likes mornings, because he can see his family, and he can have a talk with his wife and children.\n" +
                "At a quarter to nine Vadim Petrovich left home. It was a cold winter day. There was a lot of snow on the ground. The sky wasn't blue, and the sun didn't shine at all. There weren't any people in the street.\n" +
                "Vadim Petrovich went to the farm. It is not far from his house, so he walks there. The road was white with snow and he couldn't walk fast. When he came to the farm, some people wanted to see and talk to him. His working day began. At 1 o'clock he went home to have dinner. He had dinner with his wife and little daughter who does not go to school. He ate his dinner, rested a little, and went back to the farm. Vadim Petrovich had to talk to some people, to write some letters, and to do some other work.\n" +
                "At 5 o'clock he had an important meeting. And only at 8 o'clock he came home.";

        String words[] = text.split("[^a-zA-Zа-яА-ЯёЁ]+");
        Arrays.toString(words);

        List<String> listOfWords= Arrays.asList(words);
        System.out.println("Полный список слов в List: \n" +listOfWords);
        System.out.println("Всего слов: " +listOfWords.size());

        TreeSet<String> diffWords=new TreeSet<>(listOfWords);
        System.out.println("\nВсе различные слова: \n" +diffWords);
        System.out.println("Всего различных слов: " +diffWords.size());


//       Старинный способ
//        System.out.println("Частота слов: ");
//        for (int i = 0; i < words.length; i++) {
//            int count = 0;
//            for (int j = i+1; j < words.length; j++) {
//                if (words[i].toString().equals(words[j]))
//                    count++;
//            }
//            System.out.printf("%s-%d, ", words[i], count);
//        }

        HashMap<String, Integer> countOfWords = new HashMap<String, Integer>();
        for (String temp: listOfWords) {
            Integer c = countOfWords.get(temp);
            if(c == null) c = 0;
            c++;
            countOfWords.put(temp, c);
        }
        System.out.println("\nЧастота слов:");
        System.out.println(countOfWords);



        //В кругу N человек. Пронумерованных от 1 до N. Каждую итерацию вычеркивается каждый 2 человек.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите количество человек N: ");
        int n = scanner.nextInt();
        Timer timerForArrayList = new Timer();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new Integer(i));
        }
        System.out.println("Исходное количество людей: " +list);
        List<Integer> result = reformatList(list, defaultIndex);
        // С маленьким списком лучше справляется ArrayList, до 300 элементов.
        // Однако, когда вводил N = 1500 разница в скорости LinkedList ощутимее почти в 2 раза.
        System.out.println("result: " + result+ "Время обработки: \n" +timerForArrayList);

        Timer timerForLinkedList = new Timer();
        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list1.add(new Integer(i));
        }
        System.out.println("Исходное количество людей: " +list1);
        List<Integer> result1 = reformatList(list1, defaultIndex);
        System.out.println("result: " + result + "Время обработки: \n" +timerForLinkedList);
    }

}
