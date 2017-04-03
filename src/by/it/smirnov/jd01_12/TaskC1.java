package by.it.smirnov.jd01_12;

import java.util.*;

/**
 * Класс построения списка, элементы которого содержат наименования и шифры данных объектов,
 * причем элементы списка должны быть упорядочены по возрастанию шифров (шифр – некоторое уникальное число).
 * Затем «сжать» список, удаляя дублирующиеся наименования объектов.
 * @version 1.0.0
 */
public class TaskC1 {
    private Set<TaskC1Element> ts;

    /**
     * Конструктор
     */
    public TaskC1(){
        ts = new TreeSet<TaskC1Element>(
                new Comparator<TaskC1Element>() {
                    @Override
                    public int compare(TaskC1Element o1, TaskC1Element o2) {
                        return o1.getBarcode() - o2.getBarcode();
                    }
                }
        ){
            public String toString() {
                StringBuilder sb = new StringBuilder();
                Iterator<TaskC1Element> it = this.iterator();
                while (it.hasNext()) sb.append(it.next());
                return sb.toString();
            }
        };
    }
    /**
     * Функция добавления элементов в список
     * @param name наименование
     * @param barcode шифр
     * @version 1.0.0
     */
    public void add(String name, Integer barcode){
        ts.add(new TaskC1Element(name,barcode));
    }

    /**
     * Функция печати отсортированного списка
     * @version 1.0.0
     */
    public void printList(){
        System.out.println(this);
    }

    /**
     * Функция "сжатия" списка, путем удаления дублирующиеся наименования объектов
     * @version 1.0.0
     */
    public void printListUniqueName(){
        Map<String,Integer> tm = new HashMap<String,Integer>(){
            public String toString() {
                StringBuilder sb = new StringBuilder();
                Set<Map.Entry<String,Integer>> setv = this.entrySet();
                Iterator<Map.Entry<String,Integer>> it = setv.iterator();
                while (it.hasNext()) {
                    Map.Entry<String,Integer> me = it.next();
                    sb.append("Наименование='" + me.getKey() + '\'' +
                            ", Шифр=" + me.getValue() + '\n');
                }
                return sb.toString();
            }
        };

        Iterator<TaskC1Element> it = ts.iterator();
        while (it.hasNext()) {
            TaskC1Element element = it.next();
            if (!tm.containsKey(element.getName()))
              tm.put(element.getName(), element.getBarcode());
        }
        System.out.println(tm);
    }

    @Override
    public String toString() {
        return ts.toString();
    }
}
