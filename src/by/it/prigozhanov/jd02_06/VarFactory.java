package by.it.prigozhanov.jd02_06;

/**
 * Created by v-omf on 4/15/2017.
 *
 * @author v-omf
 */
public class VarFactory{
    public static Var createVar(String var){
        if (var.matches(Expressions.VALUE)) {
            return new VarValue(var);
        } else
        if (var.matches(Expressions.VECTOR)) {
            return new VarVector(var);
        } else
        if (var.matches(Expressions.MATRIX)) {
            return new VarMatrix(var);
        } else if (var.matches(Expressions.VARIABLE)) {
            if (ValueSaver.loadedMap.size()==0) {
                ValueSaver.uploadFromFile();
            }
            return ValueSaver.loadedMap.get(var);
        }
        return null;
    }
}
