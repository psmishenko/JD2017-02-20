package by.it.smirnov.jd02_06_matlab.Vars;

/**
 * Created by aleksey.smirnov on 12.04.2017.
 */
import by.it.smirnov.jd02_06_matlab.Error.MatLabException;
import by.it.smirnov.jd02_06_matlab.Parser.Patterns;
import by.it.smirnov.jd02_06_matlab.Storage.SingleStorage;

import java.util.regex.Pattern;

public class VarCreator {

    private static VarCreator instance;

    private VarCreator(){

    }

    public static VarCreator getInstance(){
        if (instance==null){
            instance=new VarCreator();
        }
        return instance;
    }

    /**
     * Функция преобразования строки в Var
     * @param x строка
     * @return Var
     */
    public Var create(String x) throws MatLabException{
            Pattern p = Pattern.compile(Patterns.exMat);
            if (p.matcher(x).matches()) {
                return new VarM(x);
            } else {
                p = Pattern.compile(Patterns.exVec);
                if (p.matcher(x).matches()) {
                    return new VarV(x);
                } else {
                    p = Pattern.compile(Patterns.exVal);
                    if (p.matcher(x).matches()) {
                        return new VarF(x);
                    } else {
                        return SingleStorage.getInstance().getValue(x);
                    }
                }
            }


    }

}