package by.it.prigozhanov.matlab;

import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/13/2017!
 */
public class VarV extends Var {

    @Override
    public void fromString(String value) {

    }

    @Override
    public Var add(Var var) {
        System.out.println("Поймали сложение вектора с чем-то");
        return null;
    }
}
