package by.it.smirnov.jd01_09.Storage;

import by.it.smirnov.jd01_09.Vars.Var;

/**
 * Created by aleksey.smirnov on 17.03.2017.
 */
public interface IStorage {
    void setMap(String key, Var value);
    Var getValue(String key);
    String getListKey();
    String getSortListKeyValue();
}
