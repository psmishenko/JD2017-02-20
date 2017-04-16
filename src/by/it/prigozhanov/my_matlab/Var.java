package by.it.prigozhanov.my_matlab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public abstract class Var implements IOperations, IVar {
    static Map<String, Var> memory = new HashMap<>();

    @Override
    public Var add(Var var) throws MatlabException {
        throw new MatlabException("Операция невозможна");
    }

    @Override
    public Var sub(Var var) throws MatlabException {
        throw new MatlabException("Операция невозможна");
    }

    @Override
    public Var div(Var var) throws MatlabException {
        throw new MatlabException("Операция невозможна");
    }

    @Override
    public Var mul(Var var) throws MatlabException {
        throw new MatlabException("Операция невозможна");
    }



    public void save(String s, Var value) {
        ValueSaver.loadedMap.put(s, value);
        ValueSaver.loadToFile(memory);
    }

    public void load(String loadedString) {

    }
}
