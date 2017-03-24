package by.it.korzun.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProcessArray {
    static void run(int n){
        List<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(i + 1);
        }

        long startTime = System.currentTimeMillis();
        while (arrayList.size() != 1) {
            for(Iterator<Integer> it = arrayList.iterator(); it.hasNext();){
                it.next();
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }
        System.out.println("ArrayList закончил за " + (System.currentTimeMillis() - startTime));

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }

        startTime = System.currentTimeMillis();
        while (arrayList.size() != 1){
            for(Iterator<Integer> it = linkedList.iterator(); it.hasNext();){
                it.next();
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }
        System.out.println("LinkedList закончил за " + (System.currentTimeMillis() - startTime));
    }
}
