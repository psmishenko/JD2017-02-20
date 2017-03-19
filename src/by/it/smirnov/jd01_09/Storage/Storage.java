package by.it.smirnov.jd01_09.Storage;

import by.it.smirnov.jd01_09.Vars.Var;

import java.util.*;

/**
 * Created by aleksey.smirnov on 17.03.2017.
 */
public class Storage implements IStorage {
    private HashMap<String,Var> hm;

    public Storage() {
        hm = new HashMap<>();
    }

    @Override
    public void setMap(String key, Var value) {
        hm.put(key, value);
    }

    @Override
    public Var getValue(String key) {
        return hm.get(key);
    }

    @Override
    public String getListKey() {
        StringBuilder sb = new StringBuilder("Список созданных в ходе присваивания переменных:\n");
        Set<Map.Entry<String, Var>> setv = hm.entrySet();
        Iterator<Map.Entry<String, Var>> i =setv.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Var> me= i.next();
            sb.append(me.getKey()+"\n");
        }
        return sb.toString();
    }

    @Override
    public String getSortListKeyValue() {
        StringBuilder sb = new StringBuilder("Список имен и значений переменных (сортировка по алфавиту методами коллекций):\n");
        TreeMap<String,Var> tm = new TreeMap<>(hm);
        Set<Map.Entry<String, Var>> setv = tm.entrySet();
        Iterator<Map.Entry<String, Var>> i =setv.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Var> me= i.next();
            sb.append(me.getKey()+" = "+me.getValue()+"\n");
        }
        return sb.toString();
    }
}
